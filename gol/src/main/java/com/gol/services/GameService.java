package com.gol.services;

import com.gol.game.Game;

/**
 * Class which abstracts my Game model from action class
 * @author Sandeep
 *
 */
public class GameService {

	private Game game;
	public GameService(String states) {
		game = new Game(states);
	}
	
	public String progressGame(){
		game.tick();
		return game.getProgressStatus();
	} 
}
