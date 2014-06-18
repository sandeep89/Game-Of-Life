package com.gol.game;

import junit.framework.TestCase;

import com.gol.conf.Globals;

public class PlayGroundTest extends TestCase {
	PlayGround blankPlayGround;

	// helper method
	private boolean[][] getCoreStatesForString(String state) {
		PlayGround standardPlayGround = new PlayGround();
		boolean[][] coreStates = standardPlayGround.getCoreState();
		String[] markedStates = state.split(",");
		for (String markedState : markedStates) {
			int y = Integer.parseInt(markedState) / Globals.MAX_X;
			int x = Integer.parseInt(markedState) % Globals.MAX_X;
			coreStates[x][y] = true;
		}
		return coreStates;
	}

	private int getCoreStatesCounter(boolean[][] coreStates) {
		int counter = 0;
		for (int y = 0; y < Globals.MAX_Y; y++) {
			for (int x = 0; x < Globals.MAX_X; x++) {
				if (coreStates[x][y]) {
					counter++;
				}
			}
		}
		return counter;
	}

	protected void setUp() {
		blankPlayGround = new PlayGround();
	}

	public void testBlankPlayGround() throws Exception {
		blankPlayGround.progress();
		boolean[][] coreStates = blankPlayGround.getCoreState();
		int counter = getCoreStatesCounter(coreStates);
		assertTrue("Core states should not change for blank playground",
				(0 == counter));
	}

	public void testOneCellCondition() throws Exception {
		PlayGround customPlayGround = new PlayGround(
				getCoreStatesForString("11"));
		customPlayGround.progress();
		assertTrue("There should be no live cell on theplayground",
				(0 == getCoreStatesCounter(customPlayGround.getCoreState())));
	}

	public void testCheckForOneNeighbour() throws Exception {
		PlayGround customPlayGround = new PlayGround(
				getCoreStatesForString("11,12"));
		customPlayGround.progress();
		assertTrue("There should be no live cell on theplayground",
				(0 == getCoreStatesCounter(customPlayGround.getCoreState())));
	}

	public void testCheckForTwoNeighbours() throws Exception {
		PlayGround customPlayGround = new PlayGround(
				getCoreStatesForString("36,62,10"));
		customPlayGround.progress();
		assertTrue("There should be no live cell on theplayground",
				(1 == getCoreStatesCounter(customPlayGround.getCoreState())));
	}
	
	public void testCheckForThreeNeighbours() throws Exception {
		PlayGround customPlayGround = new PlayGround(
				getCoreStatesForString("11,12,35"));
		customPlayGround.progress();
		assertTrue("There should be no live cell on theplayground",
				(2 == getCoreStatesCounter(customPlayGround.getCoreState())));
	}

	public void testCheckForFourNeighbours() throws Exception {
		PlayGround customPlayGround = new PlayGround(
				getCoreStatesForString("9,11,35,62,61"));
		customPlayGround.progress();
		assertTrue("There should be no live cell on theplayground",
				(4 == getCoreStatesCounter(customPlayGround.getCoreState())));
	}
	
}
