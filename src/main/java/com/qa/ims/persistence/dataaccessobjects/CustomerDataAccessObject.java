package com.qa.ims.persistence.dataaccessobjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.DBConfiguration;
import com.qa.ims.persistence.domain.CustomerProfile;

public class CustomerDataAccessObject implements DataAccessObject<CustomerProfile> {

	public static final Logger LOGGER = Logger.getLogger(CustomerDataAccessObject.class);

	DBConfiguration dBConfiguration = new DBConfiguration();

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public CustomerDataAccessObject(String username, String password) {
		this.jdbcConnectionUrl = dBConfiguration.getJdbcConnectionUrl();
		this.username = username;
		this.password = password;
	}

	CustomerProfile customerProfileSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("customer_id");
		String forename = resultSet.getString("forename");
		String surname = resultSet.getString("surname");
		return new CustomerProfile(id, forename, surname);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<CustomerProfile> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");) {
			ArrayList<CustomerProfile> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(customerProfileSet(resultSet));
			}
			return customers;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public CustomerProfile readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM customers ORDER BY customer_id DESC LIMIT 1");) {
			resultSet.next();
			return customerProfileSet(resultSet);
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
	public CustomerProfile create(CustomerProfile customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into customers(forename, surname) values('" + customer.getForename() + "','"
					+ customer.getSurname() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public CustomerProfile readCustomer(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers where customer_id = " + id);) {
			resultSet.next();
			return customerProfileSet(resultSet);
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
	public CustomerProfile update(CustomerProfile customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE customers SET forename='" + customer.getForename() + "', surname='"
					+ customer.getSurname() + "' WHERE customer_id=" + customer.getId());
			return readCustomer(customer.getId());
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
			statement.executeUpdate("delete from customers where customer_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
