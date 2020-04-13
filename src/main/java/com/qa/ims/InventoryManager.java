package com.qa.ims;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public class InventoryManager {

	public static final Logger LOGGER = Logger.getLogger(InventoryManager.class);

	public void initiateSystem() {

		LOGGER.info("Please insert username: ");
		String username = Utils.getInput();
		LOGGER.info("Please insert password: ");
		String password = Utils.getInput();

		List<DBConfiguration> userList = new ArrayList<DBConfiguration>();

		userList.add(new DBUser(username, password, "jdbc:mysql://35.205.154.97/imsDB"));

		System.out.println(userList.get(0).getDB_URL());
		System.out.println(userList.get(0).getUSER());
		System.out.println(userList.get(0).getPASS());

		try {
			DB userToDB = new DB(userList.get(0).getUSER(), userList.get(0).getPASS(), userList.get(0).getDB_URL());
			userToDB.createCustomer("John", "Boy");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/// Scrap DBConfig in favour of a contructor,
		// this will enable listing all users and allow
		// private input

	}

}
