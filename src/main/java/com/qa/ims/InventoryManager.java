package com.qa.ims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.qa.ims.controllers.Action;
import com.qa.ims.controllers.CrudController;
import com.qa.ims.controllers.CustomerController;
import com.qa.ims.controllers.OrderController;
import com.qa.ims.controllers.OrderlineController;
import com.qa.ims.controllers.ProductController;
import com.qa.ims.persistence.dataaccessobjects.CustomerDataAccessObject;
import com.qa.ims.persistence.dataaccessobjects.OrderDataAccessObject;
import com.qa.ims.persistence.dataaccessobjects.OrderlineDataAccessObject;
import com.qa.ims.persistence.dataaccessobjects.ProductDataAccessObject;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.services.OrderServices;
import com.qa.ims.services.OrderlineServices;
import com.qa.ims.services.ProductServices;
import com.qa.ims.utils.Utils;

public class InventoryManager {

	public static final Logger LOGGER = Logger.getLogger(InventoryManager.class);

	public String initiateSystem(boolean managerLoop) {

		LOGGER.info("Please insert username: ");
		String username = getInput();
		LOGGER.info("Please insert password: ");
		String password = getInput();

		while (managerLoop = true) {

			boolean orderline = false;

			LOGGER.info("\n\nHello, " + username + ", how can I help you today?");
			LOGGER.info(
					"[1]: Review [customers]      [2]: Review [products]      [3]: Review [orders]      [4]: [help]      [5]: [stop]");
			String domainString = getInput();
			Domain domain = Domain.getDomain(domainString);

			if (domain.name().equalsIgnoreCase("stop")) {
				LOGGER.info("Ending Program");
				break;
			} else if (domain.name().equalsIgnoreCase("help")) {
				while (domain.name().equalsIgnoreCase("help")) {
					String helpString = getInput();
					domain = Domain.getDomain(helpString);
				}
			} else if (domain.name().equalsIgnoreCase("orders")) {
				LOGGER.info("Would you like to view all orders or a specific customer's orderline?");
				LOGGER.info("[1]: all [orders]      [2]: specific [orderline]");

				boolean orderlineSelecting = true;
				while (orderlineSelecting) {
					try {
						switch (getInput()) {
						case "1":
						case "orders":
							orderline = false;
							orderlineSelecting = false;
							break;
						case "2":
						case "orderline":
							orderline = true;
							orderlineSelecting = false;
							break;
						default:
							orderline = false;
							orderlineSelecting = true;
							throw new IllegalArgumentException(
									"Invalid selection please try again\n Would you like to view all orders or a specific customer's orderline?\n [1]: all [orders]      [2]: specific [orderline]");
						}
					} catch (IllegalArgumentException e) {
						LOGGER.error(
								"Invalid selection please try again\n Would you like to view all orders or a specific customer's orderline?\n [1]: all [orders]      [2]: specific [orderline]");
					}
				}
			}

			if (orderline == true) {
				LOGGER.info("You have selected 'ORDERLINE'. How would you like to proceed?");
			} else {
				LOGGER.info("You have selected '" + domain + "'. How would you like to proceed?");
			}
			LOGGER.info(
					"[1]: [create]      [2]: [read]      [3]: [update]      [4]: [delete]      [5]: [help]      [6]: [back]");
			String actionString = getInput();
			Action action = Action.getAction(actionString);

			switch (domain) {
			case CUSTOMERS:
				CustomerController customerController = new CustomerController(
						new CustomerServices(new CustomerDataAccessObject(username, password)));
				doAction(customerController, action);
				break;
			case PRODUCTS:
				ProductController productController = new ProductController(
						new ProductServices(new ProductDataAccessObject(username, password)));
				doAction(productController, action);
				break;
			case ORDERS:
				if (orderline == false) {
					OrderController orderController = new OrderController(
							new OrderServices(new OrderDataAccessObject(username, password)));
					doAction(orderController, action);
				} else {
					boolean orderlineRepeat = true;
					while (orderlineRepeat) {
						OrderlineController orderlineController = new OrderlineController(
								new OrderlineServices(new OrderlineDataAccessObject(username, password)));
						doAction(orderlineController, action);
						if (action != Action.CREATE) {
							orderlineRepeat = false;
						}
					}
				}
				break;
			case HELP:
				break;
			case STOP:
				break;
			default:
				break;
			}
		}
		return "Ending Program";
	}

	String getInput() {
		return Utils.getInput();
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case HELP:
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
		DBConfiguration dBConfiguration = new DBConfiguration();
		init(dBConfiguration.getJdbcConnectionUrl(), username, password, dBConfiguration.getImsDBSchema());
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
