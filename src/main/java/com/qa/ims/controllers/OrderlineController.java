package com.qa.ims.controllers;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderlineProfile;
import com.qa.ims.services.OrderlineAlternateCrudServices;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudOrderlineController<OrderlineProfile> {

	public static final Logger LOGGER = Logger.getLogger(OrderlineController.class);

	private OrderlineAlternateCrudServices<OrderlineProfile> orderlineService;

	public OrderlineController(OrderlineAlternateCrudServices<OrderlineProfile> orderlineService) {
		this.orderlineService = orderlineService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads specific orderline to the logger
	 */
	@Override
	public OrderlineProfile readSpecific() {
		LOGGER.info("Please enter the order (by id) you wish to read: ");
		Long oid = Long.valueOf(getInput());
		OrderlineProfile orderline = orderlineService.readSpecific(oid);
		LOGGER.info(orderline.toString());
		return orderline;
	}

	/**
	 * 
	 * 
	 */
	@Override
	public OrderlineProfile create() {
		LOGGER.info("Please enter the order (by id) you wish to add to: ");
		Long oid = Long.valueOf(getInput());
		LOGGER.info("Please enter the product (by id) you wish to add: ");
		Long pid = Long.valueOf(getInput());
		LOGGER.info("How many would you like to add?");
		Long quantity = Long.valueOf(getInput());
		OrderlineProfile orderline = orderlineService.create(new OrderlineProfile(pid, oid, quantity));
		LOGGER.info("Customer created.");
		return orderline;
	}

	/**
	 * 
	
	 */
	@Override
	public OrderlineProfile update() {
		LOGGER.info("Please enter the order (by id) you wish to add to: ");
		Long oid = Long.valueOf(getInput());
		LOGGER.info("Please enter the product (by id) you wish to add: ");
		Long pid = Long.valueOf(getInput());
		LOGGER.info("How many would you like to add?");
		Long quantity = Long.valueOf(getInput());
		OrderlineProfile orderline = orderlineService.update(new OrderlineProfile(pid, oid, quantity));
		LOGGER.info("Orderline Updated.");
		return orderline;
	}

	/**
	 * Deletes an existing customer by
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the orderline (by id) you wish to delete: ");
		Long oid = Long.valueOf(getInput());
		orderlineService.delete(oid);

	}

}
