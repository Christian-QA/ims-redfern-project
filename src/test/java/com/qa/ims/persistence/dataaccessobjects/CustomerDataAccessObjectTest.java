package com.qa.ims.persistence.dataaccessobjects;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.DBConfiguration;
import com.qa.ims.InventoryManager;
import com.qa.ims.controllers.CustomerController;
import com.qa.ims.persistence.domain.CustomerProfile;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDataAccessObjectTest {

	@Mock
	private CustomerServices customerServices;

	@Spy
	@InjectMocks
	private CustomerController customerController;

	@BeforeClass
	public static void initTest() {
		InventoryManager inventoryManager = new InventoryManager();
		DBConfiguration dBConfiguration = new DBConfiguration();
		inventoryManager.init(dBConfiguration.getJdbcConnectionUrl(), "root", "root",
				"src/test/resources/imsDB-schema.sql");
	}

	@Ignore
	@Test
	public void createCustomerTest() {
		String forename = "Carth";
		String surname = "Hader";
		CustomerDataAccessObject customerDataAccessObject = new CustomerDataAccessObject("root", "root");
		CustomerProfile customer = new CustomerProfile(2L, forename, surname);
		assertEquals(customer, customerDataAccessObject.create(customer));
	}

	@Ignore
	@Test
	public void updateCustomerTest() {
		String id = "2";
		String forename = "Carth";
		String surname = "Hader";
		CustomerDataAccessObject customerDataAccessObject = new CustomerDataAccessObject("root", "root");
		CustomerProfile customer = new CustomerProfile(Long.parseLong(id), forename, surname);
		assertEquals(customer, customerDataAccessObject.update(customer));
	}

	@Ignore
	@Test
	public void gDeleteTest() {
		String id = "2";
		CustomerDataAccessObject customerDataAccessObject = new CustomerDataAccessObject("root", "root");
		customerDataAccessObject.delete(Long.parseLong(id));
		List<CustomerProfile> customers = new ArrayList<>();
		customers.add(new CustomerProfile(2L, "Carth", "Hader"));
		assertEquals(customers, customerDataAccessObject.readAll());
	}

}
