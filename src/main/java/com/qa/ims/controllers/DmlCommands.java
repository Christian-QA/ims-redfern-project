package com.qa.ims.controllers;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum DmlCommands {
	CREATE("To save a new item into the database"), READ("To read an item from the database"),
	UPDATE("To change an item already in the database"), DELETE("To remove an item from the database"),
	HELP("Describes what the other functions do"), RETURN("To return to domain selection");

	public static final Logger LOGGER = Logger.getLogger(DmlCommands.class);

	private String description;

	private DmlCommands() {
	}

	DmlCommands(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getDmlCommandsDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printDmlCommands() {
		for (DmlCommands dmlcommand : DmlCommands.values()) {
			LOGGER.info(dmlcommand.getDmlCommandsDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return DmlCommand type
	 */
	public static DmlCommands getDmlCommands() {
		DmlCommands dmlcommand;
		while (true) {
			try {
				switch (Utils.getInput()) {
				case "1":
				case "create":
					dmlcommand = DmlCommands.CREATE;
					break;
				case "2":
				case "read":
					dmlcommand = DmlCommands.READ;
					break;
				case "3":
				case "update":
					dmlcommand = DmlCommands.UPDATE;
					break;
				case "4":
				case "delete":
					dmlcommand = DmlCommands.DELETE;
					break;
				case "5":
				case "help":
					dmlcommand = DmlCommands.HELP;
					LOGGER.info(CREATE.getDmlCommandsDescription());
					LOGGER.info(CREATE.getDmlCommandsDescription());
					LOGGER.info(UPDATE.getDmlCommandsDescription());
					LOGGER.info(DELETE.getDmlCommandsDescription());
					LOGGER.info(HELP.getDmlCommandsDescription());
					LOGGER.info(RETURN.getDmlCommandsDescription());
					break;
				case "6":
				case "return":
					dmlcommand = DmlCommands.RETURN;
					break;
				default:
					dmlcommand = DmlCommands.valueOf(Utils.getInput().toUpperCase());
					break;
				}
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return dmlcommand;
	}

}
