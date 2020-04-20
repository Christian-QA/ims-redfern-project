package com.qa.ims.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.profiles.ProductProfile;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.ProductServices;
import com.qa.ims.utils.Utils;

public class ProductController implements CrudController<ProductProfile> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<ProductProfile> productService;

	public ProductController(CrudServices<ProductProfile> productService) {
		this.productService = productService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all products to the logger
	 */
	@Override
	public List<ProductProfile> readAll() {
		List<ProductProfile> products = productService.readAll();
		for (ProductProfile product : products) {
			LOGGER.info(product.toString());
		}
		return products;
	}

	/**
	 * Creates a customer by taking in user input. Selecting 1 (Basic) means the
	 * input is limited to forename and surname, the NOT NULL values of the
	 * customers table. Selecting 2 (Advance) means the input includes age, email,
	 * address and username, the NULL values of the customers table.
	 */
	@Override
	public ProductProfile create() {
		LOGGER.info("Please enter name: ");
		String name = getInput();
		LOGGER.info("Please enter category: ");
		String category = getInput();
		LOGGER.info("Please enter price: ");
		String price = getInput();
		LOGGER.info("Please enter inventory: ");
		String inventory = getInput();
		ProductProfile product = ProductServices.create(new ProductProfile(name, category, price, inventory));
		LOGGER.info("Product created.");
		return product;
	}

	/**
	 * Updates an existing customer by taking in user input. Selecting 1 (Basic)
	 * means the input is limited to forename and surname, the NOT NULL values of
	 * the customers table. Selecting 2 (Advance) means the input includes age,
	 * email, address and username, the NULL values of the customer table.
	 */
	@Override
	public ProductProfile update() {
		LOGGER.info("Please enter the id of the product you would like to update: ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a name: ");
		String name = getInput();
		LOGGER.info("Please enter the product's category: ");
		String category = getInput();
		LOGGER.info("Please enter price per unit: ");
		String price = getInput();
		LOGGER.info("Please enter quantity of product: ");
		String inventory = getInput();
		ProductProfile product = ProductServices.create(new ProductProfile(name, category, price, inventory));
		LOGGER.info("Product Updated.");
		return product;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the product you would like to delete: ");
		Long id = Long.valueOf(getInput());
		productService.delete(id);

	}

}