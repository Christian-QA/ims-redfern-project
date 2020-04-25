package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

public class DomainTest {

	@Spy
	@InjectMocks
	private Domain domain;

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

	@Test
	public void orderTest() {
		Domain domain = Domain.ORDERS;
		assertTrue(domain.getDomainDescription().toLowerCase().contains("orders"));
	}

	@Test
	public void helpTest() {
		Domain domain = Domain.HELP;
		assertTrue(domain.getDomainDescription().toLowerCase().contains("help"));
	}

	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.getDomainDescription().toLowerCase().contains("close"));
	}

//	@Test
//	public void getDomainCommandTest() {
//		String givenCommand = "stop";
//		Mockito.doReturn(givenCommand).when(inventoryManager).getInput();
//
//		Mockito.when(domain).thenReturn(Domain.STOP);
//
//		assertEquals(domain, givenCommand);
//	}

}
