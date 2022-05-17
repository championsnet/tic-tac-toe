package main.java.controller;

import main.java.model.Board;
import main.java.model.GameLogic;
import main.java.view.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;

public class Controller {
	
	private GameLogic logic;
	private MainWindow view;
	private Board board;
	private JTable table;
	private JButton ready_x;
	private JButton ready_o;
	private JButton doneBtn;
	private JButton quit;
	
	
	public Controller(GameLogic l, MainWindow v, Board b) {
		this.board = b;
		this.logic = l;
		this.view = v;
		this.table = view.getBoardPanel().getTable();
		this.ready_x = view.getxPanel().getStartButton();
		this.ready_o = view.getoPanel().getStartButton();
		this.doneBtn = view.getBannerPanel().getDoneButton();
		this.quit = view.getBannerPanel().getQuitButton();
	}
	
	public JTable getTable() {
		return this.table;
	}
	
	public JButton getReadyX() {
		return this.ready_x;
	}
	
	public JButton getReadyO() {
		return this.ready_o;
	}
	
	public JButton getDoneBtn() {
		return this.doneBtn;
	}
	
	public JButton getQuit() {
		return this.quit;
	}

	public void runPlayerVsPlayer(JTable table, Board board, GameLogic logic, MainWindow view, JButton ready_x, JButton ready_o, JButton doneBtn, JButton quit) {
		ArrayList<Board> boards = new ArrayList<Board>();
		boards.add(board);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JTable target = (JTable)e.getSource();
				int row = target.rowAtPoint(e.getPoint());
				int col = target.columnAtPoint(e.getPoint());
				
				
				if (logic.isDone()){
					logic.resetTable();
					board.setFilledPos(0);
					board.setState('T');
					logic.setDone();
					if (board.getCurrentPlayer() == 'o') {
						board.setCurrentPlayer();
					}
				}
				
				// Check if both players pressed ready
				if (logic.isStarting()) {
					// Check if cell is empty when you press
					if (logic.isEmpty(row, col)){
						// Fill array in logic
						logic.move(row, col, board);
						// Increase filled positions
						board.setFilledPos(board.getFilledPos() + 1);
						// Change player
						board.setCurrentPlayer();
						// Fill gui table
						view.getBoardPanel().setCell(row, col, board.getCurrentPlayer());
						// Check if someone won or if all positions are filled
						if (logic.isFinished(board)){
							consoleMessage("Game finished");
							if (board.getState() == 'x' || board.getState() == 'o') {
								consoleMessage("Player " + board.getState() + " won!");
								logic.setStartO();
								logic.setStartX();
							}
							else if (board.getState() == 'T') {
								consoleMessage("It is a tie...");
								logic.setStartO();
								logic.setStartX();
							}
						}
						Board newBoard = new Board(board.getFilledPos() + 1, board.getState(), board.getCurrentPlayer());
						boards.add(newBoard);
					}
				}
				
			}
		});
		
		ready_x.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				consoleMessage("Player x ready...");
				logic.setStartX();
				if (logic.isStarting()){
					view.getBoardPanel().setVisible(true);
					view.getHofPanel().setVisible(false);
				}
			}
		});
		
		ready_o.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				consoleMessage("Player o ready...");
				logic.setStartO();
				if (logic.isStarting()){
					view.getBoardPanel().setVisible(true);
					view.getHofPanel().setVisible(false);
				}
			}
		});
		
		
		doneBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (logic.isFinished(board)) {
					view.getBoardPanel().resetBoard();
					view.getBoardPanel().setVisible(false);
					view.getHofPanel().setVisible(true);
					logic.setDone();
				}
			}
		});
		
		quit.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void consoleMessage(String message) {
		System.out.println(message);
	}
}
