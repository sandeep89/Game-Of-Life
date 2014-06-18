package com.gol.game;

import junit.framework.TestCase;

import com.gol.conf.Globals;

public class GameTest extends TestCase {
	Game blankGame, progressingGame;
	String states = "33,34,45,23,46,47";

	protected void setUp() {
		blankGame = new Game();
		progressingGame = new Game(states);
	}

	public void testBlankGame() throws Exception {
		PlayGround playGround = blankGame.getPlayGround();
		boolean[][] coreStates = playGround.getCoreState();
		int counter = 0;
		for (int y=0;y<Globals.MAX_Y ; y++){
			for(int x=0; x<Globals.MAX_X; x++){
				if(coreStates[x][y]){
					counter++;
				}
			}
		}
		assertTrue("Plyground for blank game should be empty",
				(0 == counter));
	}
	
	public void testProgressingGame() throws Exception {
		PlayGround playGround = progressingGame.getPlayGround();
		boolean[][] coreStates = playGround.getCoreState();
		int counter = 0;
		for (int y=0;y<Globals.MAX_Y ; y++){
			for(int x=0; x<Globals.MAX_X; x++){
				if(coreStates[x][y]){
					counter++;
				}
			}
		}
		assertTrue("Plyground should have 6 cells active in progressive game",
				(6 == counter));
	}

	public void testBlankGameProgress() throws Exception{
		String progressStatus = blankGame.getProgressStatus();
		assertTrue("There should be no progress status for a blank game",
				("").equals(progressStatus));
	}
	
	public void testProgresingGameStatus() throws Exception{
		String progressStatus = progressingGame.getProgressStatus();
		assertTrue("There should be no progress status for a blank game",
				("23,33,34,45,46,47").equals(progressStatus));
	}
}
