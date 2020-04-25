package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.OrderProfile;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private OrderServices orderServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private OrderController orderController;

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<OrderProfile> orders = new ArrayList<>();
		Date dateOrdered = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		orders.add(new OrderProfile(1L, 1L, (java.sql.Date) dateOrdered));
		orders.add(new OrderProfile(1L, 1L, (java.sql.Date) dateOrdered));
		orders.add(new OrderProfile(1L, 1L, (java.sql.Date) dateOrdered));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	/**
	 * 
	 */
	@Ignore
	@Test
	public void updateTest() {
		String oid = "1";
		String cid = "1";
		String dateOrdered = "2005-05-05";
		Date dateOrdered2 = Date.valueOf(dateOrdered);
		Mockito.doReturn(oid, cid, dateOrdered).when(orderController).getInput();
		OrderProfile order = new OrderProfile(1L, 1L, (java.sql.Date) dateOrdered2);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}

}