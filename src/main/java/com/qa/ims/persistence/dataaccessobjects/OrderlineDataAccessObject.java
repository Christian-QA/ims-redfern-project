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
import com.qa.ims.persistence.domain.OrderlineProfile;

public class OrderlineDataAccessObject implements DataAccessObjectOrderlineSpecific<OrderlineProfile> {

	public static final Logger LOGGER = Logger.getLogger(OrderlineDataAccessObject.class);

	DBConfiguration dBConfiguration = new DBConfiguration();

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderlineDataAccessObject(String username, String password) {
		this.jdbcConnectionUrl = dBConfiguration.getJdbcConnectionUrl();
		this.username = username;
		this.password = password;
	}

	OrderlineProfile orderlineProfileSet(ResultSet resultSet) throws SQLException {
		Long pid = resultSet.getLong("product_id");
		Long quantityOrdered = resultSet.getLong("quantity_ordered");
		String name = resultSet.getString("name");
		BigDecimal price = resultSet.getBigDecimal("price");
		return new OrderlineProfile(pid, quantityOrdered, name, price);
	}

	OrderlineProfile orderlineProfileSetTwo(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("order_id");
		Long pid = resultSet.getLong("product_id");
		Long quantityOrdered = resultSet.getLong("quantity_ordered");
		return new OrderlineProfile(oid, pid, quantityOrdered);
	}

	/**
	 * Reads all of the items in a specific orderline
	 * 
	 * @return A list of products within an orderline
	 */
	@Override
	public List<OrderlineProfile> readAll(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT o.quantity_ordered, o.order_id, p.product_id, name, price FROM products p JOIN orderline o ON p.product_id=o.product_id WHERE o.order_id = "
								+ id);) {
			ArrayList<OrderlineProfile> orderline = new ArrayList<>();
			while (resultSet.next()) {
				orderline.add(orderlineProfileSet(resultSet));
			}
			return orderline;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderlineProfile readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM orderline ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return orderlineProfileSetTwo(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Adds products to an order in the form of an orderline
	 * 
	 * @param orderline - takes in a orderline object. id will be ignored
	 */
	@Override
	public OrderlineProfile create(OrderlineProfile orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orderline(order_id, product_id, quantity_ordered) values('"
					+ orderline.getOid() + "','" + orderline.getPid() + "','" + orderline.getQuantityOrdered() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public OrderlineProfile readCustomer(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where order_id = " + id);) {
			resultSet.next();
			return orderlineProfileSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Allows the user to add products to an orderline in the database
	 * 
	 * @param orderline - takes in a order object, the id field will be used to
	 *                  update that order in the database
	 * @return
	 */
	@Override
	public OrderlineProfile update(OrderlineProfile orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE orderline SET product_id ='" + orderline.getPid() + "', quantity_ordered='"
					+ orderline.getQuantityOrdered() + "' WHERE order_id=" + orderline.getOid());
			return readCustomer(orderline.getOid());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a product from an order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public void delete(long pid, long oid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orderline WHERE order_id = " + oid + " AND product_id = " + pid);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
