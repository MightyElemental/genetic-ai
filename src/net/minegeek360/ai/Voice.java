package net.minegeek360.ai;

import net.minegeek360.ai.interaction.Output;

import com.sun.speech.freetts.VoiceManager;

public class Voice {
	private String name;
	private com.sun.speech.freetts.Voice systemVoice;

	public Voice() {
		this.name = "kevin16";
		systemVoice = VoiceManager.getInstance().getVoice(this.name);
		//systemVoice.setLexicon(new CMULexicon());
		try{
			systemVoice.allocate();//CAUSES SO MUCH TROUBLE!!!! FIX THIS!!!
		}catch(Exception e){
			e.printStackTrace();
			Output.consoleSay("THE SETUP OF THE VOICE SYSTEM HAS FAILED!");
			Output.consoleSay("PLEASE MAKE SURE YOU HAVE jsapi INSTALLED!");
			GeneticAI.useVoice = false;
		}
	}

	public void say(String[] thingsToSay) {
		for (int i = 0; i < thingsToSay.length; i++) {
			this.say(thingsToSay[i]);
		}
	}

	public void say(String thingToSay) {
		this.systemVoice.speak(thingToSay);
	}

	public void dispose() {
		this.systemVoice.deallocate();
	}
}