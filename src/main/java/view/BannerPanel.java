package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Suppress to enoxlitiko warning gia serialization
@SuppressWarnings("serial")

public class BannerPanel extends javax.swing.JPanel {

	private final JButton quitButton;
	private final JButton addPlayerButton;
	private final JButton doneButton;
	
	private ActionListener quitAction;
	private ActionListener addPlayerAction;
	private ActionListener doneAction;
	
	private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 30;
	
	
	public BannerPanel() {
		
		setBackground(new Color(200, 200, 200));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
		
		quitButton = new JButton("QUIT");
		quitButton.addActionListener(quitAction);
		quitButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		quitButton.setAlignmentY(CENTER_ALIGNMENT);
		quitButton.setBackground(new Color(255, 100, 100));
		
		addPlayerButton = new JButton("ADD PLAYER");
		addPlayerButton.addActionListener(addPlayerAction);
		addPlayerButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		addPlayerButton.setAlignmentY(CENTER_ALIGNMENT);
		
		doneButton = new JButton("DONE");
		doneButton.addActionListener(doneAction);
		doneButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		doneButton.setAlignmentY(CENTER_ALIGNMENT);
		
		add(quitButton);
		add(addPlayerButton);
		add(doneButton);
	}
	
	
}
