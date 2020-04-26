package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OrderlineProfileTest {
	private OrderlineProfile orderline;
	private OrderlineProfile other;

	@Before
	public void setUp() {
		orderline = new OrderlineProfile(1L, 1L, "Milk",
				new BigDecimal(1.70).round(new MathContext(3, RoundingMode.HALF_UP)));
		other = new OrderlineProfile(1L, 1L, 50L);
	}

	@Test
	public void settersTestNotNull() {
		assertNotNull(other.getPid());
		assertNotNull(other.getOid());
		assertNotNull(other.getQuantityOrdered());

		other.setPid(null);
		assertNull(other.getPid());
		other.setOid(null);
		assertNull(other.getOid());
		other.setQuantityOrdered(null);
		assertNull(other.getQuantityOrdered());

	}

	@Test
	public void nullOid() {
		orderline.setOid(null);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void nullPid() {
		orderline.setPid(null);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void nullQuantityOrdered() {
		orderline.setQuantityOrdered(null);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void orderIDDifferent() {
		other.setOid(1L);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void productIDDifferent() {
		other.setPid(1L);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void orderQuantityNotEqual() {
		other.setQuantityOrdered(5L);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void equalsWithNull() {
		assertFalse(orderline.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(orderline.equals(new Object()));
	}

	@Test
	public void checkEquality() {
		assertTrue(orderline.equals(orderline));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(orderline.equals(other));
	}

	@Test
	public void orderlineQuantityNullButOtherQuantityNotNull() {
		orderline.setQuantityOrdered(null);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void pidNotEqual() {
		orderline.setPid(1L);
		other.setPid(1L);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void oidNotEqual() {
		orderline.setOid(1L);
		other.setOid(1L);
		assertFalse(orderline.equals(other));
	}

	@Test
	public void nullQuantity() {
		orderline.setQuantityOrdered(null);
		assertFalse(orderline.equals(other));
	}

	@Ignore
	@Test
	public void hashCodeTest() {
		assertEquals(orderline.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		OrderlineProfile order = new OrderlineProfile(null, null, null);
		OrderlineProfile other = new OrderlineProfile(null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "product id: 1 | name: Milk | Quantity: 1 | Price : £1.70 (£1.70 per item)";
		assertEquals(toString, orderline.toString());
	}

}
