package de.hwg_lu.bwi.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import de.hwg_lu.bwi520.model.Bewertung;

public class BewertungTable {

    private final Connection connection;

    public BewertungTable(Connection connection) throws SQLException {
        this.connection = connection;
        this.createTable();
    }
    //Tabelle erstellen
    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS bewertungen ("
                   + "id SERIAL PRIMARY KEY, "
                   + "rezept_id INT NOT NULL REFERENCES rezepte(id) ON DELETE CASCADE, "
                   + "username VARCHAR(50) NOT NULL REFERENCES account(username) ON DELETE CASCADE, "
                   + "sterne INT NOT NULL CHECK (sterne BETWEEN 1 AND 5), "
                   + "kommentar TEXT, "
                   + "datum TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                   + ");";
        Statement stmt = this.connection.createStatement();
        stmt.execute(sql);
    }
    //Bewertung einfuegen
    public boolean insertBewertung(Bewertung b) throws SQLException {
        String sql = "INSERT INTO bewertungen (rezept_id, username, sterne, kommentar, datum) "
                   + "VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setInt(1, b.getRezeptId());
        stmt.setString(2, b.getUsername());
        stmt.setInt(3, b.getSterne());
        stmt.setString(4, b.getKommentar());
        stmt.setTimestamp(5, Timestamp.valueOf(b.getDatum()));

        return stmt.executeUpdate() == 1;
    }
    //Bewertungen zu einem bestimmten Rezept abrufen
    public List<Bewertung> findBewertungenByRezeptId(int rezeptId) throws SQLException {
        String sql = "SELECT id, rezept_id, username, sterne, kommentar, datum "
                   + "FROM bewertungen WHERE rezept_id = ?;";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setInt(1, rezeptId);
        ResultSet rs = stmt.executeQuery();

        List<Bewertung> list = new ArrayList<>();
        while (rs.next()) {
            Bewertung b = new Bewertung(
                rs.getInt("id"),
                rs.getInt("rezept_id"),
                rs.getString("username"),
                rs.getInt("sterne"),
                rs.getString("kommentar"),
                rs.getTimestamp("datum").toLocalDateTime()
            );
            list.add(b);
        }
        return list;
    }
    
 
}
