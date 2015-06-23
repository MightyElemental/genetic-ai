package net.minegeek360.ai.memory;

import net.minegeek360.ai.emotion.Emotion;

public class Memory {
	
	private final Event event;
	private final Emotion emotion;
	
	public Memory(Event event, Emotion emotion){
		this.event = event;
		this.emotion = emotion;
	}
	
	public Event getEvent(){
		return this.event;
	}
	
	public Emotion getConnectedEmotion(){
		return this.emotion;
	}
	
	
}
