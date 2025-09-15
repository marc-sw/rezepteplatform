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
		zutaten.add(new Zutat(name, menge, einheit));
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
		return "<tr><td>Zutaten</td><td>" + zutaten.stream().map(zutat ->"%s %.2f %s ".formatted(zutat.getName(), zutat.getMenge(), zutat.getMengeEinheit())).collect(Collectors.joining(", ")) + "</td></tr>";
	}
}
