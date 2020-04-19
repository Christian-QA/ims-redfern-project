package com.qa.ims;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) {
<<<<<<< HEAD

		BasicConfigurator.configure();
=======
		BasicConfigurator.configure();

>>>>>>> 9f15fc52b74eaa090e418a9c9dbb2c81fbb334d8
		InventoryManager ims = new InventoryManager();
		ims.initiateSystem();

		/// DB db = new DB();

	}
}