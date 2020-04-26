package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.ProductProfile;

public class ProductServices implements CrudServices<ProductProfile> {

	private DataAccessObject<ProductProfile> productDataAccessObject;

	public ProductServices(DataAccessObject<ProductProfile> product) {
		this.productDataAccessObject = product;
	}

	public List<ProductProfile> readAll() {
		return productDataAccessObject.readAll();
	}

	public ProductProfile create(ProductProfile product) {
		return productDataAccessObject.create(product);
	}

	public ProductProfile update(ProductProfile product) {
		return productDataAccessObject.update(product);
	}

	public void delete(Long id) {
		productDataAccessObject.delete(id);
	}
}