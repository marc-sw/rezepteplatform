package de.hwg_lu.bwi520.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hwg_lu.bwi.jdbc.ConnectionManager;
import de.hwg_lu.bwi520.model.Rezept;

public class RezeptBean {

	
    private Connection connection;
    private Rezept rezept;

    public RezeptBean() throws SQLException, ClassNotFoundException {
        this.connection = ConnectionManager.getSharedConnection();
    }

  /*  public List<Rezept> getSuppen() {
        List<Rezept> rezepte = new ArrayList<>();
        try (PreparedStatement ps = this.connection.prepareStatement(
                "SELECT titel, bildname, beschreibung, dauer, kategorie FROM rezepte WHERE kategorie = 'Suppen'")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Rezept r = new Rezept(
                    rs.getString("titel"),
                    rs.getString("bildname"),
                    null, // Zutaten erstmal leer
                    rs.getString("beschreibung"),
                    rs.getInt("dauer")
                    rs.getString("kategorie")
                );
                rezepte.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezepte; */
    
    public void speichereRezept() throws SQLException {
        String sql = "INSERT INTO rezepte (titel, zutaten, dauer, zubereitung, bildname) VALUES (?, ?, ?, ?)";
        PreparedStatement prep = this.connection.prepareStatement(sql);
        prep.setString(1, this.rezept.getTitel());
        prep.setInt(2, this.rezept.getDauerMinuten());
        prep.setString(3, this.rezept.getZubereitung());
        prep.setString(4, this.rezept.getBildName());
        prep.executeUpdate();
    } 
    
    public ArrayList<String> sucheRezepte(String zutat) throws SQLException {
    	String sql = "SELECT titel FROM rezepte WHERE titel LIKE ?";
    	PreparedStatement prep = this.connection.prepareStatement(sql);
    	prep.setString(1, "%" + zutat + "%");
        ResultSet rs = prep.executeQuery();

        ArrayList<String> rezepte = new ArrayList<>();
        while (rs.next()) {
            rezepte.add(rs.getString("titel"));
        }
        return rezepte;
    }
    
    
    
    
}
