package de.hwg_lu.bwi.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import de.hwg_lu.bwi520.model.Rezept;

public class RezeptTable {
    
    private final Connection connection;
    
    public RezeptTable(Connection connection) throws SQLException {
        this.connection = connection;
        this.createTable();
    }
    
    // Erstellt die Tabelle, falls sie nicht existiert
    private boolean createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS rezepte ("
                   + "id SERIAL PRIMARY KEY,"
                   + "titel VARCHAR(100) NOT NULL,"
                   + "bildname VARCHAR(255),"
                   + "dauerMinuten INT,"
                   + "zubereitung TEXT,"
                   + "kategorie VARCHAR(50)"
                   + ");";
        Statement stmt = this.connection.createStatement();
        return stmt.execute(sql);
    }
    
    public boolean dropTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS rezepte;";
        Statement stmt = this.connection.createStatement();
        return stmt.execute(sql);
    }
    
    // Rezept einfügen
    public boolean insertRezept(Rezept rezept) throws SQLException {
        String sql = "INSERT INTO rezepte (titel, bildname, dauerMinuten, zubereitung, kategorie) "
                   + "VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, rezept.getTitel());
        stmt.setString(2, rezept.getBildName());
        stmt.setInt(3, rezept.getDauerMinuten());
        stmt.setString(4, rezept.getZubereitung());
        stmt.setString(5, rezept.getKategorie());
        
        int rows = stmt.executeUpdate();
        
        if (rows == 1) {
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                rezept.setId(keys.getInt(1));
            }
            return true;
        }
        return false;
    }
    
    // Rezept nach ID finden
    public Rezept findRezeptById(int id) throws SQLException {
        String sql = "SELECT id, titel, bildname, dauerMinuten, zubereitung, kategorie FROM rezepte WHERE id = ?;";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return new Rezept(
                rs.getInt("id"),
                rs.getString("titel"),
                rs.getString("bildname"),
                rs.getInt("dauerMinuten"),
                rs.getString("zubereitung"),
                rs.getString("kategorie")
            );
        }
        return null;
    }
    
    // Alle Rezepte laden
    public List<Rezept> findAllRezepte() throws SQLException {
        String sql = "SELECT id, titel, bildname, dauerMinuten, zubereitung, kategorie FROM rezepte;";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Rezept> rezepte = new ArrayList<>();
        while (rs.next()) {
            rezepte.add(new Rezept(
                rs.getInt("id"),
                rs.getString("titel"),
                rs.getString("bildname"),
                rs.getInt("dauerMinuten"),
                rs.getString("zubereitung"),
                rs.getString("kategorie")
            ));
        }
        return rezepte;
    }
    
    // Nach Kategorie filtern
    public List<Rezept> findRezepteByKategorie(String kategorie) throws SQLException {
        String sql = "SELECT id, titel, bildname, dauerMinuten, zubereitung, kategorie "
                   + "FROM rezepte WHERE kategorie = ?;";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, kategorie);
        ResultSet rs = stmt.executeQuery();
        
        List<Rezept> rezepte = new ArrayList<>();
        while (rs.next()) {
            rezepte.add(new Rezept(
                rs.getInt("id"),
                rs.getString("titel"),
                rs.getString("bildname"),
                rs.getInt("dauerMinuten"),
                rs.getString("zubereitung"),
                rs.getString("kategorie")
            ));
        }
        return rezepte;
    }
    
    // Nach Suchbegriff (Titel) suchen
    public List<Rezept> searchRezepte(String suchbegriff) throws SQLException {
        String sql = "SELECT id, titel, bildname, dauerMinuten, zubereitung, kategorie "
                   + "FROM rezepte WHERE LOWER(titel) LIKE LOWER(?);";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, "%" + suchbegriff + "%");
        ResultSet rs = stmt.executeQuery();
        
        List<Rezept> rezepte = new ArrayList<>();
        while (rs.next()) {
            rezepte.add(new Rezept(
                rs.getInt("id"),
                rs.getString("titel"),
                rs.getString("bildname"),
                rs.getInt("dauerMinuten"),
                rs.getString("zubereitung"),
                rs.getString("kategorie")
            ));
        }
        return rezepte;
    }
}
