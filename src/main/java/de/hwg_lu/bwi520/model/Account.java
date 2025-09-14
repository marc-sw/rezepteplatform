package de.hwg_lu.bwi520.model;

public class Account {
	
	private String username;
	private String password;
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Account() {
		this(null, null);
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
