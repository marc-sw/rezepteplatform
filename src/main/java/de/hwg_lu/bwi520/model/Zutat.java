package de.hwg_lu.bwi520.model;

public class Zutat {
	private String name;
	private float menge;
	private String mengeEinheit;
	
	public Zutat(String name, float menge, String mengeEinheit) {
		this.name = name;
		this.menge = menge;
		this.mengeEinheit = mengeEinheit;
	}
	
	public Zutat() {
		this(null, 0, null);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMenge() {
		return menge;
	}
	public void setMenge(float menge) {
		this.menge = menge;
	}
	public String getMengeEinheit() {
		return mengeEinheit;
	}
	public void setMengeEinheit(String mengeEinheit) {
		this.mengeEinheit = mengeEinheit;
	}
	
	
}
