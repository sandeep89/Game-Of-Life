package com.gol.action;


import com.gol.services.GameService;
import com.opensymphony.xwork2.ActionSupport;

public class NextStateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String states;
	private GameService gameService;


	public String execute() {
		if(null != states){
			gameService = new GameService(states);
			setStates(gameService.progressGame());;
		}
        return SUCCESS;
	 }

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}
}
