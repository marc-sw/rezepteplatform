package de.hwg_lu.bwi520.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

import de.hwg_lu.bwi520.ImageAccess;
import de.hwg_lu.bwi520.bean.RezeptErstellenBean;
import de.hwg_lu.bwi520.model.Rezept;


@WebServlet("/RezeptServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,
		  maxFileSize = 1024 * 1024 * 10,     
		  maxRequestSize = 1024 * 1024 * 100
		)  
public class RezeptServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public RezeptServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RezeptErstellenBean bean = RezeptErstellenBean.fromRequest(request);
    	if (request.getParameter("zutatHinzufuegen") != null) 
    	{
    		String name = request.getParameter("zutatName");
    		float menge = Float.parseFloat(request.getParameter("zutatMenge"));
    		String einheit = request.getParameter("zutatEinheit");
    		bean.zutatHinzufuegen(name, menge, einheit);
    		System.out.println("Zutat hinzugefügt");
    		response.sendRedirect("jsp/RezeptErstellenView.jsp");
    		return;
    	} 

        Rezept rezept = new Rezept();
        rezept.setTitel(request.getParameter("titel"));
        rezept.setZubereitung(request.getParameter("zubereitung"));
        rezept.setDauerMinuten(Integer.parseInt(request.getParameter("dauer")));
        rezept.setKategorie(request.getParameter("kategorie"));
        // Bild verarbeiten
        String rootPath = getServletContext().getRealPath("/");
        Part imagePart = request.getPart("bild"); 
        try {
        	bean.erstelleRezept(rezept, imagePart, rootPath);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Weiterleitung
        response.sendRedirect("jsp/RezeptErstellenView.jsp");
    }
}
