package de.hwg_lu.bwi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hwg_lu.bwi520.model.Rezept;
import de.hwg_lu.bwi520.model.Zutat;

public class ZutatTable {
	
private final Connection connection;
	
	public ZutatTable(Connection connection) throws SQLException {
		this.connection = connection;
		this.createTable();
	}
	
	// Stellt sicher, dass die Datenbank Tabelle vorhanden ist
	private boolean createTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS zutat (id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL, menge DECIMAL NOT NULL, einheit VARCHAR(50) NOT NULL, rezept_id INT REFERENCES rezepte(id));";
		Statement stmt = this.connection.createStatement();
		return stmt.execute(sql);
	}
	
	public boolean dropTable() throws SQLException {
		String sql = "DROP TABLE IF EXISTS zutat;";
		Statement stmt = this.connection.createStatement();
		return stmt.execute(sql);
	}
	
	public boolean createZutat(String name, float menge, String einheit) throws SQLException {
		String sql = "INSERT INTO zutat (name, menge, einheit) VALUES (?, ?, ?);";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setFloat(2, menge);
		stmt.setString(3, einheit);
		boolean created = stmt.executeUpdate() == 1;
		return created;
	}
	
	public void findeZutaten(Rezept rezept) throws SQLException {
		String sql = "SELECT id, name, menge, einheit FROM zutat WHERE rezept_id = ?;";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, rezept.getId());
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			Zutat zutat = new Zutat();
			zutat.setId(result.getInt(1));
			zutat.setName(result.getString(2));
			zutat.setMenge(result.getFloat(3));
			zutat.setMengeEinheit(result.getString(4));
			rezept.getZutaten().add(zutat);
		}
	}
	
	public boolean updateZutat(Zutat zutat) throws SQLException {
		String sql = "UPDATE zutat SET name = ?, menge = ?, einheit = ? WHERE id = ?;";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, zutat.getName());
		stmt.setFloat(2, zutat.getMenge());
		stmt.setString(3, zutat.getMengeEinheit());
		stmt.setInt(4, zutat.getId());
		boolean updated = stmt.executeUpdate() == 1;
		return updated;

	}
	
	public boolean deleteZutat(int zutatId) throws SQLException {
		String sql = "DELETE FROM zutat WHERE id = ?;";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, zutatId);
		boolean deleted = stmt.executeUpdate() == 1;
		return deleted;
	}
}
