package com.qa.ims.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.profiles.CustomerProfile;
import com.qa.ims.services.CRUDServices;
import com.qa.ims.utils.Utils;

public class CustomerController implements CRUDController<CustomerProfile> {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerProfile update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
