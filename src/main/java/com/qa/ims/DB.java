package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private Connection conn;
	private Statement stmt;

	public DB() throws SQLException {
		conn = DriverManager.getConnection(DBConfiguration.DB_URL, DBConfiguration.USER, DBConfiguration.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
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