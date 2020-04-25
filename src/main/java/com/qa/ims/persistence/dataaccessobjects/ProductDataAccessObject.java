package com.qa.ims.persistence.dataaccessobjects;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.DBConfiguration;
import com.qa.ims.persistence.domain.ProductProfile;

public class ProductDataAccessObject implements DataAccessObject<ProductProfile> {

	public static final Logger LOGGER = Logger.getLogger(ProductDataAccessObject.class);

	DBConfiguration dBConfiguration = new DBConfiguration();

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ProductDataAccessObject(String username, String password) {
		this.jdbcConnectionUrl = dBConfiguration.getJdbcConnectionUrl();
		this.username = username;
		this.password = password;
	}

	ProductProfile productProfileSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("product_id");
		String name = resultSet.getString("name");
		String category = resultSet.getString("category");
		BigDecimal price = resultSet.getBigDecimal("price");
		Long inventory = resultSet.getLong("inventory");
		return new ProductProfile(id, name, category, price, inventory);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<ProductProfile> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM products");) {
			ArrayList<ProductProfile> products = new ArrayList<>();
			while (resultSet.next()) {
				products.add(productProfileSet(resultSet));
			}
			return products;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public ProductProfile readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM products ORDER BY product_id DESC LIMIT 1");) {
			resultSet.next();
			return productProfileSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public ProductProfile create(ProductProfile product) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO products(name, category, price, inventory) values('"
					+ product.getName() + "','" + product.getCategory() + "','" + product.getPrice() + "','"
					+ product.getInventory() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public ProductProfile readProduct(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE product_id = " + id);) {
			resultSet.next();
			return productProfileSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public ProductProfile update(ProductProfile product) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE products SET name='" + product.getName() + "', category='"
					+ product.getCategory() + "', price='" + product.getPrice() + "', inventory='"
					+ product.getInventory() + "' WHERE product_id=" + product.getId());
			return readProduct(product.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from products where product_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
