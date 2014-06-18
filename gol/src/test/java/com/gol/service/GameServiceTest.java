package com.gol.service;

import junit.framework.TestCase;

import com.gol.services.GameService;

public class GameServiceTest extends TestCase {
	GameService service;

	protected void setUp() {
	}

	public void testValidServiceFuntionality() throws Exception {
		service = new GameService("11,13,39");
		assertTrue("There should be not states returned for the playground",
				("").equals(service.progressGame()));
	}

	public void testTextAsStatus() throws Exception {
		service = new GameService("this testing");
		assertTrue(
				"Next State should have one new live cell and also retain one of the existing live cell",
				("").equals(service.progressGame()));
	}

	public void testOutOfBound() throws Exception {
		service = new GameService("1011,1012,1013");
		assertTrue(
				"Next State should have one new live cell and also retain one of the existing live cell",
				("").equals(service.progressGame()));
	}
	
	public void testLowerBound() throws Exception {
		service = new GameService("-11,-12,-13");
		assertTrue(
				"Next State should have one new live cell and also retain one of the existing live cell",
				("").equals(service.progressGame()));
	}
}
