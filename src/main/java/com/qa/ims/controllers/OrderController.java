package com.qa.ims.controllers;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.profiles.OrderProfile;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<OrderProfile> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<OrderProfile> orderService;

	public OrderController(CrudServices<OrderProfile> orderService) {
		this.orderService = orderService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<OrderProfile> readAll() {
		List<OrderProfile> orders = orderService.readAll();
		for (OrderProfile order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input. Selecting 1 (Basic) means the
	 * input is limited to forename and surname, the NOT NULL values of the
	 * customers table. Selecting 2 (Advance) means the input includes age, email,
	 * address and username, the NULL values of the customers table.
	 */
	@Override
	public OrderProfile create() {
		LOGGER.info("Please enter customer id: ");
		Long cid = Long.valueOf(getInput());
		LOGGER.info("Please enter surname: ");
		Date dateOrdered = Date.valueOf(getInput());
		OrderProfile order = orderService.create(new OrderProfile(cid, dateOrdered));
		LOGGER.info("Customer created.");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input. Selecting 1 (Basic)
	 * means the input is limited to forename and surname, the NOT NULL values of
	 * the customers table. Selecting 2 (Advance) means the input includes age,
	 * email, address and username, the NULL values of the customer table.
	 */
	@Override
	public OrderProfile update() {
		LOGGER.info("Please enter forename(s): ");
		Long oid = Long.valueOf(getInput());
		LOGGER.info("Please enter forename(s): ");
		Long cid = Long.valueOf(getInput());
		LOGGER.info("Please enter surname: ");
		Date dateOrdered = Date.valueOf(getInput());
		OrderProfile order = orderService.update(new OrderProfile(oid, cid, dateOrdered));
		LOGGER.info("Customer Updated.");
		return order;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete: ");
		Long oid = Long.valueOf(getInput());
		orderService.delete(oid);

	}

}
