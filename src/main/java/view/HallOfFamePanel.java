package main.java.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

//Suppress to enoxlitiko warning gia serialization
@SuppressWarnings("serial")
public class HallOfFamePanel extends javax.swing.JPanel {
	
	private final JLabel titleLbl;
	private final JTable hallTable;
	private DefaultTableModel model;
	
	private static final String FONT_NAME = "SansSerif";
	
	public HallOfFamePanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		setBackground(new Color(255, 235, 130));
		
		titleLbl = new JLabel("Hall of Fame");
		titleLbl.setAlignmentX(CENTER_ALIGNMENT);
		titleLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 24));
		
		add(titleLbl);
		add(Box.createRigidArea(new Dimension(0, 20)));	
		
		// O pinakas pou prosomoiwnei to hall of fame
		String[][] hof = new String[10][3];
		for (int i = 0; i < 10; i++) {
			hof[i][0] = i + ".";
			hof[i][1] = "N/A";
			hof[i][2] = 0 + "";
		}
		String[] header = {null, null, null};
		
		// prepei na kanoume override ton renderer gia na emfanisoume eikones
		model = new DefaultTableModel(hof, header);
		
		// ftiaxnoume table kai apagoreyoume to edit
		hallTable = new JTable(model) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
			
			// We don't want borders now
			public Component prepareRenderer(
					TableCellRenderer renderer, int row, int column)
	        	{
	                Component c = super.prepareRenderer(renderer, row, column);
	                JComponent jc = (JComponent)c;

	                jc.setBorder(new MatteBorder(0, 0, 0, 0, Color.GRAY));
	                return c;
	            }
		};
		
		// Disable selection color
		hallTable.setSelectionBackground(new Color(0f,0f,0f,0f));
		hallTable.setRowHeight(30);
		hallTable.getColumnModel().getColumn(0).setWidth(30);
		hallTable.getColumnModel().getColumn(1).setWidth(300);
		hallTable.getColumnModel().getColumn(2).setWidth(20);
		hallTable.setShowGrid(false);
		hallTable.setIntercellSpacing(new Dimension(0, 10));
		hallTable.setBackground(getBackground());
		
		
		
		model = (DefaultTableModel) hallTable.getModel();
		
		add(hallTable);
		
		hallTable.setAlignmentX(CENTER_ALIGNMENT);
		//hallTable.setMaximumSize(new Dimension(360, 360));
	}

}
