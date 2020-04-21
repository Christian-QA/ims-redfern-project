package com.qa.ims.persistence.profiles;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum TableSelectCommand {

	CUSTOMER("Information about customers"), PRODUCT("Individual Items"), ORDER("Purchases of items"),
	STOP("To close the application");

	public static final Logger LOGGER = Logger.getLogger(TableSelectCommand.class);

	private String description;

	private TableSelectCommand(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.name() + ": " + this.description;
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
				command = TableSelectCommand.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return command;
	}

}