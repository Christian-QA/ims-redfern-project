package com.qa.ims;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controllers.OrderlineController;

@RunWith(MockitoJUnitRunner.class)
public class InventoryManagerTest {

	@Spy
	@InjectMocks
	private InventoryManager inventoryManager;
	private OrderlineController orderlineController;

	@BeforeClass
	public static void initTest() {
		InventoryManager inventoryManager = new InventoryManager();
		DBConfiguration dBConfiguration = new DBConfiguration();
		inventoryManager.init(dBConfiguration.getJdbcConnectionUrl(), "root", "root", dBConfiguration.getImsDBSchema());
	}

	@Test
	public void customerReadTest() {
		Mockito.doReturn("root", "root", "customers", "read", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Test
	public void customerReadByNumberTest() {
		Mockito.doReturn("root", "root", "1", "2", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Test
	public void productReadTest() {
		Mockito.doReturn("root", "root", "products", "read", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Test
	public void orderReadTest() {
		Mockito.doReturn("root", "root", "orders", "orders", "read", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Test
	public void orderlineReturnTest() {
		Mockito.doReturn("root", "root", "orders", "orderline", "return", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Test
	public void allWithFirstHelpReadTest() {
		Mockito.doReturn("root", "root", "help", "customers", "read", "products", "read", "orders", "orders", "read",
				"stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Test
	public void orderOrderlineInvalidTest() {
		Mockito.doReturn("root", "root", "orders", "rgdrth", "orders", "read", "stop").when(inventoryManager)
				.getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Ignore
	@Test
	public void invalidDomainTest() {
		Mockito.doReturn("root", "root", "sertgbsdrt", "customers", "read", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Ignore
	@Test
	public void invalidActionTest() {
		Mockito.doReturn("root", "root", "customers", "9", "read", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Ignore
	@Test
	public void wrongIP() {
		InventoryManager inventoryManager = new InventoryManager();
		DBConfiguration dBConfiguration = new DBConfiguration();
		dBConfiguration.setJdbcConnectionUrl("0.0.0.0");
		inventoryManager.init(dBConfiguration.getJdbcConnectionUrl(), "root", "root", dBConfiguration.getImsDBSchema());
		Mockito.doReturn("root", "root", "customers").when(inventoryManager).getInput();
		exception.expect(IOException.class);
		assertNotEquals("Ending Program", inventoryManager.initiateSystem());
	}

	@Test
	public void wrongUsername() {
		Mockito.doReturn("doot", "doot", "customers", "read", "stop").when(inventoryManager).getInput();
		assertEquals("Ending Program", inventoryManager.initiateSystem());
	}

}
