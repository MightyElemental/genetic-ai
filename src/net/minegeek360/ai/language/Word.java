package net.minegeek360.ai.language;

import java.util.HashMap;
import java.util.Map;

public class Word {

	public static final String	UNSURE				= "UNSURE";
	public static final String	DEFINATE			= "DEFINATE";
	public static final String	UNKNOWN				= "UNKNOWN";
	public static final String	NA					= "NA";
	public static final String	NOUN				= "NOUN";
	public static final String	PROPER_NOUN			= "PROP-NOUN";
	public static final String	ADJECTIVE			= "ADJECTIVE";
	public static final String	VERB				= "VERB";
	public static final String	GREETING			= "GREETING";
	public static final String	QUESTION			= "QUESTION";
	public static final String	EXPLAIN_QUESTION	= "EXPLAIN_QUESTION";
	public static final String	YES_NO_QUESTION		= "YES_NO_QUESTION";
	public static final String	NAME				= "NAME";
	public static final String	ARTICLE				= "ARTICLE";
	public static final String	RESPONSE			= "RESPONSE";
	private final String		word;
	private Map<String, String>	tags				= new HashMap<String, String>();

	public Word( String word ) {
		this.word = word;
	}

	public Word addTag(String tag, String surety) {
		// System.out.println(this.getClass() + " " + word + " " + tag + " " + surety);
		if (!this.tags.containsKey(tag)) {
			this.tags.put(tag, surety);
		}
		return this;
	}

	public Map<String, String> getTags() {
		return this.tags;
	}

	public String getWord() {
		return this.word;
	}

	public String toString() {
		return this.word;
	}
}
