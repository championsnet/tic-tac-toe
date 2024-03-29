package main.java.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import main.java.model.Player;

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
		titleLbl.setFont(new Font(FONT_NAME, Font.BOLD, 26));
		
		add(titleLbl);
		add(Box.createRigidArea(new Dimension(0, 20)));	
		
		// O pinakas pou prosomoiwnei to hall of fame
		String[][] hof = new String[10][3];
		for (int i = 0; i < 10; i++) {
			hof[i][0] = (i+1) + ".";
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
			public Component prepareRenderer(
			        TableCellRenderer renderer, int row, int column)
			{
				Component c = super.prepareRenderer(renderer, row, column);

			    if (row == 0) c.setFont(new Font(FONT_NAME, Font.BOLD, 22));
			    if (row == 1) c.setFont(new Font(FONT_NAME, Font.BOLD, 18));
			    if (row == 2) c.setFont(new Font(FONT_NAME, Font.BOLD, 16));
			    if (row > 2) c.setFont(new Font(FONT_NAME, Font.PLAIN, 16));

			    return c;
			}
		};
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int x=0;x<3;x++){
			hallTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
	    }
		
		// Disable selection color
		hallTable.setSelectionBackground(new Color(0f,0f,0f,0f));
		hallTable.setRowHeight(40);
		hallTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		hallTable.getColumnModel().getColumn(1).setPreferredWidth(290);
		hallTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		hallTable.setShowGrid(false);
		hallTable.setIntercellSpacing(new Dimension(0, 10));
		hallTable.setBackground(getBackground());
		hallTable.setFont(new Font(FONT_NAME, Font.PLAIN, 16));
		
		
		
		model = (DefaultTableModel) hallTable.getModel();
		
		add(hallTable);
		
		hallTable.setAlignmentX(CENTER_ALIGNMENT);
		hallTable.setMaximumSize(new Dimension(370, 400));
	
	}
	
	public void setPlayer(int position, String player, float score) {
		model.setValueAt(player, position, 1);
		model.setValueAt(score, position, 2);
	}
	
	public void setHofVisible(boolean state) {
		setVisible(state);
	}
	
	public void setHof(Player[] list) {
		int i = 0;
		for (Player player : list) {
			if (player == null) return;
			setPlayer(i, player.getName(), player.getScore());
			i++;
		}
	}

}
