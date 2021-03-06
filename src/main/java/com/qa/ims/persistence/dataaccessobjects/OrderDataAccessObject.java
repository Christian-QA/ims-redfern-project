package com.qa.ims.persistence.dataaccessobjects;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.DBConfiguration;
import com.qa.ims.persistence.domain.OrderProfile;

public class OrderDataAccessObject implements DataAccessObject<OrderProfile> {

	public static final Logger LOGGER = Logger.getLogger(OrderDataAccessObject.class);

	DBConfiguration dBConfiguration = new DBConfiguration();

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderDataAccessObject(String username, String password) {
		this.jdbcConnectionUrl = dBConfiguration.getJdbcConnectionUrl();
		this.username = username;
		this.password = password;
	}

	OrderProfile orderProfileSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("order_id");
		Long cid = resultSet.getLong("customer_id");
		Date dateOrdered = resultSet.getDate("date_ordered");
		return new OrderProfile(oid, cid, dateOrdered);
	}

	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<OrderProfile> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			ArrayList<OrderProfile> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(orderProfileSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderProfile readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return orderProfileSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an empty order in the database
	 * 
	 * @param order - takes in a order object. id will be ignored. Products are
	 *              added through the orderline
	 */
	@Override
	public OrderProfile create(OrderProfile order) {
		String createPrepared = "insert into orders(customer_id, date_ordered) values(? , ?)";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statementPrepared = connection.prepareStatement(createPrepared);) {
			statementPrepared.setLong(1, order.getCid());
			statementPrepared.setDate(2, order.getDateOrdered());
			statementPrepared.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public OrderProfile readOrder(Long id) {
		String readOrderPrepared = "SELECT * FROM orders where order_id = ?";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statementPrepared = connection.prepareStatement(readOrderPrepared);) {
			statementPrepared.setLong(1, id);
			statementPrepared.executeQuery();
			try (ResultSet resultSet = statementPrepared.executeQuery();) {
				resultSet.next();
				return orderProfileSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in a order object, the id field will be used to update
	 *              that order in the database
	 * @return
	 */
	@Override
	public OrderProfile update(OrderProfile order) {
		String updatePrepared = "UPDATE orders SET customer_id = ? , date_ordered = ? WHERE order_id = ?";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statementPrepared = connection.prepareStatement(updatePrepared);) {
			statementPrepared.setLong(1, order.getCid());
			statementPrepared.setDate(2, order.getDateOrdered());
			statementPrepared.setLong(3, order.getOid());
			statementPrepared.executeUpdate();
			return readOrder(order.getOid());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public void delete(long id) {
		String deletePrepared = "delete from orders where order_id = ?";
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
