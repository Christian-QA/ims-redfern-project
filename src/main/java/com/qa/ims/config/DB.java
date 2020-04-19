package com.qa.ims.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private Connection conn;
	private Statement stmt;

	public DB(String USER, String PASS, String DB_URL) throws SQLException {
		conn = DriverManager.getConnection("root", "root", "jdbc:mysql://35.205.154.97/imsDB");
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createCustomer(String fName, String lName) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO customers (`forename`, `surname`)" + " VALUES ('" + fName + "', '" + lName + "')");
	}

	/**
	 * @param fName
	 * @param mname
	 * @param lname
	 * @param age
	 * @param email
	 * @param address
	 * @param username
	 * @throws SQLException
	 */

	/**
	 * @throws SQLException
	 */

}