package de.hwg_lu.bwi520.model;

import java.time.LocalDateTime;

public class Bewertung {
    
    private int id;
    private int rezeptId;
    private String username;
    private int sterne;      // 1-5 Bewertung
    private String kommentar;
    private LocalDateTime datum;

    public Bewertung(int id, int rezeptId, String username, int sterne, String kommentar, LocalDateTime datum) {
        super();
        this.id = id;
        this.rezeptId = rezeptId;
        this.username = username;
        this.sterne = sterne;
        this.kommentar = kommentar;
        this.datum = datum;
    }

    public Bewertung(int rezeptId, String username, int sterne, String kommentar) {
        this(0, rezeptId, username, sterne, kommentar, LocalDateTime.now());
    }

    public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRezeptId() {
        return rezeptId;
    }
    public void setRezeptId(int rezeptId) {
        this.rezeptId = rezeptId;
    }


    public int getSterne() {
        return sterne;
    }
    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    public String getKommentar() {
        return kommentar;
    }
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
