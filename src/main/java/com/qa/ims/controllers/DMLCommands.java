package com.qa.ims.controllers;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum DMLCommands {
	CREATE("To save a new item into the database"), READ("To read an item from the database"),
	UPDATE("To change an item already in the database"), DELETE("To remove an item from the database"),
	RETURN("To return to domain selection");

	public static final Logger LOGGER = Logger.getLogger(DMLCommands.class);

	private String description;

	private DMLCommands() {
	}

	DMLCommands(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getDMLCommandsDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all posible actions
	 */
	public static void printDMLCommands() {
		for (DMLCommands action : DMLCommands.values()) {
			LOGGER.info(action.getDMLCommandsDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static DMLCommands getDMLCommands() {
		DMLCommands action;
		while (true) {
			try {
				action = DMLCommands.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}

}
