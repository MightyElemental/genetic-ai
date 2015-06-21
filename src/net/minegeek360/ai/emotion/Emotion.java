package net.minegeek360.ai.emotion;

public class Emotion {
	
	private final String name;
	private final int severityRating; //scale 1-10; 0 - unrealistically abusive, 10 - unrealistically kind
	
	public Emotion(String name, int severity){
		this.name = name;
		this.severityRating = severity;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getSeverityRating(){
		return this.severityRating;
	}
	
}
