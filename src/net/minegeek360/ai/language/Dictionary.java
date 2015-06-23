package net.minegeek360.ai.language;

import java.util.HashMap;
import java.util.Map;


public class Dictionary {
	
	private static Map<String,String> knownWords = new HashMap<String, String>();
	
	public final static String[] presetGreetings = {"hello","hi","greetings","hey","howdy","greetings","Hiya"};
	
	public static void addWord(String string, String catagory){
		if(!knownWords.containsKey(string)){
			knownWords.put(string, catagory);
		}
	}
	
	public static Object[] getWordMapAsArray(){
		return knownWords.keySet().toArray();
	}
	
	public static Object[] getWordMeaningMapAsArray(){
		Object[] temp = knownWords.entrySet().toArray();
		for(int i = 0; i < temp.length; i++){
			temp[i] = temp[i].toString().split("=")[1];
		}
		return temp;
	}
	
	public static Map<String,String> getKnownWords(){
		return knownWords;
	}
	
	public static String getWordType(String string){
		return knownWords.get(string);
	}
	
	public static String removePunc(String string){
		string = string.toLowerCase();
		string = string.replaceAll("[^a-z]", "");
		return string;
	}
	
	/*public static int wordSeverity(String string){//scale 1-10; 0 - unrealistically abusive, 10 - unrealistically kind, 5 - neutral
		switch(removePunc(string)){
		case "stupid": return 4;
		case "awesome": return 6;
		case "super": return 6;
		case "cool": return 6;
		case "idiot": return 4;
		case "retard": return 3;
		case "hate": return 4;
		case "xd": return 6;
		case "love": return 7;
		case "beautiful": return 7;
		}
		return 5;
	}*/
	
}
