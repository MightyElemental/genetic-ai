package net.minegeek360.ai.interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String getInputText(){
		System.out.print("User> ");
		try {
			String temp = br.readLine();
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "NO INPUT";
	}
}
