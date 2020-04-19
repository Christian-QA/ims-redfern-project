package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.profiles.CustomerProfile;

public class CustomerServices implements CRUDServices<CustomerProfile> {

	private DataAccessObject<CustomerProfile> CustomerDataAccessObject;

	public CustomerServices(DataAccessObject<CustomerProfile> customerDao) {
		this.CustomerDataAccessObject = customerDao;
	}

	public List<CustomerProfile> readAll() {
		return CustomerDataAccessObject.readAll();
	}

	public CustomerProfile create(CustomerProfile customer) {
		return CustomerDataAccessObject.create(customer);
	}

	public CustomerProfile update(CustomerProfile customer) {
		return CustomerDataAccessObject.update(customer);
	}

	public void delete(Long id) {
		CustomerDataAccessObject.delete(id);
	}
}