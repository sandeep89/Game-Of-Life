package com.gol.action;

import junit.framework.TestCase;

import com.gol.conf.Globals;
import com.opensymphony.xwork2.ActionSupport;

public class LoadGameActionTest extends TestCase {
	LoadGameAction index = new LoadGameAction();
	String result;

	protected void setUp() {
		index = new LoadGameAction();
		result = index.execute();
	}

	public void testLoadGameAction() throws Exception {
		assertTrue("Expected a success result!",
				ActionSupport.SUCCESS.equals(result));
		assertTrue("Expected Game Name text",
				Globals.GAME_NAME.equals(index.getGamename()));
	}

	public void testPlayGroundAreaDimension() throws Exception {
		assertTrue("Expected Global playground X dimentions",
				(Globals.MAX_X == (index.getMax_x())));
		assertTrue("Expected Global playground Y dimentions",
				(Globals.MAX_X == (index.getMax_y())));

	}
}
