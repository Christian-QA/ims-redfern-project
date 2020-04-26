package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OrderProfileTest {
	private OrderProfile order;
	private OrderProfile other;

	@Before
	public void setUp() {
		order = new OrderProfile(1L, 1L, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		other = new OrderProfile(1L, 1L, Date.valueOf("2000-5-1"));
	}

	@Test
	public void settersTestNotNull() {
		assertNotNull(order.getOid());
		assertNotNull(order.getCid());
		assertNotNull(order.getDateOrdered());

		order.setOid(null);
		assertNull(order.getOid());
		order.setCid(null);
		assertNull(order.getCid());
		order.setDateOrdered(null);
		assertNull(order.getDateOrdered());

	}

	@Test
	public void nullOid() {
		order.setOid(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void orderDateNotEqual() {
		other.setDateOrdered(Date.valueOf("2000-5-1"));
		assertFalse(order.equals(other));
	}

	@Test
	public void orderIDDifferent() {
		other.setOid(1L);
		assertFalse(order.equals(other));
	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(order.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		order.setCid(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void cidNotEqual() {
		order.setCid(1L);
		other.setCid(1L);
		assertFalse(order.equals(other));
	}

	@Test
	public void createOrderWithId() {
		assertEquals(1L, other.getCid(), 0);
		assertEquals(Date.valueOf("2000-5-1"), other.getDateOrdered());
	}

	@Test
	public void nullDate() {
		order.setDateOrdered(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		OrderProfile product = new OrderProfile(1L, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		assertNull(product.getOid());
		assertNotNull(product.getCid());
		assertNotNull(product.getDateOrdered());

	}

	@Ignore
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		OrderProfile order = new OrderProfile(null, null, null);
		OrderProfile other = new OrderProfile(null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "order id: 1 | customer id: 1 | Date Ordered: "
				+ new java.sql.Date(Calendar.getInstance().getTime().getTime())
				+ "\n ------------------------------------------------------";
		assertEquals(toString, order.toString());
	}

}