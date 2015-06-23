package net.minegeek360.ai.interaction;

import net.minegeek360.ai.GeneticAI;


public class Output {
	
	private static String lastSaid = "";
	private static long lastSaidTime;
	
	public static void aiSay(String message){
		lastSaid = message;
		lastSaidTime = System.currentTimeMillis()/1000;
		String[] temp = message.split("");
		System.out.print(GeneticAI.getName()+"> ");
		for(int i = 0; i < temp.length; i++){
			System.out.print(temp[i]);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
	}
	
	/**Returns what the AI last said*/
	public static String getLastSaid(){
		return lastSaid;
	}
	
	/**Returns the second of the last said chat*/
	public static long getLastSaidTime(){
		return lastSaidTime;
	}
}
