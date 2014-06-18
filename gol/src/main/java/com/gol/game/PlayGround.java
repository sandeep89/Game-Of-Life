package com.gol.game;

import com.gol.conf.Globals;

/**
 * This is the main model where all the computation happens
 * @author Sandeep
 *
 */
public class PlayGround{
	
	public boolean[][] coreState;
	
	public PlayGround(boolean[][] seedState){
		setCoreState(seedState);
	}
	
	public PlayGround(){
		setCoreState(getFreshState());
	}

	private int adjacentLivesCount(int xIndex, int yIndex) {
		int total = 0;
		if(areInBounds(xIndex-1,yIndex-1)) total+=1;
		if(areInBounds(xIndex-1,yIndex)) total+=1;
		if(areInBounds(xIndex-1,yIndex+1)) total+=1;
		if(areInBounds(xIndex,yIndex-1)) total+=1;
		if(areInBounds(xIndex,yIndex+1)) total+=1;
		if(areInBounds(xIndex+1,yIndex-1)) total+=1;
		if(areInBounds(xIndex+1,yIndex)) total+=1;
		if(areInBounds(xIndex+1,yIndex+1)) total+=1;
		return total;
	}
	
	private boolean areInBounds(int x, int y){
		if(x>=0 && y>=0 && x<Globals.MAX_X && y<Globals.MAX_Y)
			return coreState[x][y];
		return false;
	}
	
	private boolean[][] getFreshState() {
		boolean[][] state = new boolean[Globals.MAX_X][Globals.MAX_Y];
		for (int i = 0; i < Globals.MAX_X; i++) {
			state[i] = new boolean[Globals.MAX_Y];
			for (int j = 0; j < Globals.MAX_Y; j++) {
				state[i][j] = false;
			}
		}
		return state;
	}
	
	public void progress() {
		boolean[][] newState = getFreshState(); 
		for(int i=0;i<coreState.length;i++){
			for(int j=0;j<coreState[i].length;j++){
				int nearLives = adjacentLivesCount(i,j);
				newState[i][j] = coreState[i][j]; // Implicitly , if the cells have 2 or 3 live neigbours they live
				if(coreState[i][j]){
					if(nearLives < 2 || nearLives > 3)//if neigbours are less than 2 mor more than 3 they die
						newState[i][j] = false;
				}else{
					if(nearLives == 3){//if current cell has 3 live neighbours live no matter its live or dead
						newState[i][j] = true;
					}
				}
			}
		}
		coreState = newState;
	}
	
	public boolean[][] getCoreState() {
		return coreState;
	}

	public void setCoreState(boolean[][] coreState) {
		this.coreState = coreState;
	}
	
}
