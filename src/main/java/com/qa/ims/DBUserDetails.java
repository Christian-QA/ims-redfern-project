package com.qa.ims;

public abstract class DBUserDetails extends DBConfiguration {

	public DBUserDetails() {
	}

	public DBUserDetails(String DB_URL, String USER, String PASS) {
		this.setDB_URL(DB_URL);
		this.setUSER(USER);
		this.setPASS(PASS);
	}

}
