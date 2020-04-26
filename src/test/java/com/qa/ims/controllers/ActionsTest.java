package com.qa.ims.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

public class ActionsTest {

	@Spy
	@InjectMocks
	private Action action;

	@Test
	public void createTest() {
		Action action = Action.CREATE;
		assertTrue(action.getActionDescription().toLowerCase().contains("create"));
	}

	@Test
	public void readTest() {
		Action action = Action.READ;
		assertTrue(action.getActionDescription().toLowerCase().contains("read"));
	}

	@Test
	public void updateTest() {
		Action action = Action.UPDATE;
		assertTrue(action.getActionDescription().toLowerCase().contains("update"));
	}

	@Test
	public void deleteTest() {
		Action action = Action.DELETE;
		assertTrue(action.getActionDescription().toLowerCase().contains("delete"));
	}

	@Test
	public void helpTest() {
		Action action = Action.HELP;
		assertTrue(action.getActionDescription().toLowerCase().contains("help"));
	}

	@Test
	public void returnTest() {
		Action action = Action.RETURN;
		assertTrue(action.getActionDescription().toLowerCase().contains("return"));
	}

}
