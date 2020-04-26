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
import org.junit.Test;

public class ProductProfileTest {
	private ProductProfile product;
	private ProductProfile other;

	@Before
	public void setUp() {
		product = new ProductProfile(1L, "Paddie Vs Mason", "Movie",
				new BigDecimal(8.99).round(new MathContext(3, RoundingMode.HALF_UP)), 160L);
		other = new ProductProfile(1L, "15kg Dumbbell", "Health and Fitness", new BigDecimal(18.99), 50L);
	}

	@Test
	public void settersTestNotNull() {
		assertNotNull(product.getId());
		assertNotNull(product.getName());
		assertNotNull(product.getCategory());
		assertNotNull(product.getPrice());

		product.setId(null);
		assertNull(product.getId());
		product.setName(null);
		assertNull(product.getName());
		product.setCategory(null);
		assertNull(product.getCategory());
		product.setPrice(new BigDecimal(0.0));
		assertNotNull(product.getPrice());
		product.setInventory(0L);
		assertNotNull(product.getInventory());
	}

	@Test
	public void productNameNotEqual() {
		other.setName("15kg Dumbbell");
		assertFalse(product.equals(other));
	}

	@Test
	public void productCategoryNotEqual() {
		other.setCategory("Health and Fitness");
		assertFalse(product.equals(other));
	}

	@Test
	public void productPriceNotEqual() {
		other.setPrice(new BigDecimal(18.99).round(new MathContext(3, RoundingMode.HALF_UP)));
		assertFalse(product.equals(other));
	}

	@Test
	public void equalsWithNull() {
		assertFalse(product.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(product.equals(new Object()));
	}

	@Test
	public void createProductWithId() {
		assertEquals(1L, product.getId(), 0);
		assertEquals("Paddie Vs Mason", product.getName());
		assertEquals("Movie", product.getCategory());
	}

	@Test
	public void checkEquality() {
		assertTrue(product.equals(product));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(product.equals(other));
	}

	@Test
	public void productNameNullButOtherNameNotNull() {
		product.setName(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void productNamesNotEqual() {
		other.setName("15kg Dumbbell");
		assertFalse(product.equals(other));
	}

	@Test
	public void nullId() {
		product.setId(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void productIDDifferent() {
		other.setId(1L);
		assertFalse(product.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(product.equals(other));
	}

	@Test
	public void nullCategory() {
		product.setCategory(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void otherCategoryDifferent() {
		other.setCategory("thompson");
		assertFalse(product.equals(other));
	}

	@Test
	public void nullPrice() {
		product.setPrice(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void otherPriceDifferent() {
		other.setPrice(new BigDecimal(8.99).round(new MathContext(3, RoundingMode.HALF_UP)));
		assertFalse(product.equals(other));
	}

	@Test
	public void nullInventory() {
		product.setInventory(null);
		assertFalse(product.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		ProductProfile product = new ProductProfile("Paddie Vs Mason", "Movie",
				new BigDecimal(8.99).round(new MathContext(3, RoundingMode.HALF_UP)), 160L);
		assertNull(product.getId());
		assertNotNull(product.getName());
		assertNotNull(product.getCategory());
		assertNotNull(product.getPrice());
		assertNotNull(product.getInventory());
	}

	@Test
	public void hashCodeTestWithNull() {
		ProductProfile order = new ProductProfile(null, null, null, null, null);
		ProductProfile other = new ProductProfile(null, null, null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id: 1 | Name: Paddie Vs Mason | Category: Movie | Price: £8.99 | Inventory: 160\n ------------------------------------------------------";
		assertEquals(toString, product.toString());
	}

}