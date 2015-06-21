package net.minegeek360.ai.interaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input implements ActionListener{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public static String getInputText(){
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "NO INPUT";
	}
}
