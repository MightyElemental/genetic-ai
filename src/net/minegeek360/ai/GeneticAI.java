package net.minegeek360.ai;

import net.minegeek360.ai.emotion.Emotion;
import net.minegeek360.ai.interaction.Input;
import net.minegeek360.ai.interaction.Output;
import net.minegeek360.ai.language.Dictionary;
import net.minegeek360.ai.language.LanguageInterpreter;
import net.minegeek360.ai.language.Word;
import net.minegeek360.ai.language.WordComManager;

public class GeneticAI {
	public static String[] settings;
	public static boolean hasGUI = true;
	public static Input input = new Input();

	private void setupDictionary() {
		for (int i = 0; i < Dictionary.presetGreetings.length; i++) {
			Dictionary.addWord(new Word(Dictionary.presetGreetings[i]).addTag(Word.GREETING, Word.DEFINATE));
		}
		for (int i = 0; i < Dictionary.presetQuestions.length; i++) {
			Dictionary.addWord(new Word(Dictionary.presetQuestions[i]).addTag(Word.QUESTION, Word.DEFINATE));
		}
		for (int i = 0; i < Dictionary.presetYesNoQuestions.length; i++) {
			Dictionary.addWord(new Word(Dictionary.presetYesNoQuestions[i]).addTag(Word.QUESTION, Word.DEFINATE)
					.addTag(Word.YES_NO_QUESTION, Word.DEFINATE));
		}
		for (int i = 0; i < Dictionary.presetPropNouns.length; i++) {
			Dictionary.addWord(new Word(Dictionary.presetPropNouns[i]).addTag(Word.PROPER_NOUN, Word.DEFINATE));
		}
		for (int i = 0; i < Dictionary.presetNames.length; i++) {
			Dictionary
					.addWord(new Word(Dictionary.presetNames[i]).addTag(Word.PROPER_NOUN, Word.DEFINATE).addTag(Word.NAME, Word.DEFINATE));
		}
		Dictionary.getWord("why").addTag(Word.EXPLAIN_QUESTION, Word.DEFINATE);
		WordComManager.createRule(new String[] { "how", "do", "you", "know" }, Word.EXPLAIN_QUESTION);
		WordComManager.createRule("may", "i", Word.QUESTION);
		WordComManager.createRule("am", "i", Word.YES_NO_QUESTION);
		WordComManager.createRule("will", "i", Word.YES_NO_QUESTION);
		WordComManager.createRule("will", "you", Word.YES_NO_QUESTION);
	}

	public GeneticAI() {
		handleSettings();
		if (hasGUI) {
			AIFrame.setup();
		}
		setupDictionary();

		// Output.consoleSay("Hello there!");
		Output.consoleSay("You are about to talk to a chat bot that learns from the users!");
		// Output.consoleSay("It has been named '" + name + "' by its master user");
		Output.consoleSay("Type something in and It will try to respond correctly...");
		Output.newLine();
		while (true) {
			LanguageInterpreter.interperate(input.getInputText());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		settings = args;
		new GeneticAI();
	}

	public void handleSettings() {
		try {
			for (int i = 0; i < settings.length; i++) {
				if (settings[i] != null) {
					if (settings[i].equals("-p")) {
						this.overallKindness = Integer.parseInt(settings[(i + 1)]);
					}
					if (settings[i].equals("-name")) {
						setName(settings[(i + 1)].replaceAll("_", " "));
					}
					if (settings[i].equals("-confuse")) {
						canBeConfused = Boolean.parseBoolean(settings[(i + 1)]);
					}
					if (settings[i].equals("-nogui")) {
						hasGUI = false;
					}
				}
			}
		} catch (Exception e) {
		}
	}

	public int overallKindness = 5;
	private Emotion currentEmotion;
	private static String name = "Gaiben";
	private static boolean isConfused = false;
	private static boolean canBeConfused = true;

	public static void setName(String newName) {
		name = newName;
	}

	public Emotion getCurrentEmotion() {
		return this.currentEmotion;
	}

	public void setCurrentEmotion(Emotion newEmotion) {
		this.currentEmotion = newEmotion;
	}

	public static boolean isConfused() {
		return (isConfused) && (canBeConfused);
	}

	public static void setConfused(boolean conf) {
		isConfused = conf;
	}

	public static String getName() {
		return name;
	}
}
