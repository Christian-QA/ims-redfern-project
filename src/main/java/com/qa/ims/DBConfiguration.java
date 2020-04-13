package com.qa.ims;

public abstract class DBConfiguration {

	private String DB_URL;
	private String USER;
	private String PASS;

	public String getDB_URL() {
		return DB_URL;
	}

	public void setDB_URL(String DB_URL) {
		this.DB_URL = DB_URL;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String USER) {
		this.USER = USER;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String PASS) {
		this.PASS = PASS;
	}

	/*
	 * public String userName(String username) { return username; }
	 * 
	 * public String userPassword(String password) { return password; }
	 * 
	 * public static final String DB_URL = "jdbc:mysql://35.205.154.97/imsDB";
	 * public static final String USER = "root"; public static final String PASS =
	 * "root";
	 * 
	 * private DBConfiguration() { }
	 */
}
