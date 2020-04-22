package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class DomainTest {
	@Test
	public void customerTest() {
		Domain domain = Domain.CUSTOMERS;
		assertTrue(domain.getDescription().toLowerCase().contains("customer"));
	}

	@Test
	public void itemTest() {
		Domain domain = Domain.PRODUCTS;
		assertTrue(domain.getDescription().toLowerCase().contains("product"));
	}

	@Ignore
	@Test
	public void orderTest() {
		Domain domain = Domain.ORDERS;
		assertTrue(domain.getDescription().toLowerCase().contains("products"));
	}

	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.getDescription().toLowerCase().contains("close"));
	}
}
