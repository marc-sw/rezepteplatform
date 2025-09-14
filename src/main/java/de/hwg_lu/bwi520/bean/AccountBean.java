package de.hwg_lu.bwi520.bean;

import de.hwg_lu.bwi520.model.Account;

public class AccountBean {
	
	
	private Account userAccount;
	
	public String generateAccountHTML() {
		if (userAccount == null) {
			return "<form action=\"LoginView.jsp\" method=\"post\">\r\n"
			+ "                <table>\r\n"
			+ "                    <tr>\r\n"
			+ "                        <td><input type=\"text\" name=\"username\" placeholder=\"Benutzername\"></td>\r\n"
			+ "                   </tr>\r\n"
			+ "                    <tr> \r\n"
			+ "                    	<td><input type=\"password\" name=\"passwort\" placeholder=\"Passwort\"></td> \r\n"
			+ "                    </tr>\r\n"
			+ "                     <tr> \r\n"
			+ "                       <td><button type=\"submit\">Anmelden</button> \r\n"
			+ "                       <button type=\"button\" >Registrieren</button></td>\r\n"
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
