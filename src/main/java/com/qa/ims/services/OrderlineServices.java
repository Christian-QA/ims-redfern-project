package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObjectOrderlineSpecific;
import com.qa.ims.persistence.domain.OrderlineProfile;

public class OrderlineServices implements CrudServicesOrderlineSpecific<OrderlineProfile> {

	private DataAccessObjectOrderlineSpecific<OrderlineProfile> OrderlineDataAccessObject;

	public OrderlineServices(DataAccessObjectOrderlineSpecific<OrderlineProfile> orderline) {
		this.OrderlineDataAccessObject = orderline;
	}

	public List<OrderlineProfile> readAll(Long oid) {
		return OrderlineDataAccessObject.readAll(oid);
	}

	public OrderlineProfile create(OrderlineProfile orderline) {
		return OrderlineDataAccessObject.create(orderline);
	}

	public OrderlineProfile update(OrderlineProfile orderline) {
		return OrderlineDataAccessObject.update(orderline);
	}

	public void delete(Long oid) {
		OrderlineDataAccessObject.delete(oid);
	}

}
