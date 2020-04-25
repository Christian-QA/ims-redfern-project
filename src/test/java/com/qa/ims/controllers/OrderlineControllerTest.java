package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.OrderlineProfile;
import com.qa.ims.services.OrderlineServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderlineControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private OrderlineServices orderlineServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private OrderlineController orderlineController;

	@Test
	public void readAllTest() {
		OrderlineController orderlineController = new OrderlineController(orderlineServices);
		List<OrderlineProfile> orderline = new ArrayList<>();
		orderline.add(new OrderlineProfile(1L, 1L, "Genuine Runestone", new BigDecimal(9.99)));
		orderline.add(new OrderlineProfile(1L, 1L, "Whey Protein", new BigDecimal(9.99)));
		orderline.add(new OrderlineProfile(1L, 1L, "Beats by Dre", new BigDecimal(9.99)));
		Mockito.when(orderlineServices.readAll(1L)).thenReturn(orderline);
		assertEquals(orderline, orderlineController.readAll());
	}

	/**
	 * 
	 */
	@Ignore
	@Test
	public void updateTest() {
		String pid = "1";
		String oid = "1";
		String inventory = "500";
		Mockito.doReturn(pid, oid, inventory).when(orderlineController).getInput();
		OrderlineProfile orderline = new OrderlineProfile(1L, 1L, 500L);
		Mockito.when(orderlineServices.update(orderline)).thenReturn(orderline);
		assertEquals(orderline, orderlineController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderlineController).getInput();
		orderlineController.delete();
		Mockito.verify(orderlineServices, Mockito.times(1)).delete(1L);
	}

}