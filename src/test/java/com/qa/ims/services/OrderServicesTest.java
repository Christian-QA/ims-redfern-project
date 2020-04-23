package com.qa.ims.services;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.OrderProfile;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {

	@Mock
	private DataAccessObject<OrderProfile> orderDataAccessObject;

	@InjectMocks
	private OrderServices orderServices;

	@Test
	public void orderServicesCreate() {
		OrderProfile order = new OrderProfile(1L, 1L, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		orderServices.create(order);
		Mockito.verify(orderDataAccessObject, Mockito.times(1)).create(order);
	}

	@Test
	public void orderServicesRead() {
		orderServices.readAll();
		Mockito.verify(orderDataAccessObject, Mockito.times(1)).readAll();
	}

	@Test
	public void orderServicesUpdate() {
		OrderProfile order = new OrderProfile(1L, 1L, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		orderServices.update(order);
		Mockito.verify(orderDataAccessObject, Mockito.times(1)).update(order);
	}

	@Test
	public void orderServicesDelete() {
		orderServices.delete(1L);
		;
		Mockito.verify(orderDataAccessObject, Mockito.times(1)).delete(1L);
	}

}
