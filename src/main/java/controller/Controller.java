package main.java.controller;

import main.java.model.Board;
import main.java.model.GameLogic;
import main.java.view.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class Controller {
	
	private GameLogic logic;
	private MainWindow view;
	private Board board;
	
	
	public Controller(GameLogic l, MainWindow v, Board b) {
		this.board = b;
		this.logic = l;
		this.view = v;
		JTable table = view.getBoardPanel().getTable();
		initController(table, board, logic, view);
	}


	public void initController(JTable table, Board board, GameLogic logic, MainWindow view) {
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JTable target = (JTable)e.getSource();
				int row = target.rowAtPoint(e.getPoint());
				int col = target.columnAtPoint(e.getPoint());
				
				// Check if cell is empty when you press
				if (logic.isEmpty(row, col)){
					// Fill array in logic
					logic.move(row, col, board);
					// Fill gui table
					view.getBoardPanel().setCell(row, col, board.getCurrentPlayer());
					// Check if someone won or if all positions are filled
					if (logic.isFinished(board)){
						System.out.println("Game finished");
						if (board.getState() == 'x' || board.getState() == 'o') {
							System.out.println("Player " + board.getState() + " won!");
						}
						else
							System.out.println("It is a tie...");
						// to be replaced
						System.exit(0);
					}
					// Increase filled positions
					board.setFilledPos(board.getFilledPos() + 1);
					// Change player
					board.setCurrentPlayer();
				}
			}
		});
		
	}
}
