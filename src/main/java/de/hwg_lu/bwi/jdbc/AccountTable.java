package de.hwg_lu.bwi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import de.hwg_lu.bwi520.model.Account;

public class AccountTable {
	
	private final Connection connection;
	
	public AccountTable(Connection connection) throws SQLException {
		this.connection = connection;
		this.createTable();
	}
	
	// Stellt sicher, dass die Datenbank Tabelle vorhanden ist
	private boolean createTable() throws SQLException {
		String sql = """
				CREATE TABLE IF NOT EXISTS account (
					email VARCHAR PRIMARY KEY
					username VARCHAR NOT NULL
					password VARCHAR NOT NULL
				);
					""";
		Statement stmt = this.connection.createStatement();
		return stmt.execute(sql);
	}
	
	public boolean dropTable() throws SQLException {
		String sql = "DROP TABLE IF EXISTS account;";
		Statement stmt = this.connection.createStatement();
		return stmt.execute(sql);
	}
	
	public boolean createAccount(Account account) throws SQLException {
		String sql = "INSERT INTO account (email, username, password) VALUES (?, ?, ?);";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, account.getEmail());
		stmt.setString(2, account.getUsername());
		stmt.setString(3, account.getPassword());
		boolean accountCreated = stmt.executeUpdate() == 1;
		return accountCreated;
	}
	
	public Account findAccount(String email, String password) throws SQLException {
		String sql = "SELECT email, username, password FROM account WHERE email = ? AND password = ?;";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
		ResultSet result = stmt.executeQuery();
		Account account = null;
		if (result.next()) {
			account = new Account();
			account.setEmail(result.getString(1));
			account.setUsername(result.getString(2));
			account.setPassword(result.getString(3));
		}
		return account;
	}
	
	
}
