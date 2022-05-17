package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import main.java.model.GameRecord;
import main.java.model.Player;

//Suppress to enoxlitiko warning gia serialization
@SuppressWarnings("serial")

public class PlayerPanel extends javax.swing.JPanel {

	private final JButton startButton;
	private final JButton selectPlayerButton;
	
	private final JLabel playerNameLbl;
	private final JLabel totalLbl;
	private final JLabel wonLbl;
	private final JLabel lostLbl;
	private final JLabel totalScoreLbl;
	private final JLabel recentScoreLbl;
	private final JLabel bestLbl;
	
	
	private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 30;
	private static final int IMAGE_WIDTH = 80;
    private static final int IMAGE_HEIGHT = 80;
    private static final String FONT_NAME = "SansSerif";
    
    
	// Side X: 1 - Side O: 2
	public PlayerPanel(int side) {
		
		// Set panel attributes
		setBackground(new Color(190, 175, 220));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		// Initialize ready button
		startButton = new JButton("READY");
		startButton.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		startButton.setAlignmentX(CENTER_ALIGNMENT);
		
		// At the beginning the button is disabled until a player is selected
		startButton.setEnabled(false);
		
		// Initialize select player button
		selectPlayerButton = new JButton("SELECT PLAYER");
		selectPlayerButton.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		selectPlayerButton.setAlignmentX(CENTER_ALIGNMENT);
		
		// Initialize player icon
		String path = "src\\main\\resources\\x.png";
		if (side == 2) path = "src\\main\\resources\\o.png";
		JLabel picLabel;
		// Exception an gia kapoio logo de mporei na fortwsei h eikona
		try {
			BufferedImage playerPic = ImageIO.read(new File(path));
			picLabel = new JLabel(new ImageIcon(playerPic));
		} catch (IOException e) {
			picLabel = new JLabel("Failed to load");
			e.printStackTrace();
		}
		picLabel.setAlignmentX(CENTER_ALIGNMENT);
		picLabel.setMaximumSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
		
		// Initialize player identity
		playerNameLbl = new JLabel("No player selected");
		playerNameLbl.setAlignmentX(CENTER_ALIGNMENT);
		playerNameLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 18));
		
		// Xrisimopoioume html giati einai o pio eukolos tropos na kounisoume se
		// left alignment ta stoixeia xwris na xalasei to BoxLayout pou einai xazo
		// ama apla orisw LEFT_ALIGNMENT to BoxLayout ta vazei sto kentro (dunno why)
		totalLbl = new JLabel("<html>Total: <b>-</b></html>");
		totalLbl.setAlignmentX(CENTER_ALIGNMENT);
		totalLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 14));
		
		wonLbl = new JLabel("<html>Won: <b>-%</b></html>");
		wonLbl.setAlignmentX(CENTER_ALIGNMENT);
		wonLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 14));
		
		lostLbl = new JLabel("<html>Lost: <b>-%</b></html>");
		lostLbl.setAlignmentX(CENTER_ALIGNMENT);
		lostLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 14));
		
		totalScoreLbl = new JLabel("<html>Total score: <b>-</b></html>");
		totalScoreLbl.setAlignmentX(CENTER_ALIGNMENT);
		totalScoreLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 14));
		
		recentScoreLbl = new JLabel("<html>Latest result: <b>-</b></html>");
		recentScoreLbl.setAlignmentX(CENTER_ALIGNMENT);
		recentScoreLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 14));
		
		// Xrisimopoioume html gia na kanoume kainouries grammes me to <br>
		bestLbl = new JLabel("<html><u>Best Games:</u><br>-<br>-<br>-<br>-<br>-</html>");
		bestLbl.setAlignmentX(CENTER_ALIGNMENT);
		bestLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 14));
		
		// Buttons
		add(startButton);
		add(Box.createRigidArea(new Dimension(0, 5))); //xrisimopoieitai gia dimiourgia xwrou anamesa apo ta elements
		add(selectPlayerButton);
		
		// Image
		add(Box.createRigidArea(new Dimension(0, 30)));		
		add(picLabel);
		
		// Player Identity
		add(Box.createRigidArea(new Dimension(0, 10)));	
		add(playerNameLbl);
		add(Box.createRigidArea(new Dimension(0, 30)));	
		add(totalLbl);
		add(wonLbl);
		add(lostLbl);
		add(Box.createRigidArea(new Dimension(0, 10)));	
		add(totalScoreLbl);
		add(recentScoreLbl);
		add(Box.createRigidArea(new Dimension(0, 10)));	
		add(bestLbl);
	}


	public JButton getStartButton() {
		return startButton;
	}


	public JButton getSelectPlayerButton() {
		return selectPlayerButton;
	}
	
	public void updateLabels(Player player) {
		
		playerNameLbl.setText(player.getName());
		int games = player.getGames();
		totalLbl.setText("<html>Total: <b>" + player.getGames() + "</b></html>");
		if (games == 0) games = 1; // Do evade division by 0 
		wonLbl.setText("<html>Won: <b>" + String.format("%.1f", (float)player.getWins()/(float)games * 100.0) + "%</b></html>");
		lostLbl.setText("<html>Lost: <b>" + String.format("%.1f", (float)player.getLoses()/(float)games * 100.0) + "%</b></html>");
		totalScoreLbl.setText("<html>Total score: <b>" + player.getScore() + "</b></html>");
		recentScoreLbl.setText("<html>Latest result: <b>" + player.getRecentScore() + "</b></html>");
		
		String[] best = player.getBestGamesString(5);
		String finalBest = "<html><u>Best Games:</u><br>";
		for (int i = 0; i<5; i++) finalBest += best[i] + "<br>";
		bestLbl.setText(finalBest);
	}
	
	public void setTotal(String text) {
		totalLbl.setText(text);
	}
	
	public void setWon(String text) {
		wonLbl.setText(text);
	}
	
	public void setLost(String text) {
		lostLbl.setText(text);
	}
	
	public void setTotalScore(String text) {
		totalScoreLbl.setText(text);
	}
	
	public void setRecentScore(String text) {
		recentScoreLbl.setText(text);
	}
	
	public void setBest(String text) {
		bestLbl.setText(text);
	}
	
	
}
