package com.gol.action;

import com.gol.conf.Globals;
import com.opensymphony.xwork2.ActionSupport;

public class LoadGameAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String gamename; 
	
	public String execute()
	  {
		  setGamename(Globals.GAME_NAME);
	      return SUCCESS;
	  }
	
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public int getMax_x() {
		return Globals.MAX_X;
	}

	public int getMax_y() {
		return Globals.MAX_Y;
	}
}
