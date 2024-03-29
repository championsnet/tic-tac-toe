package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;

//Suppress to enoxlitiko warning gia serialization
@SuppressWarnings("serial")

public class BannerPanel extends javax.swing.JPanel {

	private final JButton quitButton;
	private final JButton addPlayerButton;
	private final JButton doneButton;
	
	private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 30;
	
	
	public BannerPanel() {
		
		setBackground(new Color(200, 200, 200));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
		
		quitButton = new JButton("QUIT");
		quitButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		quitButton.setAlignmentY(CENTER_ALIGNMENT);
		quitButton.setBackground(new Color(255, 100, 100));
		
		addPlayerButton = new JButton("ADD PLAYER");
		addPlayerButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		addPlayerButton.setAlignmentY(CENTER_ALIGNMENT);
		
		doneButton = new JButton("DONE");
		doneButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		doneButton.setAlignmentY(CENTER_ALIGNMENT);
		// At start done button must be disabled
		doneButton.setEnabled(false);
		
		add(quitButton);
		add(addPlayerButton);
		add(doneButton);
	}


	public JButton getQuitButton() {
		return quitButton;
	}


	public JButton getAddPlayerButton() {
		return addPlayerButton;
	}


	public JButton getDoneButton() {
		return doneButton;
	}
	
	
}
