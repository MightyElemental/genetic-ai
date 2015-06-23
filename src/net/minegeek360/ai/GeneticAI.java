package net.minegeek360.ai;

import net.minegeek360.ai.emotion.Emotion;
import net.minegeek360.ai.interaction.Input;
import net.minegeek360.ai.interaction.Output;
import net.minegeek360.ai.language.Dictionary;
import net.minegeek360.ai.language.LanguageInterpreter;

public class GeneticAI {
	
	public static String[] settings;
	
	public GeneticAI(){
		handleSettings();
		for(int i = 0; i < Dictionary.presetGreetings.length; i++){
			Dictionary.addWord(Dictionary.presetGreetings[i],"GREETING");
		}
		Output.aiSay("Hello there!");
		Output.aiSay("You are about to talk to a chat bot that learns from the users!");
		Output.aiSay("It has been named '"+name+"' by its master user");
		//Output.aiSay("Type something in and It will try to respond correctly...");
		while(true){
			LanguageInterpreter.interperate(Input.getInputText());
			
		}
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
						this.overallKindness = Integer.parseInt(settings[i+1]);
					}
					if(settings[i].equals("-name")){
						setName(settings[i+1].replaceAll("_", " "));
					}
					if(settings[i].equals("-confuse")){
						canBeConfused = Boolean.parseBoolean(settings[i+1]);
					}
				}
			}
		}catch(Exception e){}
	}
	
//----------------------------------------AI STARTS HERE-----------------------------------------------------------------
	
	public int overallKindness = 5; //scale 1-10; 0 - unrealistically abusive, 10 - unrealistically kind
	private Emotion currentEmotion;
	private static String name = "Gaiben";
	private static boolean isConfused = false;
	private static boolean canBeConfused = true;
	
	public static void setName(String newName){
		name = newName;
	}
	
	public Emotion getCurrentEmotion(){
		return currentEmotion;
	}
	
	public void setCurrentEmotion(Emotion newEmotion){
		this.currentEmotion = newEmotion;
	}
	
	public static boolean isConfused(){
		return isConfused && canBeConfused;
	}
	
	public static void setConfused(boolean conf){
		isConfused = conf;
	}
	
	public static String getName(){
		return name;
	}
	
	
}
