package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.CustomerProfile;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServicesTest {

	@Mock
	private DataAccessObject<CustomerProfile> customerDataAccessObject;

	@InjectMocks
	private CustomerServices customerServices;

	@Test
	public void customerServicesCreate() {
		CustomerProfile customer = new CustomerProfile("chris", "perrins");
		customerServices.create(customer);
		Mockito.verify(customerDataAccessObject, Mockito.times(1)).create(customer);
	}

	@Test
	public void customerServicesRead() {
		customerServices.readAll();
		Mockito.verify(customerDataAccessObject, Mockito.times(1)).readAll();
	}

	@Test
	public void customerServicesUpdate() {
		CustomerProfile customer = new CustomerProfile("chris", "perrins");
		customerServices.update(customer);
		Mockito.verify(customerDataAccessObject, Mockito.times(1)).update(customer);
	}

	@Test
	public void customerServicesDelete() {
		customerServices.delete(1L);
		;
		Mockito.verify(customerDataAccessObject, Mockito.times(1)).delete(1L);
	}

}
