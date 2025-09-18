package de.hwg_lu.bwi.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import de.hwg_lu.bwi520.model.Favorit;
import de.hwg_lu.bwi520.model.Rezept;

public class FavoritTable {

    private final Connection connection;

    public FavoritTable(Connection connection) throws SQLException {
        this.connection = connection;
        this.createTable();
    }

    		// Tabelle erstellen
    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS favoriten ("
                   + "username VARCHAR(50) NOT NULL REFERENCES account(username) ON DELETE CASCADE, "
                   + "rezept_id INT NOT NULL REFERENCES rezepte(id) ON DELETE CASCADE, "
                   + "PRIMARY KEY (username, rezept_id)"
                   + ");";
        Statement stmt = this.connection.createStatement();
        stmt.execute(sql);
    }

    		// Favorit hinzufügen
    public boolean addFavorit(Favorit f) throws SQLException {
        String sql = "INSERT INTO favoriten (username, rezept_id) VALUES (?, ?);";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, f.getUsername());
        stmt.setInt(2, f.getRezeptId());
        return stmt.executeUpdate() == 1;
    }

    		// Favorit löschen
    public boolean removeFavorit(Favorit f) throws SQLException {
        String sql = "DELETE FROM favoriten WHERE username = ? AND rezept_id = ?;";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, f.getUsername());
        stmt.setInt(2, f.getRezeptId());
        return stmt.executeUpdate() == 1;
    }

    		// Alle Favoriten eines Benutzers abrufen
    public List<Favorit> findFavoritenByUser(String username) throws SQLException {
        String sql = "SELECT username, rezept_id FROM favoriten WHERE username = ?;";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        List<Favorit> list = new ArrayList<>();
        while (rs.next()) {
            Favorit f = new Favorit(
                rs.getString("username"),
                rs.getInt("rezept_id")
            );
            list.add(f);
        }
        return list;
    }
    public List<Rezept> findRezepteByUser(String username) throws SQLException {
        String sql = "SELECT r.id, r.titel, r.bildname, r.dauer, r.zubereitung, r.kategorie "
                   + "FROM favoriten f "
                   + "JOIN rezepte r ON f.rezept_id = r.id "
                   + "WHERE f.username = ?;";

        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        List<Rezept> rezepte = new ArrayList<>();
        while (rs.next()) {
            Rezept r = new Rezept(
                rs.getInt("id"),
                rs.getString("titel"),
                rs.getString("bildname"),
                rs.getInt("dauer"),
                rs.getString("zubereitung"),
                rs.getString("kategorie")
            );
            rezepte.add(r);
        }
        return rezepte;
    }
}
