package com.qa.ims;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) {

		BasicConfigurator.configure();

		InventoryManager ims = new InventoryManager();
		ims.initiateSystem(true);

	}
}