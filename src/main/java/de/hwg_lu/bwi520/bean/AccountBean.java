package de.hwg_lu.bwi520.bean;

import java.sql.SQLException;

import de.hwg_lu.bwi.jdbc.AccountTable;
import de.hwg_lu.bwi.jdbc.ConnectionManager;
import de.hwg_lu.bwi520.model.Account;

public class AccountBean {
	
	
	private Account userAccount;
	private AccountTable accountTable;
	
	public AccountBean() throws SQLException, ClassNotFoundException {
		this.userAccount = null;
		accountTable = new AccountTable(ConnectionManager.getSharedConnection());
	}
	
	public boolean register(String username, String password) throws SQLException {
		if (username == null || username.isBlank() || password == null || password.isBlank()) {
			return false;
		}
		return accountTable.createAccount(new Account(username, password));
	}
	
	public boolean login(String username, String password) throws SQLException {
		if (username == null || username.isBlank() || password == null || password.isBlank()) {
			return false;
		}
		userAccount = accountTable.findAccount(username, password);
		return userAccount != null;
	}
	
	public String generateAccountHTML() {
		if (userAccount == null) {
			return "<form action=\"./KochAppl.jsp\" method=\"get\">\r\n"
			+ "                <table>\r\n"
			+ "                    <tr>\r\n"
			+ "                        <td><input type=\"text\" name=\"username\" placeholder=\"Benutzername\"></td>\r\n"
			+ "                   </tr>\r\n"
			+ "                    <tr> \r\n"
			+ "                    	<td><input type=\"password\" name=\"passwort\" placeholder=\"Passwort\"></td> \r\n"
			+ "                    </tr>\r\n"
			+ "                     <tr> \r\n"
			+ "                       <td><input type=\"submit\" name=\"Registrieren\" value=\"Registrieren\"> \r\n"
			+ "                       <input type=\"submit\" name=\"Anmelden\" value=\"Anmelden\"></td>\r\n"
			+ "                    </tr>\r\n"
			+ "                </table>\r\n"
			+ "            </form>";
		}
		return "<p>Sie sind angemeldet als " + userAccount.getUsername() + ".</p>";
	}
	
	public String generateUsernameHTML() {
		if (userAccount == null) {
			return "Gast";
		}
		return userAccount.getUsername();
	}
}
