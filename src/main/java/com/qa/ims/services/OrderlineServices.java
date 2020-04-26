package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObjectOrderlineSpecific;
import com.qa.ims.persistence.domain.OrderlineProfile;

public class OrderlineServices implements CrudServicesOrderlineSpecific<OrderlineProfile> {

	private DataAccessObjectOrderlineSpecific<OrderlineProfile> orderlineDataAccessObject;

	public OrderlineServices(DataAccessObjectOrderlineSpecific<OrderlineProfile> orderline) {
		this.orderlineDataAccessObject = orderline;
	}

	public List<OrderlineProfile> readAll(Long oid) {
		return orderlineDataAccessObject.readAll(oid);
	}

	public OrderlineProfile create(OrderlineProfile orderline) {
		return orderlineDataAccessObject.create(orderline);
	}

	public OrderlineProfile update(OrderlineProfile orderline) {
		return orderlineDataAccessObject.update(orderline);
	}

	public void delete(Long pid, Long oid) {
		orderlineDataAccessObject.delete(pid, oid);
	}

}
