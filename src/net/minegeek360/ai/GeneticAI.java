package net.minegeek360.ai;

import net.minegeek360.ai.emotion.Emotion;
import net.minegeek360.ai.interaction.Input;
import net.minegeek360.ai.interaction.Output;

public class GeneticAI {
	
	public static String[] settings;
	
	public GeneticAI(){
		handleSettings();
		Output.aiSay("Hello there!");
		Output.aiSay("I am a chat bot that learns from the users!");
		Output.aiSay("My name is "+name);
		Output.aiSay("Type something in...");
		Output.aiSay(Input.getInputText());
	}
	
	public static void main(String[] args){
		settings = args;
		new GeneticAI();
	}
	
	public void handleSettings(){
		try{
			for(int i = 0; i < settings.length; i++){
				if(settings[i] != null){
					if(settings[i].equals("-p")){
						this.kindness = Integer.parseInt(settings[i+1]);
					}
					if(settings[i].equals("-name")){
						setName(settings[i+1]);
					}
				}
			}
		}catch(Exception e){}
	}
	
//----------------------------------------AI STARTS HERE-----------------------------------------------------------------
	
	public int kindness = 5; //scale 1-10; 0 - unrealistically abusive, 10 - unrealistically kind
	private Emotion currentEmotion;
	private String name = "Gaiben";
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public Emotion getCurrentEmotion(){
		return currentEmotion;
	}
	
	public void setCurrentEmotion(Emotion newEmotion){
		this.currentEmotion = newEmotion;
	}
	
	
	
}
