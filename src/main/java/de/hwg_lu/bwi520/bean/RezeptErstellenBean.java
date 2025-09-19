package de.hwg_lu.bwi520.bean;

import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hwg_lu.bwi.jdbc.ConnectionManager;
import de.hwg_lu.bwi.jdbc.RezeptTable;
import de.hwg_lu.bwi.jdbc.ZutatTable;
import de.hwg_lu.bwi520.ImageAccess;
import de.hwg_lu.bwi520.model.Rezept;
import de.hwg_lu.bwi520.model.Zutat;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class RezeptErstellenBean {
	
	private ZutatTable zutatTable;
	private RezeptTable rezeptTable;
	private List<Zutat> zutaten;
	
	public RezeptErstellenBean() throws ClassNotFoundException, SQLException {
		zutaten = new ArrayList<Zutat>();
		zutatTable = new ZutatTable(ConnectionManager.getSharedConnection());
		rezeptTable = new RezeptTable(ConnectionManager.getSharedConnection());
	}
	
	private String getKategorieImage(String kategorie) {
		if (kategorie.equals("Suppe")) {
			return "suppen.jsp";
		}
		if (kategorie.equals("Salat")) {
			return "salat.jsp";
		}
		if (kategorie.equals("Beilage")) {
			return "beilagen.jpg";
		}
		if (kategorie.equals("Dessert")) {
			return "desserts.jpg";
		}
		return "hauptspeisse.jpg";
	}
	
	public void zutatHinzufuegen(String name, float menge, String einheit) {
		if (name == null || name.isBlank() || menge == 0 || einheit == null || einheit.isBlank()) {
			return;
		}
		zutaten.add(new Zutat(0, name, menge, einheit));
	}
	
	public void erstelleRezept(Rezept rezept, Part imagePart, String rootPath) throws SQLException {
		if (rezept == null || rootPath == null) {
			return;
		}
		
		if (imagePart == null || imagePart.getSize() == 0) {
			System.out.println("using default image");
			rezept.setBildName("/img/" + getKategorieImage(rezept.getKategorie()));
		} else {
			String filename = System.currentTimeMillis() + "_" + imagePart.getSubmittedFileName();
			rezept.setBildName("/img/uploads/" + filename);
			String absolutPath = rootPath + "/" + rezept.getBildName();
			ImageAccess.uploadImage(imagePart, absolutPath);
		}
		rezeptTable.insertRezept(rezept);
		
		for (Zutat zutat: zutaten) {
			zutatTable.createZutat(zutat.getName(), zutat.getMenge(), zutat.getMengeEinheit());
		}
		System.out.println("Rezept erstellt");
	}
	
	public String getZutatenHTML() {
		if (zutaten.isEmpty()) {
			return "";
		}
		StringBuilder html = new StringBuilder();
		html.append("<tr><td>Zutaten</td><td>");
		Zutat zutat = zutaten.get(0);
		html.append("%s %.2f %s ".formatted(zutat.getName(), zutat.getMenge(), zutat.getMengeEinheit()));
		for (int i = 1; i < zutaten.size(); i++) {
			zutat = zutaten.get(i);
			html.append(", %s %.2f %s ".formatted(zutat.getName(), zutat.getMenge(), zutat.getMengeEinheit()));
		}
		html.append("</td></tr>");
		return html.toString();
	}
	
	public static RezeptErstellenBean fromRequest(HttpServletRequest request) {
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
    	
    	return bean;
	}
}
