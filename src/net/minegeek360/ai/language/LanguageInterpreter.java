package net.minegeek360.ai.language;

import java.util.ArrayList;
import java.util.Random;
import net.minegeek360.ai.GeneticAI;
import net.minegeek360.ai.interaction.Output;

public class LanguageInterpreter {
	private static Random rand = new Random();

	public static void greet() {
		ArrayList<String> temp2 = Dictionary.getAllWordsWithTag(Word.GREETING);
		Output.aiSay((String) temp2.get(rand.nextInt(temp2.size())));
	}

	private static void answerQuestion(String sent) {
		if(checkNames(sent)){ return; }
		if(yesNoQuestion(sent)){ return; }
		if(explainQuestion(sent)){ return; }
		
		Output.aiSay("let me answer that question with another question");
		Output.aiSay("what are you talking about");
	}
	
	private static boolean explainQuestion(String sent){
		String[] temp = sent.split(" ");
		if(Dictionary.getWordTags(temp[0]).containsKey(Word.EXPLAIN_QUESTION)){
			if(temp.length > 1){
				if(temp[1].equals("not")){
					Output.aiSay("because i am unsure about anything and everything!");
					return true;
				}
			}else{
				Output.aiSay("because i know everything!");
				return true;
			}
			return true;
		}
		return false;
	}
	
	private static final int positivePercentage = 40;
	
	private static boolean yesNoQuestion(String sent){
		String[] temp = {"yes", "no"};
		if(Dictionary.getWordTags(sent.split(" ")[0]).containsKey(Word.YES_NO_QUESTION)){
			int temp2 = rand.nextInt(100);
			if(temp2 < positivePercentage){
				Output.aiSay(temp[0]+" | "+temp2+"%");
			}else{
				Output.aiSay(temp[1]+" | "+temp2+"%");
			}
			return true;
		}
		return false;
	}
	
	private static boolean checkNames(String sent){
		if(sent.startsWith("what") && sent.contains("your name")){
			Output.aiSay("My name is "+GeneticAI.getName());
			return true;
		}else if(sent.startsWith("what") && sent.contains("my name")){
			ArrayList<String> temp = Dictionary.getAllWordsWithTag(Word.NAME);
			if(temp.size() == 0){
				Output.aiSay("is your name also "+GeneticAI.getName());
			}else{
				Output.aiSay("is your name "+temp.get(rand.nextInt(temp.size())));
			}
			return true;
		}
		return false;
	}

	public static void respond(String lastSaid, String sentType) {
		if (sentType.equals("GREETING")) {
			greet();
			GeneticAI.setConfused(false);
		} else if (sentType.equals("QUESTION")) {
			GeneticAI.setConfused(false);
			answerQuestion(lastSaid);
		} else {
			GeneticAI.setConfused(true);
		}
		if (GeneticAI.isConfused()) {
			Output.aiSay("what");
		}
	}

	private static String removePunc(String string) {
		return string.replaceAll("[^a-z 1-9]", "");
	}

	public static void interperate(String string) {
		if (string == null) {
			return;
		}
		string = string.toLowerCase();
		string = removePunc(string);
		Output.userSay(string);
		String[] temp = string.split(" ");
		for (int i = 0; i < temp.length; i++) {
			temp[i].replaceAll(" ", "");
			if(Dictionary.getWordTags(temp[i]) == null){
				Dictionary.addWord(new Word(temp[i]).addTag("UNKNOWN", "NA"));
			}
		}
		respond(string, Sentence.whatSentenceTypeIsThis(string));
	}
}
