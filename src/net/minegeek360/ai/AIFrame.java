package net.minegeek360.ai;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AIFrame {
	private static String areaText = "";
	public static JFrame frame = new JFrame();
	public static JPanel panel1 = new JPanel();
	public static JTextArea textArea = new JTextArea();
	public static JTextField input = new JTextField();
	public static JButton button = new JButton("Submit");
	public static JScrollPane scrolling = new JScrollPane();

	public static void addText(String message) {
		String[] temp = message.split("");
		for (int i = 0; i < temp.length; i++) {
			areaText += temp[i];
			textArea.setText(areaText);
			try {
				Thread.sleep(20L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		areaText += "\n";
		textArea.setText(areaText);
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		refresh();
	}

	public static void refresh() {
		int lines = areaText.split("\n").length;
		textArea.setPreferredSize(new Dimension(640, 20 + lines * 18));
	}

	public static void setup() {
		frame.setTitle(GeneticAI.getName() + ", a learning chat bot");
		frame.setSize(640, 480);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(3);

		textArea.setPreferredSize(new Dimension(640, 20));
		scrolling.setPreferredSize(new Dimension(640, 410));
		textArea.setEditable(false);
		scrolling.setHorizontalScrollBarPolicy(31);
		scrolling.setVerticalScrollBarPolicy(22);
		scrolling.setViewportView(textArea);
		frame.add(scrolling, "North");

		input.setPreferredSize(new Dimension(555, 40));
		input.addKeyListener(GeneticAI.input);
		button.setPreferredSize(new Dimension(80, 40));
		button.addActionListener(GeneticAI.input);

		panel1.setLayout(new BorderLayout());
		panel1.add(input, BorderLayout.WEST);
		panel1.add(button, BorderLayout.EAST);
		frame.add(panel1, BorderLayout.SOUTH);
	}
}
