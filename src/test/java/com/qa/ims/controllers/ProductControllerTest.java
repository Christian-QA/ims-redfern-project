package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.ProductProfile;
import com.qa.ims.services.ProductServices;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private ProductServices productServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private ProductController productController;

	@Test
	public void readAllTest() {
		ProductController productController = new ProductController(productServices);
		List<ProductProfile> products = new ArrayList<>();
		products.add(new ProductProfile(1L, "Dora the Annihilator", "Movies", new BigDecimal(99.99), 500L));
		products.add(new ProductProfile(1L, "Ketchup", "Food", new BigDecimal(2.99), 1000L));
		products.add(new ProductProfile(1L, "Cactus", "Miscellaneous", new BigDecimal(4.99), 10L));
		Mockito.when(productServices.readAll()).thenReturn(products);
		assertEquals(products, productController.readAll());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(productController).getInput();
		productController.delete();
		Mockito.verify(productServices, Mockito.times(1)).delete(1L);
	}

}