package com.qa.ims;

public class DBConfiguration {

	public String userName(String username) {
		return username;
	}

	public String userPassword(String password) {
		return password;
	}

	public static final String DB_URL = "jdbc:mysql://35.205.154.97/imsDB";
	public static final String USER = "root";
	public static final String PASS = "root";

	private DBConfiguration() {
	}

}
