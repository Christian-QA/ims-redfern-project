package com.qa.ims.services;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObjectOrderlineSpecific;
import com.qa.ims.persistence.domain.OrderlineProfile;

@RunWith(MockitoJUnitRunner.class)
public class OrderlineServicesTest {

	@Mock
	private DataAccessObjectOrderlineSpecific<OrderlineProfile> orderlineDataAccessObject;

	@InjectMocks
	private OrderlineServices orderlineServices;

	@Test
	public void orderServicesCreate() {
		OrderlineProfile order = new OrderlineProfile(1L, 1L, "Movie", new BigDecimal(1.99));
		orderlineServices.create(order);
		Mockito.verify(orderlineDataAccessObject, Mockito.times(1)).create(order);
	}

	@Test
	public void orderlineServicesRead() {
		orderlineServices.readAll(1L);
		Mockito.verify(orderlineDataAccessObject, Mockito.times(1)).readAll(1L);
	}

	@Test
	public void orderServicesUpdate() {
		OrderlineProfile order = new OrderlineProfile(1L, 1L, "Movie", new BigDecimal(1.99));
		orderlineServices.update(order);
		Mockito.verify(orderlineDataAccessObject, Mockito.times(1)).update(order);
	}

	@Test
	public void orderServicesDelete() {
		orderlineServices.delete(1L, 1L);
		;
		Mockito.verify(orderlineDataAccessObject, Mockito.times(1)).delete(1L, 1L);
	}

}
