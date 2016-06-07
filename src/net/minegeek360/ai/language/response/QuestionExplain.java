package net.minegeek360.ai.language.response;

import java.util.List;

import net.minegeek360.ai.interaction.Output;
import net.minegeek360.ai.language.Sentence;

public class QuestionExplain {

	public static void answerQuestion(String sent, List<String> words) {
		if (Sentence.isNegative(sent)) {
			if (sent.contains("is the sky")) {
				skyQuestion(sent);
			} else {
				Output.aiSay("because reasons");
			}
		} else {
			if (sent.contains("is the sky")) {
				skyQuestion(sent);
			} else {
				Output.aiSay("because reasons");
			}
		}
	}

	private static void skyQuestion(String sent) {
		String[] s = sent.split(" ");
		String ss = "";
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("sky")) {
				for (int j = i + 1; j < s.length; j++) {
					ss += s[j] + " ";
				}
				break;
			}
		}
		Output.aiSay("The sky is " + ss + "because mr fairy princess wanted it to be " + ss + "!");
	}

}
