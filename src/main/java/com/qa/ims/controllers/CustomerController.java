package com.qa.ims.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.profiles.CustomerProfile;
import com.qa.ims.services.CRUDServices;
import com.qa.ims.utils.Utils;

public class CustomerController implements CrudController<CustomerProfile> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CRUDServices<CustomerProfile> customerService;

	public CustomerController(CRUDServices<CustomerProfile> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<CustomerProfile> readAll() {
		List<CustomerProfile> customers = customerService.readAll();
		for (CustomerProfile customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input. Selecting 1 (Basic) means the
	 * input is limited to forename and surname, the NOT NULL values of the
	 * customers table. Selecting 2 (Advance) means the input includes age, email,
	 * address and username, the NULL values of the customers table.
	 */
	@Override
	public CustomerProfile create() {
		LOGGER.info("Please enter forename(s): ");
		String forename = getInput();
		LOGGER.info("Please enter surname: ");
		String surname = getInput();
		CustomerProfile customer = customerService.create(new CustomerProfile(forename, surname));
		LOGGER.info("Customer created.");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input. Selecting 1 (Basic)
	 * means the input is limited to forename and surname, the NOT NULL values of
	 * the customers table. Selecting 2 (Advance) means the input includes age,
	 * email, address and username, the NULL values of the customer table.
	 */
	@Override
	public CustomerProfile update() {
		LOGGER.info("Please enter the id of the customer you would like to update: ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a first name: ");
		String firstName = getInput();
		LOGGER.info("Please enter a surname: ");
		String surname = getInput();
		CustomerProfile customer = customerService.update(new CustomerProfile(id, firstName, surname));
		LOGGER.info("Customer Updated.");
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete: ");
		Long id = Long.valueOf(getInput());
		customerService.delete(id);

	}

}
