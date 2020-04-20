package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.profiles.CustomerProfile;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<CustomerProfile> customers = new ArrayList<>();
		customers.add(new CustomerProfile("Jon", "B"));
		customers.add(new CustomerProfile("Bon", "T"));
		customers.add(new CustomerProfile("Fon", "J"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}

	@Test
	public void createTest() {
		String forename = "Jon";
		String surname = "Bon";
		Mockito.doReturn(forename, surname).when(customerController).getInput();
		CustomerProfile customer = new CustomerProfile(forename, surname);
		CustomerProfile savedCustomer = new CustomerProfile(1L, "Jon", "Bon");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 * 
	 */

	@Test
	public void updateTest() {
		String customer_id = "1";
		String forename = "Bon";
		String surname = "Tee";
		Mockito.doReturn(customer_id, forename, surname).when(customerController).getInput();
		CustomerProfile customer = new CustomerProfile(1L, forename, surname);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */

	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

}