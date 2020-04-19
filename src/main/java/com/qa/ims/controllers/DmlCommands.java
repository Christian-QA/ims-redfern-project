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
	RETURN("To return to domain selection");

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
	 * Prints out all posible actions
	 */
	public static void printDmlCommands() {
		for (DmlCommands action : DmlCommands.values()) {
			LOGGER.info(action.getDmlCommandsDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static DmlCommands getDmlCommands() {
		DmlCommands action;
		while (true) {
			try {
				action = DmlCommands.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}

}
