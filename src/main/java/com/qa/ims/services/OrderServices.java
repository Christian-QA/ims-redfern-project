package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.profiles.OrderProfile;

public class OrderServices implements CrudServices<OrderProfile> {

	private DataAccessObject<OrderProfile> OrderDataAccessObject;

	public OrderServices(DataAccessObject<OrderProfile> customer) {
		this.OrderDataAccessObject = customer;
	}

	public List<OrderProfile> readAll() {
		return OrderDataAccessObject.readAll();
	}

	public OrderProfile create(OrderProfile customer) {
		return OrderDataAccessObject.create(customer);
	}

	public OrderProfile update(OrderProfile customer) {
		return OrderDataAccessObject.update(customer);
	}

	public void delete(Long id) {
		OrderDataAccessObject.delete(id);
	}
}