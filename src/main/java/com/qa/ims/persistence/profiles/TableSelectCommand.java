package com.qa.ims.persistence.profiles;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum TableSelectCommand {

	CUSTOMERS("Review customers: allow manipulation of the customers table"),
	PRODUCTS("Review products: allow manipulation of the products table"),
	ORDERS("Review orders: allow manipulation of the orders table"), HELP("Describes what the other functions do"),
	STOP("Closes the application");

	public static final Logger LOGGER = Logger.getLogger(TableSelectCommand.class);

	private String description;

	private TableSelectCommand(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public static void printTableSelectCommands() {
		for (TableSelectCommand command : TableSelectCommand.values()) {
			LOGGER.info(command.getDescription());
		}
	}

	public static TableSelectCommand getTableSelectCommand() {
		TableSelectCommand command;
		while (true) {
			try {
				switch (Utils.getInput()) {
				case "1":
				case "customers":
					command = TableSelectCommand.CUSTOMERS;
					break;
				case "2":
				case "products":
					command = TableSelectCommand.PRODUCTS;
					break;
				case "3":
				case "orders":
					command = TableSelectCommand.ORDERS;
					break;
				case "4":
				case "help":
					command = TableSelectCommand.HELP;
					LOGGER.info(CUSTOMERS.getDescription());
					LOGGER.info(PRODUCTS.getDescription());
					LOGGER.info(ORDERS.getDescription());
					LOGGER.info(HELP.getDescription());
					LOGGER.info(STOP.getDescription());
					break;
				case "5":
				case "stop":
					command = TableSelectCommand.STOP;
					break;
				default:
					command = TableSelectCommand.valueOf(Utils.getInput().toUpperCase());
					break;
				}
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return command;
	}

}