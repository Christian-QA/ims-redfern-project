package com.qa.ims;

import org.apache.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) {

		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.initSystem();

	}
}