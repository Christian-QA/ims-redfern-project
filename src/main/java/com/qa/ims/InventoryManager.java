package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public class InventoryManager {

	public static final Logger LOGGER = Logger.getLogger(InventoryManager.class);

	public void initiateSystem() {

		LOGGER.info("Please insert username: ");
		String username = Utils.getInput();
		LOGGER.info("Please insert password: ");
		String password = Utils.getInput();

///		DBConfiguration details = new DBConfiguration();

		/// Scrap DBConfig in favour of a contructor,
		// this will enable listing all users and allow
		// private input

	}

}
