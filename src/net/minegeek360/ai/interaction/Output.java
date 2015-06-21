package net.minegeek360.ai.interaction;

public class Output {
	
	public static void aiSay(String message){
		String[] temp = message.split("");
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
	
}
