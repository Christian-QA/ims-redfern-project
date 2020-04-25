package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.CustomerProfile;

public class CustomerServices implements CrudServices<CustomerProfile> {

	private DataAccessObject<CustomerProfile> customerDataAccessObject;

	public CustomerServices(DataAccessObject<CustomerProfile> customer) {
		this.customerDataAccessObject = customer;
	}

	public List<CustomerProfile> readAll() {
		return customerDataAccessObject.readAll();
	}

	public CustomerProfile create(CustomerProfile customer) {
		return customerDataAccessObject.create(customer);
	}

	public CustomerProfile update(CustomerProfile customer) {
		return customerDataAccessObject.update(customer);
	}

	public void delete(Long id) {
		customerDataAccessObject.delete(id);
	}
}