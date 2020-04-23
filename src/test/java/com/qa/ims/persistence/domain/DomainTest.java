package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class DomainTest {
	@Test
	public void customerTest() {
		Domain domain = Domain.CUSTOMERS;
		assertTrue(domain.getDomainDescription().toLowerCase().contains("customer"));
	}

	@Test
	public void itemTest() {
		Domain domain = Domain.PRODUCTS;
		assertTrue(domain.getDomainDescription().toLowerCase().contains("product"));
	}

	@Ignore
	@Test
	public void orderTest() {
		Domain domain = Domain.ORDERS;
		assertTrue(domain.getDomainDescription().toLowerCase().contains("products"));
	}

	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.getDomainDescription().toLowerCase().contains("close"));
	}
}
