package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.ims.controllers.CrudController;
import com.qa.ims.controllers.CustomerController;
import com.qa.ims.controllers.DMLCommands;
import com.qa.ims.persistence.dataaccessobjects.CustomerDataAccessObject;
import com.qa.ims.persistence.profiles.TableSelectCommand;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.utils.Utils;

public class InventoryManager {

	public static final Logger LOGGER = Logger.getLogger(InventoryManager.class);

	public void initiateSystem() {

		LOGGER.info("Please insert username: ");
		String username = Utils.getInput();
		LOGGER.info("Please insert password: ");
		String password = Utils.getInput();

		LOGGER.info("Hello, " + username + " how can I help you today?");
		System.out.println(
				"1): Review Customers      2): Review Products      3): Review Orders      4): Help      5): Stop");
		TableSelectCommand tableSelectCommand = TableSelectCommand.getTableSelectCommand();

		LOGGER.info("You have selected '" + tableSelectCommand + "'. How would you like to proceed?");
		System.out.println("1): Create      2): Read      3): Update      4): Delete      5): Help      6): Back");
		DMLCommands DMLCommand = DMLCommands.getDMLCommands();

		switch (tableSelectCommand) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(
					new CustomerServices(new CustomerDataAccessObject(username, password)));
			doDMLCommand(customerController, DMLCommand);
			break;
		case ITEM:
			break;
		case ORDER:
			break;
		case STOP:
			break;
		default:
			break;
		}
	}

	public void doDMLCommand(CrudController<?> createReadUpdateDestroyController, DMLCommands DMLCommand) {
		switch (DMLCommand) {
		case CREATE:
			createReadUpdateDestroyController.create();
			break;
		case READ:
			createReadUpdateDestroyController.readAll();
			break;
		case UPDATE:
			createReadUpdateDestroyController.update();
			break;
		case DELETE:
			createReadUpdateDestroyController.delete();
			break;
		case RETURN:
			break;
		default:
			break;

		}
	}
}
