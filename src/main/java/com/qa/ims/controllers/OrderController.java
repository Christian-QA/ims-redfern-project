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
	 * Reads all orders to the logger
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
	 * Creates a order by taking in user input.
	 */
	@Override
	public OrderProfile create() {
		LOGGER.info("Please enter customer id: ");
		Long cid = Long.valueOf(getInput());
		LOGGER.info("Please enter the date: ");
		Date dateOrdered = Date.valueOf(getInput());
		OrderProfile order = orderService.create(new OrderProfile(cid, dateOrdered));
		LOGGER.info("Order created.");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input. The customer needs to
	 * exists in the customers table. The date needs to be in yyyy-mm-dd format.
	 */
	@Override
	public OrderProfile update() {
		LOGGER.info("Please enter order id: ");
		Long oid = Long.valueOf(getInput());
		LOGGER.info("Please enter new customer id: ");
		Long cid = Long.valueOf(getInput());
		LOGGER.info("Please enter new date (yyyy-mm-dd): ");
		Date dateOrdered = Date.valueOf(getInput());
		OrderProfile order = orderService.update(new OrderProfile(oid, cid, dateOrdered));
		LOGGER.info("Order Updated.");
		return order;
	}

	/**
	 * Deletes an existing order by the id of the order
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete: ");
		Long oid = Long.valueOf(getInput());
		orderService.delete(oid);

	}

}
