package net.minegeek360.ai.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	private static Word[]				knownWords				= new Word[99999];
	private static Map<String, Integer>	knownWordsKey			= new HashMap<String, Integer>();
	public static final String[]		presetGreetings			= { "hello", "hi", "greetings", "hey", "howdy", "greetings", "hiya", "ohio",
			"konichiwa", "ossu" };
	public static final String[]		presetQuestions			= { "what", "where", "who", "when", "why", "how" };
	public static final String[]		presetYesNoQuestions	= { "do", "can", "does", "is", "are" };
	public static final String[]		presetPropNouns			= { "i", "london", "fairburn", "sherburn", "sydney", "washington",
			"amsterdam" };
	public static final String[]		presetNames				= { "james", "noe", "evan", "oliver", "reilly", "keean", "aaron", "john",
			"ahna", "ged", "joe", "fiona", "emma" };
	public static final String[]		presetArticles			= { "a", "an", "the" };
	public static final String[]		presetResponse			= { "yes", "no" };

	/** Adds a word to the word bank
	 * 
	 * @param word
	 *            is the Word instance to be added to the word data bank */
	public static void addWord(Word word) {
		for (int i = 0; i < knownWords.length; i++) {
			if (knownWords[i] != null) {
				if (!knownWords[i].toString().equals(word.toString())) {
				}
			} else {
				knownWords[i] = word;
				knownWordsKey.put(word.toString(), i);
				return;
			}
		}
	}

	/** Gets all of the words known to the bot
	 * 
	 * @return Word[] is the list of words known to the bot */
	public static Word[] getKnownWords() {
		return knownWords;
	}

	/** Gets the Word object from the given string */
	public static Word getWord(String string) {
		if (knownWordsKey.containsKey(string)) { return knownWords[knownWordsKey.get(string)]; }
		return null;
	}

	public static Map<String, String> getWordTags(String string) {
		if (knownWordsKey.containsKey(string)) { return knownWords[knownWordsKey.get(string)].getTags(); }
		return null;
	}

	public static String[] getWordTagsArray(String string) {
		return (String[]) getWordTags(string).entrySet().toArray();
	}

	/** Returns all the words with the given tag */
	public static ArrayList<String> getAllWordsWithTag(String tag) {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < knownWords.length; i++) {
			if ((knownWords[i] != null) && (knownWords[i].getTags().containsKey(tag))) {
				temp.add(knownWords[i].toString());
			}
		}
		return temp;
	}
}
