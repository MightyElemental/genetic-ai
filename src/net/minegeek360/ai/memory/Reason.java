package net.minegeek360.ai.memory;

public class Reason {
	
	private final boolean aiCaused;
	
	public Reason(){
		aiCaused = false;
	}
	
	public boolean getAICauseEvent(){
		return this.aiCaused;
	}
	
	
	
}
