package de.hwg_lu.bwi520.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.hwg_lu.bwi.jdbc.ConnectionManager;
import de.hwg_lu.bwi.jdbc.RezeptTable;
import de.hwg_lu.bwi.jdbc.ZutatTable;
import de.hwg_lu.bwi520.model.Rezept;
import de.hwg_lu.bwi520.model.Zutat;

public class RezeptErstellenBean {
	
	private ZutatTable zutatTable;
	private RezeptTable rezeptTable;
	private List<Zutat> zutaten;
	
	public RezeptErstellenBean() throws ClassNotFoundException, SQLException {
		zutaten = new ArrayList<Zutat>();
		zutatTable = new ZutatTable(ConnectionManager.getSharedConnection());
		rezeptTable = new RezeptTable(ConnectionManager.getSharedConnection());
	}
	
	private boolean valid(String value) {
		return value != null && !value.isBlank();
	}
	
	public void zutatHinzufuegen(String name, float menge, String einheit) {
		if (name == null || name.isBlank() || menge == 0 || einheit == null || einheit.isBlank()) {
			return;
		}
		zutaten.add(new Zutat(0, name, menge, einheit));
	}
	
	public void erstelleRezept(String titel, String fileName, int dauerMinuten, String zubereitung, String kategorie) throws SQLException {
		if (zutaten.isEmpty() || !valid(titel) || dauerMinuten == 0 || !valid(zubereitung) || !valid(kategorie) || !valid(fileName) ) {
			return;
		}
		rezeptTable.insertRezept(new Rezept(0, titel, fileName, dauerMinuten, zubereitung, kategorie));
		
		for (Zutat zutat: zutaten) {
			zutatTable.createZutat(zutat.getName(), zutat.getMenge(), zutat.getMengeEinheit());
		}
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
}
