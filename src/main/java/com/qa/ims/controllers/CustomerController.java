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

	@Override
	public List<CustomerProfile> readAll() {
		List<CustomerProfile> customers = customerService.readAll();
		for (CustomerProfile customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

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

	@Override
	public CustomerProfile update() {
		LOGGER.info("Please enter the id of the customer you would like to update: ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		Customer customer = customerService.update(new Customer(id, firstName, surname));
		LOGGER.info("Customer Updated");
		return customer;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		customerService.delete(id);

	}

}
