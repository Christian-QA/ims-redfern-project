package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.OrderlineProfile;

public class OrderlineServices {

	private DataAccessObject<OrderlineProfile> OrderlineDataAccessObject;

	public OrderlineServices(DataAccessObject<OrderlineProfile> orderline) {
		this.OrderlineDataAccessObject = orderline;
	}

	public List<OrderlineProfile> readAll() {
		return OrderlineDataAccessObject.readAll();
	}

	public OrderlineProfile create(OrderlineProfile orderline) {
		return OrderlineDataAccessObject.create(orderline);
	}

	public OrderlineProfile update(OrderlineProfile orderline) {
		return OrderlineDataAccessObject.update(orderline);
	}

	public void delete(Long id) {
		OrderlineDataAccessObject.delete(id);
	}

}
