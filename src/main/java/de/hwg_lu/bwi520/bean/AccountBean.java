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
		
		if (accountTable.existsAccount(username)) {
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
	
	public void logout() {
		this.userAccount = null;
	}
	
	public String generateAccountHTML() {
		if (userAccount == null) {
			return "<form action=\"./KochAppl.jsp\" method=\"get\">"
			+ "                <table>"
			+ "                    <tr>"
			+ "                        <td><input type=\"text\" name=\"username\" placeholder=\"Benutzername\"></td>"
			+ "                   </tr>"
			+ "                    <tr>"
			+ "                    	<td><input type=\"password\" name=\"passwort\" placeholder=\"Passwort\"></td>"
			+ "                    </tr>"
			+ "                     <tr>"
			+ "                       <td><input type=\"submit\" name=\"Registrieren\" value=\"Registrieren\">"
			+ "                       <input type=\"submit\" name=\"Anmelden\" value=\"Anmelden\"></td>"
			+ "                    </tr>"
			+ "                </table>"
			+ "            </form>";
		} 
		return "<p>Angemeldet als " + userAccount.getUsername() + ". <a href=\"./KochAppl.jsp?abmelden=1\">Abmelden</a></p>";
	}
	
	public String generateUsernameHTML() {
		if (userAccount == null) {
			return "Gast";
		}
		return userAccount.getUsername();
	}
}
