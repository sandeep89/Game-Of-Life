package com.gol.game;

import com.gol.conf.Globals;

/**
 * Has a inheritance with playground, all the functionalities are performed on playground
 * @author Sandeep
 *
 */
public class Game {
	
	private PlayGround playGround;
	
	private String states;
	
	private void configurePlayground(){
		try{
			String[] markedStates = getStates().split(",");
			boolean[][] state = new boolean[Globals.MAX_X][Globals.MAX_Y];
			for (String markedState : markedStates) {
				int y = Integer.parseInt(markedState)/Globals.MAX_X;
				int x = Integer.parseInt(markedState) % Globals.MAX_X;
				state[x][y] = true;
			}
			playGround = new PlayGround(state);
		}catch(Exception ex){
			//TODO: Log the exception in application logger
			playGround = new PlayGround();
		}
	}
	public Game(String state){
		setStates(state);
		configurePlayground();
	}
	
	public Game(){
		playGround = new PlayGround();
	}

	public void tick() {
		playGround.progress();
	}
	
	public PlayGround getPlayGround() {
		return playGround;
	}

	public void setPlayGround(PlayGround playGround) {
		this.playGround = playGround;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}
	
	public String getProgressStatus(){
		String progressStates = new String();
		boolean[][] coreStates = playGround.getCoreState();
		
		for(int y =0; y<Globals.MAX_Y ; y++){
			for(int x=0; x<Globals.MAX_X ; x++){
				if(coreStates[x][y]){
					progressStates = (String) (progressStates.length() > 0 ? progressStates + "," + (Globals.MAX_Y * y + x) : (Globals.MAX_Y * y + x) + "");
				}
			}
		}
		return progressStates;
	}
}
