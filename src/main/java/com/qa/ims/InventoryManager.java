package com.qa.ims;

<<<<<<< HEAD
=======
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

>>>>>>> 9f15fc52b74eaa090e418a9c9dbb2c81fbb334d8
import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

public class InventoryManager {

	public static final Logger LOGGER = Logger.getLogger(InventoryManager.class);

	public void initiateSystem() {

		LOGGER.info("Please insert username: ");
		String username = Utils.getInput();
		LOGGER.info("Please insert password: ");
		String password = Utils.getInput();

<<<<<<< HEAD
		LOGGER.info("Hello, " + username + " how can I help you today?");
		System.out.println(
				"1): Review Customers      2): Review Products      3): Review Orders      4): Help      5): Stop");
		String tableSelectCommand = Utils.getInput();

		LOGGER.info("You have selected '" + tableSelectCommand + "'. How would you like to proceed?");
		System.out.println("1): Create      2): Read      3): Update      4): Delete      5): Help      6): Back");
		String DMLCommand = Utils.getInput();

	}
}
=======
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
>>>>>>> 9f15fc52b74eaa090e418a9c9dbb2c81fbb334d8
