package de.hwg_lu.bwi520.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.hwg_lu.bwi520.model.Zutat;

public class RezeptErstellenBean {
	
	private List<Zutat> zutaten;
	
	public RezeptErstellenBean() {
		zutaten = new ArrayList<Zutat>();
	}
	
	public void zutatHinzufuegen(String name, float menge, String einheit) {
		if (name == null || name.isBlank() || menge == 0 || einheit == null || einheit.isBlank()) {
			return;
		}
		zutaten.add(new Zutat(0, name, menge, einheit));
	}
	
	public void erstelleRezept(String titel, String bildPfad, int dauerMinuten, String zubereitung) {
		if (zutaten.isEmpty() || titel == null || titel.isBlank() || dauerMinuten == 0 || zubereitung == null || zubereitung.isBlank()) {
			return;
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
