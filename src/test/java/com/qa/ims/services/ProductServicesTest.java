package com.qa.ims.services;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.ProductProfile;

@RunWith(MockitoJUnitRunner.class)
public class ProductServicesTest {

	@Mock
	private DataAccessObject<ProductProfile> productDataAccessObject;

	@InjectMocks
	private ProductServices productServices;

	@Test
	public void productServicesCreate() {
		ProductProfile product = new ProductProfile(1L, "Jimmy Carrot's Big Tour", "Movies", new BigDecimal(14.99),
				50L);
		productServices.create(product);
		Mockito.verify(productDataAccessObject, Mockito.times(1)).create(product);
	}

	@Test
	public void productServicesRead() {
		productServices.readAll();
		Mockito.verify(productDataAccessObject, Mockito.times(1)).readAll();
	}

	@Test
	public void productServicesUpdate() {
		ProductProfile product = new ProductProfile(1L, "Jimmy Carrot's Big Tour", "Movies", new BigDecimal(14.99),
				50L);
		productServices.update(product);
		Mockito.verify(productDataAccessObject, Mockito.times(1)).update(product);
	}

	@Test
	public void productServicesDelete() {
		productServices.delete(1L);
		;
		Mockito.verify(productDataAccessObject, Mockito.times(1)).delete(1L);
	}

}
