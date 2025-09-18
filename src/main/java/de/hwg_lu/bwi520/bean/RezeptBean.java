package de.hwg_lu.bwi520.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import de.hwg_lu.bwi.jdbc.RezeptTable;
import de.hwg_lu.bwi.jdbc.ConnectionManager;
import de.hwg_lu.bwi520.model.Rezept;
public class RezeptBean {

	private String kategoriesuche;
	private RezeptTable rezepttable;
    private Rezept rezept;

    public RezeptBean() throws SQLException, ClassNotFoundException {
        this.rezepttable = new RezeptTable(ConnectionManager.getSharedConnection());
         
    }
    public String getRezepteByKategorie() {
    	if(this.kategoriesuche == null) {
    		return "Kein Rezept ausgew&auml;hlt";
    	}
    	
    	StringBuilder html = new StringBuilder();

        try {
            List<Rezept> rezepte = rezepttable.findRezepteByKategorie(kategoriesuche);

            for (Rezept r : rezepte) {
                html.append("<div class='card' style='width: 18rem; margin:10px;'>")
                    .append("<img src='").append(r.getBildName()).append("' class='card-img-top' alt='").append(r.getTitel()).append("'>")
                    .append("<div class='card-body'>")
                    .append("<h5 class='card-title'>").append(r.getTitel()).append("</h5>")
                    .append("<p class='card-text'>").append(r.getZubereitung()).append("</p>")
                    .append("<a href='RezeptDetailView.jsp?id=").append(r.getId()).append("' class='btn btn-primary'>Details</a>")
                    .append("</div></div>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            html.append("<p>Fehler beim Laden der Rezepte.</p>");
        }

        return html.toString();
    }
    public void setKategorieSuche(String kategoriesuche) {
    	this.kategoriesuche = kategoriesuche;
    }
    public String generateKategoriesucheHTML() {
    	if(kategoriesuche == null) {
    		return "Kein Rezept!!!";
    	}else {
    		return kategoriesuche;
    	}
    }

}
