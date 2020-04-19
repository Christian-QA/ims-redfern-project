package com.qa.ims;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

<<<<<<< HEAD
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

=======
	public static void main(String[] args) {
<<<<<<< HEAD

		BasicConfigurator.configure();
=======
		BasicConfigurator.configure();

>>>>>>> 9f15fc52b74eaa090e418a9c9dbb2c81fbb334d8
>>>>>>> feature
		InventoryManager ims = new InventoryManager();
		ims.initiateSystem();

		/// DB db = new DB();

<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> feature
	}
}