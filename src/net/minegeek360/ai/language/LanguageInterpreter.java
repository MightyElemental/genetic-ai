package net.minegeek360.ai.language;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minegeek360.ai.GeneticAI;
import net.minegeek360.ai.interaction.Output;

public class LanguageInterpreter {

	private static Random rand = new Random();

	public static List<String> conversationList = new ArrayList<String>();

	public static int getPositionOfTextInList(String sent) {
		for (int i = conversationList.size() - 1; i > 0; i--) {
			String tempSent = conversationList.get(i);
			if (sent.equals(tempSent)) {
				Output.consoleSay("" + i);
				return i;
			}
		}
		return 0;
	}

	private static void greet(String sent) {
		ArrayList<String> temp2 = Dictionary.getAllWordsWithTag(Word.GREETING);
		if (sent.contains("hello") && chance(70)) {
			Output.aiSay("i'm sorry, 'hello' is currently not applicable to the current conversation");
			Output.aiSay("please try again later");
		} else {
			Output.aiSay((String) temp2.get(rand.nextInt(temp2.size())));
		}
	}

	private static boolean chance(int percentage) {
		int temp = rand.nextInt(99);
		return temp < percentage;
	}

	private static void answerQuestion(String sent) {
		if (checkNames(sent)) { return; }
		if (yesNoQuestion(sent)) { return; }
		if (explainQuestion(sent)) { return; }

		Output.aiSay("let me answer that question with another question");
		Output.aiSay("what are you talking about");
	}

	private static boolean explainQuestion(String sent) {
		String[] temp = sent.split(" ");
		if (Dictionary.getWordTags(temp[0]).containsKey(Word.EXPLAIN_QUESTION)
				|| Sentence.whatSentenceTypeIsThis(sent).equals(Word.EXPLAIN_QUESTION)) {
			if (temp.length > 1 && temp[1].equals("not")) {
				// Output.aiSay("because i am unsure about anything and everything");
				Output.aiSay("because reasons");
				return true;
			} else {
				Output.aiSay("because reasons");
				return true;
			}
		}
		return false;
	}

	private static final int positivePercentage = 40;

	private static boolean yesNoQuestion(String sent) {
		String[] temp = { "yes", "no" };
		if (Dictionary.getWordTags(sent.split(" ")[0]).containsKey(Word.YES_NO_QUESTION)
				|| Sentence.whatSentenceTypeIsThis(sent).equals(Word.YES_NO_QUESTION)) {
			if (chance(positivePercentage)) {
				// Output.aiSay(temp[0]+" | "+temp2+"%");
				Output.aiSay(temp[0]);
			} else {
				// Output.aiSay(temp[1]+" | "+temp2+"%");
				Output.aiSay(temp[1]);
			}
			return true;
		}
		return false;
	}

	private static boolean checkNames(String sent) {
		if (sent.startsWith("what") && sent.contains("your name")) {
			Output.aiSay("My name is " + GeneticAI.getName());
			return true;
		} else if (sent.startsWith("what") && sent.contains("my name")) {
			ArrayList<String> temp = Dictionary.getAllWordsWithTag(Word.NAME);
			if (temp.size() == 0) {
				Output.aiSay("is your name also " + GeneticAI.getName());
			} else {
				Output.aiSay("is your name " + temp.get(rand.nextInt(temp.size())));
			}
			return true;
		}
		return false;
	}

	public static void respond(String lastSaid, String sentType) {
		if (sentType.equals(Word.GREETING)) {
			greet(lastSaid);
			GeneticAI.setConfused(false);
		} else if (sentType.contains(Word.QUESTION)) {
			GeneticAI.setConfused(false);
			answerQuestion(lastSaid);
		} else if (lastSaid.startsWith("say")) {
			if (chance(60)) {
				Output.aiSay(lastSaid.replaceFirst("say ", ""));
			} else if (chance(40)) {
				Output.aiSay("why");
			} else {
				Output.aiSay("no");
			}
		} else if (lastSaid.contains("list conver")) {
			GeneticAI.setConfused(false);
			Output.consoleSay(conversationList.toString());
		} else if (lastSaid.contains("list nouns")) {
			GeneticAI.setConfused(false);
			for (String noun : Dictionary.getAllWordsWithTag(Word.NOUN)) {
				Output.consoleSay(noun);
			}
		} else if (conversationList.size() - 1 >= 0 && Sentence.whatSentenceTypeIsThis(lastSaid).equals(Word.RESPONSE)) {
			GeneticAI.setConfused(false);
			if (chance(40)) {
				Output.aiSay("Are you sure you meant to say '" + conversationList.get(conversationList.size() - 1) + "'");
			} else if (chance(20)) {
				Output.aiSay("What do you mean '" + conversationList.get(conversationList.size() - 1) + "'");
			} else {
				Output.aiSay("By saying '" + conversationList.get(conversationList.size() - 1)
						+ "' do you really mean that you have no clue what I am on about");
			}
		} else {
			GeneticAI.setConfused(true);
		}
		if (GeneticAI.isConfused()) {
			Output.aiSay("what");
		}
	}

	private static String removePunc(String string) {
		return string.replaceAll("[^a-z 1-9-]", "");
	}

	public static void interperate(String string) {
		if (string == null) { return; }
		string = string.toLowerCase();
		string = removePunc(string);
		conversationList.add(string);
		Output.userSay(string);
		String[] temp = string.split(" ");
		for (int i = 0; i < temp.length; i++) {
			temp[i].replaceAll(" ", "");
			if (Dictionary.getWord(temp[i]) != null) {
				if (i < temp.length - 1 && Dictionary.getWord(temp[i]).getTags().containsKey(Word.ARTICLE)) {
					Dictionary.addWord(new Word(temp[i + 1]).addTag(Word.NOUN, Word.UNSURE));
					i++;
				}
			} else if (Dictionary.getWordTags(temp[i]) == null) {
				Dictionary.addWord(new Word(temp[i]).addTag(Word.UNKNOWN, Word.NA));
			}
		}
		respond(string, Sentence.whatSentenceTypeIsThis(string));
	}
}
