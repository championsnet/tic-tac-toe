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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

//Suppress to enoxlitiko warning gia serialization
@SuppressWarnings("serial")

public class GameBoardPanel extends javax.swing.JPanel {

	private DefaultTableModel model;
	private Icon xIcon;
	private Icon oIcon;
	private final JLabel messageLbl;
	private JTable table;
	
	private static final String FONT_NAME = "SansSerif";
	
	public GameBoardPanel() {
		
		String pathX = "src\\main\\resources\\x.png";
		String pathO = "src\\main\\resources\\o.png";
		// Exception an gia kapoio logo de mporei na fortwsei h eikona
		try {
			BufferedImage xPic = ImageIO.read(new File(pathX));
			xIcon = new ImageIcon(xPic);
			BufferedImage oPic = ImageIO.read(new File(pathO));
			oIcon = new ImageIcon(oPic);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		messageLbl = new JLabel("<<<                                ");
		messageLbl.setAlignmentX(CENTER_ALIGNMENT);
		messageLbl.setFont(new Font(FONT_NAME, Font.PLAIN, 24));
		
		add(messageLbl);
		add(Box.createRigidArea(new Dimension(0, 50)));	
		
		// O pinakas pou prosomoiwnei to board arxika kenos
		Object[][] board = {{null, null, null}, {null, null, null}, {null, null, null}};
		
		// prepei na kanoume override ton renderer gia na emfanisoume eikones
		model = new DefaultTableModel(board, board[0]) {
			@Override
		    public Class<?> getColumnClass(int column) {
		        return Icon.class;
		    }
		};
		
		// ftiaxnoume table kai apagoreyoume to edit
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
			
			// episis ftiaxnoume ta borders gia na moiazoun me triliza
			// poliiii leptomeria ayto
			public Component prepareRenderer(
					TableCellRenderer renderer, int row, int column)
	        	{
	                Component c = super.prepareRenderer(renderer, row, column);
	                JComponent jc = (JComponent)c;

	                //  Color row based on a cell value
	                //  Alternate row color

	                int top = 3;
                	int bottom = 3;
                	int left = 3;
                	int right = 3;
                	if (row == 0) top = 0;
                	if (row == 2) bottom = 0;
                	if (column == 0) left = 0;
                	if (column == 2) right = 0;
                	jc.setBorder(new MatteBorder(top, left, bottom, right, Color.GRAY));
	                return c;
	            }
		};
		
		// Disable selection color
		table.setSelectionBackground(new Color(0f,0f,0f,0f));
		table.setRowHeight(120);
		table.getColumnModel().getColumn(0).setWidth(120);
		table.getColumnModel().getColumn(1).setWidth(120);
		table.getColumnModel().getColumn(2).setWidth(120);
		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setBackground(getBackground());
		
		
		
		model = (DefaultTableModel) table.getModel();
		
		add(table);
		
		table.setAlignmentX(CENTER_ALIGNMENT);
		table.setMaximumSize(new Dimension(360, 360));
		
		
		
		
	}
	
	public void setMessage(String message) {
		messageLbl.setText(message);
	}

	public JTable getTable() {
		return table;
	}

	public void setCell(int x, int y, char player) {
		if (player == 'x') model.setValueAt(xIcon, x, y);
		else if (player == 'o') model.setValueAt(oIcon, x, y);
	}
	
	public void setBoardVisible(boolean state) {
		setVisible(state);
	}
	
}
