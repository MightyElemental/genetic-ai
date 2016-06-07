package net.minegeek360.ai.language.response;

import java.util.List;

import net.minegeek360.ai.interaction.Output;
import net.minegeek360.ai.language.Sentence;

public class QuestionExplain extends Question {
	
	
	@Override
	public void answerQuestion(String sent, List<String> words) {
		if (words.size() > 1 && Sentence.isNegative(sent)) {
			// Output.aiSay("because i am unsure about anything and everything");
			Output.aiSay("because reasons");
		} else {
			Output.aiSay("because reasons");
		}
	}
	
}
