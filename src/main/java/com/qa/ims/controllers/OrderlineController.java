package com.qa.ims.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderlineProfile;
import com.qa.ims.services.CrudServicesOrderlineSpecific;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudController<OrderlineProfile> {

	public static final Logger LOGGER = Logger.getLogger(OrderlineController.class);

	private CrudServicesOrderlineSpecific<OrderlineProfile> orderlineService;

	public OrderlineController(CrudServicesOrderlineSpecific<OrderlineProfile> orderlineService) {
		this.orderlineService = orderlineService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all orderlines to the logger
	 */
	@Override
	public List<OrderlineProfile> readAll() {
		LOGGER.info("Please enter the orderline (by id) you wish to view: ");
		Long oid = Long.valueOf(getInput());
		BigDecimal totalCost = new BigDecimal("0.0");
		List<OrderlineProfile> orderlines = orderlineService.readAll(oid);
		for (OrderlineProfile orderline : orderlines) {
			LOGGER.info(orderline.toString());
			totalCost = totalCost.add(orderline.getPrice().multiply(new BigDecimal(orderline.getQuantityOrdered())));
		}
		LOGGER.info("Total: £" + totalCost);
		LOGGER.info("-------------------------------------------");
		return orderlines;
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
		LOGGER.info("Order Updated.");
		return orderline;
	}

	/**
	 * Deletes an existing customer by
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the order (by id) you wish to delete: ");
		Long oid = Long.valueOf(getInput());
		LOGGER.info("Please enter the product (by id) you wish to delete: ");
		Long pid = Long.valueOf(getInput());
		orderlineService.delete(pid, oid);

	}

}
