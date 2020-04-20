package com.qa.ims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.qa.ims.controllers.CrudController;
import com.qa.ims.controllers.CustomerController;
import com.qa.ims.controllers.DmlCommands;
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
		LOGGER.info("1): Review Customers      2): Review Products      3): Review Orders      4): Help      5): Stop");
		TableSelectCommand tableSelectCommand = TableSelectCommand.getTableSelectCommand();

		LOGGER.info("You have selected '" + tableSelectCommand + "'. How would you like to proceed?");
		LOGGER.info("1): Create      2): Read      3): Update      4): Delete      5): Help      6): Back");
		DmlCommands dmlCommand = DmlCommands.getDmlCommands();

		switch (tableSelectCommand) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(
					new CustomerServices(new CustomerDataAccessObject(username, password)));
			doDMLCommand(customerController, dmlCommand);
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

	public void doDMLCommand(CrudController<?> createReadUpdateDestroyController, DmlCommands dmlCommand) {
		switch (dmlCommand) {
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

	/**
	 * To initialise the database schema. DatabaseConnectionUrl will default to
	 * localhost.
	 * 
	 * @param username
	 * @param password
	 */

	public void init(String username, String password) {
		init("jdbc:mysql://35.205.154.97/imsDB", username, password, "src/main/resources/imsDB-schema.sql");
	}

	public String readFile(String fileLocation) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				stringBuilder.append(string);
				stringBuilder.append("\r\n");
			}
		} catch (IOException e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
		return stringBuilder.toString();
	}

	public void init(String jdbcConnectionUrl, String username, String password, String fileLocation) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				try (Statement statement = connection.createStatement();) {
					statement.executeUpdate(string);
				}
			}
		} catch (SQLException | IOException e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
	}

}
