package com.qa.ims.persistence.dataaccessobjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.profiles.CustomerProfile;

public class CustomerDataAccessObject implements DataAccessObject<CustomerProfile> {

	public static final Logger LOGGER = Logger.getLogger(CustomerDataAccessObject.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public CustomerDataAccessObject(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.205.154.97/imsDB";
		this.username = username;
		this.password = password;
	}

	public CustomerDataAccessObject(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	CustomerProfile customerProfileSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String forename = resultSet.getString("forename");
		String surname = resultSet.getString("surname");
		return new CustomerProfile(id, forename, surname);
	}

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

	@Override
	public CustomerProfile create(CustomerProfile t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerProfile update(CustomerProfile t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
