package net.minegeek360.ai.language;

import java.util.ArrayList;

public class Sentence {
	public static final String QUESTION = "QUESTION";
	public static final String GREETING = "GREETING";
	public static final String STATEMENT = "STATEMENT";
	
	private static String checkComManager(String sent){
		String[] temp = sent.split(" ");
		ArrayList<String> temp2 = new ArrayList<String>();
		for(int i = 0; i < temp.length; i++){
			temp2.add(temp[i]);
			if(!WordComManager.getRule(temp2.toArray(new String[temp2.size()])).equals(Word.UNKNOWN)){
				//System.out.println(temp2.toString()+" "+WordComManager.getRule(temp2.toArray(new String[temp2.size()])));
				return WordComManager.getRule(temp2.toArray(new String[temp2.size()]));
			}else{
				//System.out.println(temp2.toString());
			}
		}
		return null;
	}

	public static String whatSentenceTypeIsThis(String sent) {
		String[] temp = sent.split(" ");
		ArrayList<String> temp2 = Dictionary.getAllWordsWithTag("GREETING");
		for (int i = 0; i < temp2.size(); i++) {
			if (temp2.get(i) == null) {
				break;
			}
			if (((String) temp2.get(i)).equals(temp[0])) {
				return "GREETING";
			}
		}
		temp2 = Dictionary.getAllWordsWithTag("QUESTION");
		/*if (temp.length > 1) {
			System.out.println("YES " + WordComManager.getRule(temp[0], temp[1]));
			if (WordComManager.getRule(temp[0], temp[1]).equals("QUESTION")) {
				return "QUESTION";
			}
		}*/
		
		String temp3 = checkComManager(sent);
		if(temp3 != null){
			return temp3;
		}
		
		for (int i = 0; i < temp2.size(); i++) {
			if (temp2.get(i) == null) {
				break;
			}
			if (((String) temp2.get(i)).equals(temp[0])) {
				return "QUESTION";
			}
		}
		return "UNKNOWN";
	}
}
