package main.java.view;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

// Suppress to enoxlitiko warning gia serialization
@SuppressWarnings("serial")

// H klasi ayti xeirizetai ola ta panel
public class MainWindow extends JFrame {

	private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 625;
    
    private final Container pane;
    private final BannerPanel bannerPanel;  // gia to banner
    private final PlayerPanel xPanel;  // gia player x
    private final PlayerPanel oPanel;  // gia o
    

	private final HallOfFamePanel hofPanel; // gia hall of fame
    private final GameBoardPanel boardPanel; // gia kuriws paixnidi
	
	
	public MainWindow() {

		setTitle("Tuc Tac Toe");
		pane = getContentPane();
		
		bannerPanel = new BannerPanel();
		pane.add(bannerPanel, BorderLayout.PAGE_START); // gia na mpei panw
		
		xPanel = new PlayerPanel(1);
		pane.add(xPanel, BorderLayout.LINE_START);
		
		oPanel = new PlayerPanel(2);
		pane.add(oPanel, BorderLayout.LINE_END);
		
		boardPanel = new GameBoardPanel();
		//pane.add(boardPanel, BorderLayout.CENTER);
		boardPanel.setVisible(false);
		
		hofPanel = new HallOfFamePanel();
		pane.add(hofPanel, BorderLayout.CENTER);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        
        this.setSizes();
        setVisible(true);
        
	
	}
	
	private void setSizes() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setMaximumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		bannerPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT/10));
		xPanel.setPreferredSize(new Dimension(WINDOW_WIDTH/4, 9*WINDOW_HEIGHT/10));
		oPanel.setPreferredSize(new Dimension(WINDOW_WIDTH/4, 9*WINDOW_HEIGHT/10));
		boardPanel.setPreferredSize(new Dimension(WINDOW_WIDTH/2, 9*WINDOW_HEIGHT/10));
	}
	
	
	public BannerPanel getBannerPanel() {
		return bannerPanel;
	}

	public PlayerPanel getxPanel() {
		return xPanel;
	}

	public PlayerPanel getoPanel() {
		return oPanel;
	}

	public GameBoardPanel getBoardPanel() {
		return boardPanel;
	}
	
	public HallOfFamePanel getHofPanel() {
		return hofPanel;
	}
}