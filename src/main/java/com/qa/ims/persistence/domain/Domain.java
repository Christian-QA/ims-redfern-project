package com.qa.ims.persistence.domain;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum Domain {

	CUSTOMERS("Review customers: allow manipulation of the customers table"),
	PRODUCTS("Review products: allow manipulation of the products table"),
	ORDERS("Review orders: allow manipulation of the orders table"),
	HELP("Help: Describes what the other functions do"), STOP("Stop: Closes the application");

	public static final Logger LOGGER = Logger.getLogger(Domain.class);

	private String description;

	private Domain(String description) {
		this.description = description;
	}

	public String getDomainDescription() {
		return this.description;
	}

	public static void printDomain() {
		for (Domain command : Domain.values()) {
			LOGGER.info(command.getDomainDescription());
		}
	}

	public static Domain getDomain() {
		Domain command;
		while (true) {
			try {
				switch (Utils.getInput()) {
				case "1":
				case "customers":
					command = Domain.CUSTOMERS;
					break;
				case "2":
				case "products":
					command = Domain.PRODUCTS;
					break;
				case "3":
				case "orders":
					command = Domain.ORDERS;
					break;
				case "4":
				case "help":
					command = Domain.HELP;
					LOGGER.info(CUSTOMERS.getDomainDescription());
					LOGGER.info(PRODUCTS.getDomainDescription());
					LOGGER.info(ORDERS.getDomainDescription());
					LOGGER.info(HELP.getDomainDescription());
					LOGGER.info(STOP.getDomainDescription());
					break;
				case "5":
				case "stop":
					command = Domain.STOP;
					break;
				default:
					command = Domain.valueOf(Utils.getInput().toUpperCase());
					break;
				}
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return command;
	}

	public String toString(String input) {
		return input;

	}
}