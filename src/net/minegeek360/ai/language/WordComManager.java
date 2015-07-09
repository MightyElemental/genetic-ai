package net.minegeek360.ai.language;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordComManager {
	private static HashMap<List<String>, String> wordCombinations = new HashMap<List<String>, String>();
	
	public static final int BEFORE = 0;

	public static String getRule(String w1, String w2) {
		if (wordCombinations.containsKey(Arrays.asList(new String[] { w1, w2 }))) {
			return (String) wordCombinations.get(Arrays.asList(new String[] {w1, w2 }));
		}
		return "UNKNOWN";
	}
	
	/*
	 * MAKE THIS SYSTEM UNDERSTAND UNDER WHAT CIRCUMSTANCES IT IS TO
	 * INTERPERATE THESE WORDS AS THE END RESULT
	 * E.G. "what" - at beginning COMBINED WITH "your" + "name" ANYWHERE AFTER = QUESTION
	 */

	public static void createRule(String w1, String w2, String rule) {
		if (!wordCombinations.containsKey(Arrays.asList(new String[] { w1, w2 }))) {
			wordCombinations.put(Arrays.asList(new String[] { w1, w2 }), rule);
		}
	}
}
