package com.qa.main;

import java.sql.SQLException;

public class Runner {

	public static void main(String[] args) throws SQLException {
		DB db = new DB();
		/// db.createCustomer("John", "Augustus", "Harper", 25, "example@gmail.com",
		/// "24 New Spring Lane, " + "London, NW2 1HE", "TheBartManxxx123");
		db.readCustomers();
		/// db.deleteCustomer(0);
	}
}
