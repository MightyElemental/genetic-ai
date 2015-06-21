package net.minegeek360.ai.memory;

public class ShortTermMemory {
	
	private Event event;
	
	public ShortTermMemory(Event event){
		this.event = event;
	}
	
	public Event getEvent(){
		return this.event;
	}
	
}
