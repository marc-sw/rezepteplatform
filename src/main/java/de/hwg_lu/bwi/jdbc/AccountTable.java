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
					username VARCHAR PRIMARY KEY
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
		String sql = "INSERT INTO account (username, password) VALUES (?, ?);";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, account.getUsername());
		stmt.setString(2, account.getPassword());
		boolean accountCreated = stmt.executeUpdate() == 1;
		return accountCreated;
	}
	
	public Account findAccount(String username, String password) throws SQLException {
		String sql = "SELECT username, password FROM account WHERE username = ? AND password = ?;";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet result = stmt.executeQuery();
		Account account = null;
		if (result.next()) {
			account = new Account();
			account.setUsername(result.getString(1));
			account.setPassword(result.getString(2));
		}
		return account;
	}
	
	
}
