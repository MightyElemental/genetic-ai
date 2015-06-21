package net.minegeek360.ai.language;

import net.minegeek360.ai.interaction.Output;


public class LanguageInterpreter {
	
	public static void interperate(String string){
		double temp2 = 0;
		String[] temp = string.split(" ");
		double temp3 = temp.length;
		for(int i = 0; i < temp.length; i++){
			temp2 += Dictionary.wordSeverity(temp[i]);
		}
		Output.aiSay("Average rating: "+(temp2/temp3));
	}
	
}
