package com.qa.ims;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

<<<<<<< Updated upstream
	public static void main(String[] args) throws SQLException {
		DB db = new DB();
		/// db.createCustomer("John", "Augustus", "Harper", 25, "example@gmail.com",
		/// "24 New Spring Lane, " + "London, NW2 1HE", "TheBartManxxx123");
		db.readCustomers();
		/// db.deleteCustomer(0);
=======
	public static void main(String[] args) {

		BasicConfigurator.configure();

		InventoryManager ims = new InventoryManager();
		ims.initiateSystem();

		/// DB db = new DB();

>>>>>>> Stashed changes
	}
}
