package com.qa.ims.services;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.OrderlineProfile;

public class OrderlineServices implements OrderlineAlternateCrudServices<OrderlineProfile> {

	private DataAccessObject<OrderlineProfile> OrderlineDataAccessObject;

	public OrderlineServices(DataAccessObject<OrderlineProfile> orderline) {
		this.OrderlineDataAccessObject = orderline;
	}

	public OrderlineProfile readSpecific() {
		return OrderlineDataAccessObject.readSpecific();
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
