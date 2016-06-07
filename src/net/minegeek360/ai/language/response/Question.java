package net.minegeek360.ai.language.response;

import java.util.List;

public abstract class Question {
	
	
	public abstract void answerQuestion(String sent, List<String> words);
	
}
