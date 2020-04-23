package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dataaccessobjects.DataAccessObject;
import com.qa.ims.persistence.domain.ProductProfile;

public class ProductServices implements CrudServices<ProductProfile> {

	private DataAccessObject<ProductProfile> ProductDataAccessObject;

	public ProductServices(DataAccessObject<ProductProfile> product) {
		this.ProductDataAccessObject = product;
	}

	public List<ProductProfile> readAll() {
		return ProductDataAccessObject.readAll();
	}

	public ProductProfile create(ProductProfile product) {
		return ProductDataAccessObject.create(product);
	}

	public ProductProfile update(ProductProfile product) {
		return ProductDataAccessObject.update(product);
	}

	public void delete(Long id) {
		ProductDataAccessObject.delete(id);
	}
}