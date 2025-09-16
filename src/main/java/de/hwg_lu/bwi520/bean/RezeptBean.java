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
    
}
