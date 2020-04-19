package com.qa.ims.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	public void createCustomer(String fName, String mname, String lname, int age, String email, String address,
			String username) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO customers (`first_name`, `middle_names`, `last_name`, `age`, `email`, `address`, `username`)"
						+ " VALUES ('" + fName + "', '" + mname + "', '" + lname + "', '" + age + "', '" + email
						+ "', '" + address + "', '" + username + "')");
	}

	/**
	 * @throws SQLException
	 */
	public void readCustomers() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		while (rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("email");
			System.out.println(name);
		}
	}

	public void deleteCustomer(int id) throws SQLException {
		stmt.executeUpdate("DELETE FROM customers WHERE customer_id = " + id);
	}

}