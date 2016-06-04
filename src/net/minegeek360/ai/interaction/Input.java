package net.minegeek360.ai.interaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.skype.ChatMessage;
import com.skype.ChatMessageListener;
import com.skype.SkypeException;

import net.minegeek360.ai.AIFrame;
import net.minegeek360.ai.GeneticAI;

public class Input implements KeyListener, ActionListener, ChatMessageListener {

	private BufferedReader	br				= new BufferedReader(new InputStreamReader(System.in));
	private String			overrideText	= null;

	public String getInputText() {
		if (!GeneticAI.hasGUI) {
			System.out.print("User> ");
			try {
				return this.br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String temp = this.overrideText;
			this.overrideText = null;
			return temp;
		}
		return "NO INPUT";
	}

	private void handleText() {
		if (AIFrame.input.getText().startsWith(" ")) {
			AIFrame.input.setText("");
			return;
		}
		this.overrideText = AIFrame.input.getText();
		AIFrame.input.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		handleText();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			handleText();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void chatMessageReceived(ChatMessage cm) throws SkypeException {
		if (cm.getChat() == GeneticAI.chat) {
			overrideText = cm.getContent() + "";
		}
	}

	@Override
	public void chatMessageSent(ChatMessage cm) throws SkypeException {

	}
}
