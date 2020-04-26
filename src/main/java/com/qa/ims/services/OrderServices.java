package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.OrderProfile;

public class OrderServices implements CrudServices<OrderProfile> {

	private DataAccessObject<OrderProfile> orderDataAccessObject;

	public OrderServices(DataAccessObject<OrderProfile> customer) {
		this.orderDataAccessObject = customer;
	}

	public List<OrderProfile> readAll() {
		return orderDataAccessObject.readAll();
	}

	public OrderProfile create(OrderProfile customer) {
		return orderDataAccessObject.create(customer);
	}

	public OrderProfile update(OrderProfile customer) {
		return orderDataAccessObject.update(customer);
	}

	public void delete(Long id) {
		orderDataAccessObject.delete(id);
	}
}