package net.minegeek360.ai.language;

import java.util.ArrayList;
import java.util.Random;

import net.minegeek360.ai.GeneticAI;
import net.minegeek360.ai.interaction.Output;



public class LanguageInterpreter {
	
	private static Random rand = new Random();
	
	/*public static void interperate(String string){
		double temp2 = 0;
		String[] temp = string.split(" ");
		double temp3 = temp.length;
		for(int i = 0; i < temp.length; i++){
			temp2 += Dictionary.wordSeverity(temp[i]);
		}
		Output.aiSay("Average rating: "+(temp2/temp3));
	}*/
	
	/*public static void interperate(String string){
		String[] temp = string.split(" ");
		for(int i = 0; i < temp.length; i++){
			Dictionary.wordSeverity(temp[i]);
		}
	}*/
	
	/*public static void respond(){
	Object[] temp = Dictionary.getWordMapAsArray();
	Output.aiSay("Which one of these is accurate?");
	for(int i = 0; i < 5; i++){
		String temp2 = "";
		for(int i1 = 0; i1 < (rand.nextInt(4)+1); i1++){
			int temp3 = rand.nextInt(temp.length);
			temp2 += temp[temp3];
		}
		Output.aiSay((i+1)+") "+temp2);
		
	}
	}*/
	
	public static void greet(){
		Object[] temp = Dictionary.getWordMeaningMapAsArray();
		Object[] temp2 = Dictionary.getWordMapAsArray();
		ArrayList<Object> temp3 = new ArrayList<Object>();
		for(int i = 0; i < temp2.length; i++){
			if(temp[i].equals("GREETING")){
				temp3.add(temp2[i]);
			}
		}
		Output.aiSay(temp3.get(rand.nextInt(temp3.size()))+"");
	}
	
	public static void respond(String lastSaid){
		if(Dictionary.getWordType(lastSaid).equals("GREETING")){
			greet();
			GeneticAI.setConfused(false);
		}else{
			GeneticAI.setConfused(true);
		}
		if(GeneticAI.isConfused()){
			Output.aiSay("What?");
		}
	}
	
	public static void interperate(String string){
		string = string.toLowerCase();
		String[] temp = string.split(" ");
		for(int i = 0; i < temp.length; i++){
			temp[i].replaceAll(" ", "");
			Dictionary.addWord(temp[i],"UNKNOWN");
		}
		respond(string);
	}
	
}
