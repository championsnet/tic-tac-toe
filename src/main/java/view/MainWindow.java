package main.java.view;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    
    private final JPanel mainPanel; // 8a exei to hof kai to board to ena panw sto allo
	private final HallOfFamePanel hofPanel; // gia hall of fame
    private GameBoardPanel boardPanel; // gia kuriws paixnidi
	
	
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
		boardPanel.setVisible(false);
		
		hofPanel = new HallOfFamePanel();
		
		mainPanel = new JPanel();
		mainPanel.setBackground(hofPanel.getBackground());
		mainPanel.add(boardPanel, BorderLayout.LINE_START);
		mainPanel.add(hofPanel, BorderLayout.LINE_END);
		JLayeredPane lp = new JLayeredPane();
		mainPanel.add(lp, BorderLayout.CENTER);
		pane.add(mainPanel, BorderLayout.CENTER);
		
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
		hofPanel.setPreferredSize(new Dimension(WINDOW_WIDTH/2, 9*WINDOW_HEIGHT/10));
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
	
	public void visibleBoardPanel(boolean state) {
		boardPanel.setVisible(state);
		if (state) mainPanel.setBackground(boardPanel.getBackground());
	}
	
	public void visibleHofPanel(boolean state) {
		hofPanel.setVisible(state);
		if (state) mainPanel.setBackground(hofPanel.getBackground());
	}
	
	public void switchMainPanel() {
		boardPanel.setVisible(!boardPanel.isVisible());
		hofPanel.setVisible(!hofPanel.isVisible());
		if (boardPanel.isVisible()) mainPanel.setBackground(boardPanel.getBackground());
		else mainPanel.setBackground(hofPanel.getBackground());
	}
	
	public String selectPlayerDialog(String[] players, char side) {
		if (players.length == 0) return "Shouldn't be here";
		String getPlayer = (String) JOptionPane.showInputDialog(
                this,
                "Select player playing the " + side + "s",
                "Select Player " + side,
                JOptionPane.QUESTION_MESSAGE,
                null,
                players,
                players[0]);
		
		return getPlayer;
	}
	
	public String addPlayerDialog() {
		String newPlayer = (String) JOptionPane.showInputDialog(
                this,
                "Enter new player name:",
                "Add Player",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
		return newPlayer;
	}
	
	public void messageDialog(String message) {
		JOptionPane.showMessageDialog(
                this,
                message);
	}
}