package com.qa.testims;

import org.junit.Test;

import com.qa.ims.InventoryManager;

public class imstest {
	private InventoryManager testIMS = new InventoryManager();

	@Test
	public void initiateSystemTest() {
		assertEquals("Hi John", testIMS.initiateSystem.username);

	}
}
