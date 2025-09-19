package de.hwg_lu.bwi520.model;

import java.util.ArrayList;
import java.util.List;

public class Rezept {
	
	private int id;
	private String titel;
	private List<Zutat> zutaten;
	private String bildName;
	private int dauerMinuten;
	private String zubereitung;
	private String kategorie;
	
	public Rezept(int id, String titel, String bildName, int dauerMinuten, String zubereitung, String kategorie) {
		super();
		this.id = id;
		this.titel = titel;
		this.zutaten = new ArrayList<Zutat>();
		this.bildName = bildName;
		this.dauerMinuten = dauerMinuten;
		this.zubereitung = zubereitung;
		this.kategorie = kategorie;
	}
	
	public Rezept() {
		this(0, null, null, 0, null, null);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public List<Zutat> getZutaten() {
		return zutaten;
	}
	public void setZutaten(List<Zutat> zutaten) {
		this.zutaten = zutaten;
	}
	public String getBildName() {
		return bildName;
	}
	public void setBildName(String bildName) {
		this.bildName = bildName;
	}
	public int getDauerMinuten() {
		return dauerMinuten;
	}
	public void setDauerMinuten(int dauerMinuten) {
		this.dauerMinuten = dauerMinuten;
	}
	public String getZubereitung() {
		return zubereitung;
	}
	public void setZubereitung(String zubereitung) {
		this.zubereitung = zubereitung;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	
	
	
}
