package de.hwg_lu.bwi520.model;

public class Zutat {
	
	private int id;
	private String name;
	private float menge;
	private String mengeEinheit;
	
	public Zutat(int id, String name, float menge, String mengeEinheit) {
		this.name = name;
		this.menge = menge;
		this.mengeEinheit = mengeEinheit;
	}
	
	public Zutat() {
		this(0, null, 0, null);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
