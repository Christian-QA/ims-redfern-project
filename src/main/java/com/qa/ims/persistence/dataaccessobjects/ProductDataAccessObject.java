package com.qa.ims.persistence.dataaccessobjects;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	 * Reads all products from the database
	 * 
	 * @return A list of products
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
	 * Creates a product in the database
	 * 
	 * @param product - takes in a product object. id will be ignored
	 */
	@Override
	public ProductProfile create(ProductProfile product) {
		String createPrepared = "insert into products(name, category, price, inventory) values(?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statementPrepared = connection.prepareStatement(createPrepared);) {
			statementPrepared.setString(1, product.getName());
			statementPrepared.setString(2, product.getCategory());
			statementPrepared.setBigDecimal(3, product.getPrice());
			statementPrepared.setLong(4, product.getInventory());
			statementPrepared.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public ProductProfile readProduct(Long id) {
		String readProductPrepared = "SELECT * FROM products where product_id = ?";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statementPrepared = connection.prepareStatement(readProductPrepared);) {
			statementPrepared.setLong(1, id);
			statementPrepared.executeQuery();
			try (ResultSet resultSet = statementPrepared.executeQuery();) {
				resultSet.next();
				return productProfileSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a product in the database
	 * 
	 * @param product - takes in a product object, the id field will be used to
	 *                update that product in the database
	 * @return
	 */
	@Override
	public ProductProfile update(ProductProfile product) {
		String updatePrepared = "UPDATE products SET name = ? , category = ?, price = ?, inventory = ? WHERE product_id = ?";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statementPrepared = connection.prepareStatement(updatePrepared);) {
			statementPrepared.setString(1, product.getName());
			statementPrepared.setString(2, product.getCategory());
			statementPrepared.setBigDecimal(3, product.getPrice());
			statementPrepared.setLong(4, product.getInventory());
			statementPrepared.setLong(5, product.getId());
			statementPrepared.executeUpdate();
			return readProduct(product.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a product in the database
	 * 
	 * @param id - id of the product
	 */
	@Override
	public void delete(long id) {
		String deletePrepared = "delete from products where product_id = ?";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statementPrepared = connection.prepareStatement(deletePrepared);) {
			statementPrepared.setLong(1, id);
			statementPrepared.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
