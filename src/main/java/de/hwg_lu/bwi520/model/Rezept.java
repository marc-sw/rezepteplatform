package de.hwg_lu.bwi520.model;

import java.util.ArrayList;
import java.util.List;

public class Rezept {
	
	private String titel;
	private List<Zutat> zutaten;
	private String bildName;
	private int dauerMinuten;
	private String zubereitung;
	
	public Rezept(String titel, String bildName, int dauerMinuten, String zubereitung) {
		super();
		this.titel = titel;
		this.zutaten = new ArrayList<Zutat>();
		this.bildName = bildName;
		this.dauerMinuten = dauerMinuten;
		this.zubereitung = zubereitung;
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
	
	
}
