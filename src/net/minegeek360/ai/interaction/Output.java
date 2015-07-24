package net.minegeek360.ai.interaction;

import java.util.Map;

import net.minegeek360.ai.AIFrame;
import net.minegeek360.ai.GeneticAI;
import net.minegeek360.ai.language.Dictionary;
import net.minegeek360.ai.language.Sentence;

public class Output {
	private static String lastSaid = "";
	private static long lastSaidTime;

	public static void aiSay(String message) {
		lastSaid = message;
		lastSaidTime = System.currentTimeMillis() / 1000L;
		message = processSentToAppeal(message, Sentence.whatSentenceTypeIsThis(message));
		if (!GeneticAI.hasGUI) {
			String[] temp = message.split("");
			System.out.print(GeneticAI.getName() + "> ");
			for (int i = 0; i < temp.length; i++) {
				System.out.print(temp[i]);
				try {
					Thread.sleep(20L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("");
		} else {
			System.out.println(GeneticAI.getName() + "> " + message);
			AIFrame.addText(GeneticAI.getName() + "> " + message);
		}
	}

	public static void consoleSay(String message) {
		message = processSentToAppeal(message, null);
		if (!GeneticAI.hasGUI) {
			String[] temp = message.split("");
			System.out.print("Console> ");
			for (int i = 0; i < temp.length; i++) {
				System.out.print(temp[i]);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("");
		} else {
			AIFrame.addText("Console> " + message);
			System.out.println("Console> " + message);
		}
	}

	private static String processSentToAppeal(String sent, String sentType) {
		String[] splitSent = sent.split(" ");
		String temp3 = "";
		try {
			for (int i = 0; i < splitSent.length; i++) {
				Map<String, String> temp4 = Dictionary.getWordTags(splitSent[i]
						.replaceAll(" ", ""));
				if ((temp4 != null) && (temp4.containsKey("PROP-NOUN"))) {
					StringBuilder sb2 = new StringBuilder(splitSent[i]);
					splitSent[i] = (new StringBuilder(String.valueOf(sb2
							.charAt(0))).toString().toUpperCase() + sb2
							.deleteCharAt(0));
				}
			}
			for (int i = 0; i < splitSent.length; i++) {
				temp3 = temp3 + splitSent[i];
				if (i != splitSent.length - 1) {
					temp3 = temp3 + " ";
				}
			}
			sent = temp3;
		} catch (Exception e) {
			System.out.println("ERROR! SOMETHING WENT WRONG");
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder(sent);
		String temp = sb.charAt(0) + "";
		temp = temp.toUpperCase();
		sb.deleteCharAt(0);
		sb.insert(0, temp);
		if (sentType != null) {
			if (sentType.contains("QUESTION")) {
				sb.append("?");
			} else {
				sb.append(".");
			}
		}
		return sb.toString();
	}

	public static void userSay(String message) {
		if (GeneticAI.hasGUI) {
			message = processSentToAppeal(message,
					Sentence.whatSentenceTypeIsThis(message));
			AIFrame.addText("User> " + message);
			System.out.println("User> " + message);
		}
	}

	public static void newLine() {
		System.out.println("");
		AIFrame.addText("\n");
	}

	public static String getLastSaid() {
		return lastSaid;
	}

	public static long getLastSaidTime() {
		return lastSaidTime;
	}
}
