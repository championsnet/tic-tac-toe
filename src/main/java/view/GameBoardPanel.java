package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//Suppress to enoxlitiko warning gia serialization
@SuppressWarnings("serial")

public class GameBoardPanel extends javax.swing.JPanel {

	private DefaultTableModel model;
	private Icon xIcon;
	private Icon oIcon;
	private final JLabel whoMovesLbl;
	
	private static final String FONT_NAME = "SansSerif";
	
	public GameBoardPanel() {
		
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		whoMovesLbl = new JLabel("<<<                                ");
		whoMovesLbl.setAlignmentX(CENTER_ALIGNMENT);
		whoMovesLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 24));
		
		add(whoMovesLbl);
		add(Box.createRigidArea(new Dimension(0, 50)));	
		
		// O pinakas pou prosomoiwnei to board
		Object[][] board = {{null, null, null}, {null, null, null}, {null, null, null}};
		model = new DefaultTableModel(board, board[0]);
		JTable table = new JTable(model) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
		};
		table.setSelectionBackground(new Color(0f,0f,0f,0f));
		table.setRowHeight(90);
		table.getColumnModel().getColumn(0).setWidth(90);
		table.getColumnModel().getColumn(1).setWidth(90);
		table.getColumnModel().getColumn(2).setWidth(90);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int x=0;x<3;x++){
			table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
	    }
		
		model = (DefaultTableModel) table.getModel();
		
		add(table);
		
		table.setAlignmentX(CENTER_ALIGNMENT);
		table.setMaximumSize(new Dimension(270, 270));
		
		String pathX = "./src/main/resources/x.png";
		String pathO = "./src/main/resources/o.png";
		xIcon = new ImageIcon(pathX);
		oIcon = new ImageIcon(pathO);
		
		
	}
	
	public void setCell(int x, int y, int player) {
		if (player == 1) model.setValueAt('X', x, y);
		else model.setValueAt('O', x, y);
	}
}
