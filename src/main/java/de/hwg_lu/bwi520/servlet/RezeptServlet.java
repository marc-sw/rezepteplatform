package de.hwg_lu.bwi520.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import de.hwg_lu.bwi.jdbc.ConnectionManager;
import de.hwg_lu.bwi520.bean.RezeptErstellenBean;


@WebServlet("/RezeptServlet")
@MultipartConfig   // Wichtig für File-Upload
public class RezeptServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	RezeptErstellenBean bean = (RezeptErstellenBean) request.getSession().getAttribute("rezeptErstellen");
    	if (bean == null) {
    		try {
    			bean = new RezeptErstellenBean();
    			request.getSession().setAttribute("rezeptErstellen", bean);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
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
    	
    	
    	
    	
        String titel = request.getParameter("titel");
        String zubereitung = request.getParameter("zubereitung");
        int dauer = Integer.parseInt(request.getParameter("dauer"));
        String kategorie = request.getParameter("kategorie");

        // Upload-Ordner
        String uploadPath = getServletContext().getRealPath("") + File.separator + "img/uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        // Bild verarbeiten
        Part filePart = request.getPart("bild"); 
        String fileName = filePart.getSubmittedFileName();
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // hier: Rezept speichern (über Bean oder Table)
        try {
        	bean.erstelleRezept(titel, fileName, dauer, zubereitung, kategorie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Rezept erstellt");

        // Weiterleitung
        response.sendRedirect("jsp/RezeptErstellenView.jsp");
    }
}
