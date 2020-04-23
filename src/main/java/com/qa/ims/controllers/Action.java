package com.qa.ims.controllers;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum Action {
	CREATE("To save a new item into the database"), READ("To read an item from the database"),
	UPDATE("To change an item already in the database"), DELETE("To remove an item from the database"),
	HELP("Describes what the other functions do"), RETURN("To return to domain selection");

	public static final Logger LOGGER = Logger.getLogger(Action.class);

	private String description;

	private Action() {
	}

	Action(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getActionDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printAction() {
		for (Action dmlcommand : Action.values()) {
			LOGGER.info(dmlcommand.getActionDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return DmlCommand type
	 */
	public static Action getAction() {
		Action dmlcommand;
		while (true) {
			try {
				switch (Utils.getInput()) {
				case "1":
				case "create":
					dmlcommand = Action.CREATE;
					break;
				case "2":
				case "read":
					dmlcommand = Action.READ;
					break;
				case "3":
				case "update":
					dmlcommand = Action.UPDATE;
					break;
				case "4":
				case "delete":
					dmlcommand = Action.DELETE;
					break;
				case "5":
				case "help":
					dmlcommand = Action.HELP;
					LOGGER.info(CREATE.getActionDescription());
					LOGGER.info(CREATE.getActionDescription());
					LOGGER.info(UPDATE.getActionDescription());
					LOGGER.info(DELETE.getActionDescription());
					LOGGER.info(HELP.getActionDescription());
					LOGGER.info(RETURN.getActionDescription());
					break;
				case "6":
				case "return":
					dmlcommand = Action.RETURN;
					break;
				default:
					dmlcommand = Action.valueOf(Utils.getInput().toUpperCase());
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
