package net.minegeek360.ai.memory;

public class Event {
	
	public final long TIME;
	public final Object INPUT;
	
	public Event(Object input){
		TIME = System.currentTimeMillis();
		INPUT = input;
	}
	
}
