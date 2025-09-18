package de.hwg_lu.bwi520.model;

public class Favorit {
    
    private String username;  // Nutzername aus Account
    private int rezeptId;     // Rezept, das favorisiert wurde

    public Favorit(String username, int rezeptId) {
        super();
        this.username = username;
        this.rezeptId = rezeptId;
    }

    public Favorit() {
        this(null, 0);
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
}
