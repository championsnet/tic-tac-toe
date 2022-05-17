package main.java.controller;

import main.java.model.Board;
import main.java.model.GameLogic;
import main.java.model.Player;
import main.java.model.PlayerRoster;
import main.java.view.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;

public class Controller {
	
	private PlayerRoster roster;
	private GameLogic logic;
	private MainWindow view;
	private Board board;
	private JTable table;
	private JButton ready_x;
	private JButton ready_o;
	private JButton doneBtn;
	private JButton quit;
	private JButton addPlayerBtn;
	private JButton selectPlayerXBtn;
	private JButton selectPlayerOBtn;
	
//	if (roster.getSelectedPlayerX().getMode() != null ){
//		AI ai = (AI) roster.getSelectedPlayerX();
//		int[] arr = ai.move(board, logic);
//		row = arr[0];
//		col = arr[1];
	
	
	public Controller(PlayerRoster r, GameLogic l, MainWindow v, Board b) {
		this.roster = r;
		this.board = b;
		this.logic = l;
		this.view = v;
		this.table = view.getBoardPanel().getTable();
		this.ready_x = view.getxPanel().getStartButton();
		this.ready_o = view.getoPanel().getStartButton();
		this.doneBtn = view.getBannerPanel().getDoneButton();
		this.quit = view.getBannerPanel().getQuitButton();
		this.addPlayerBtn = view.getBannerPanel().getAddPlayerButton();
		this.selectPlayerXBtn = view.getxPanel().getSelectPlayerButton();
		this.selectPlayerOBtn = view.getoPanel().getSelectPlayerButton();
		
		view.getHofPanel().setHof(roster.getHallOfFame());
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
						
						// Update who plays on message label
						if (board.getCurrentPlayer() == 'o') view.getBoardPanel().setMessage("<<<   X");
						else view.getBoardPanel().setMessage("O   >>>");
						
						// Fill gui table
						view.getBoardPanel().setCell(row, col, board.getCurrentPlayer());
						// Check if someone won or if all positions are filled
						if (logic.isFinished(board)){
							doneBtn.setEnabled(true);
							consoleMessage("Game finished");
							char result = 'T';
							if (board.getState() == 'x' || board.getState() == 'o') {
								consoleMessage("Player " + board.getState() + " won!");
								
								logic.setStartO();
								logic.setStartX();
								
								// Kefalaia exoume ti simvasi gia save kai load
								result = Character.toUpperCase(board.getState());
								
								view.getBoardPanel().setMessage("Player " + result + " won!");
							}
							else if (board.getState() == 'T') {
								consoleMessage("It is a tie...");
								view.getBoardPanel().setMessage("It is a tie! (-_-)");
								logic.setStartO();
								logic.setStartX();
								result = board.getState();
							}
							roster.createRecords(result);
							
							// Update player panels with new data and also hall of fame
							view.getxPanel().updateLabels(roster.getSelectedPlayerX());
							view.getoPanel().updateLabels(roster.getSelectedPlayerO());
							view.getHofPanel().setHof(roster.getHallOfFame());
						}
						// Change player
						board.setCurrentPlayer();
						Board newBoard = new Board(board.getFilledPos() + 1, board.getState(), board.getCurrentPlayer());
						boards.add(newBoard);
					}
				}
				
			}
		});
		
		ready_x.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!ready_x.isEnabled()) return;
				consoleMessage("Player x ready...");
				logic.setStartX();
				if (logic.isStarting()){
					view.visibleBoardPanel(true);
					view.visibleHofPanel(false);
					ready_x.setEnabled(false);
					ready_o.setEnabled(false);
					selectPlayerXBtn.setEnabled(false);
					selectPlayerOBtn.setEnabled(false);
				}
			}
		});
		
		ready_o.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!ready_o.isEnabled()) return;
				consoleMessage("Player o ready...");
				logic.setStartO();
				if (logic.isStarting()){
					view.visibleBoardPanel(true);
					view.visibleHofPanel(false);
					ready_x.setEnabled(false);
					ready_o.setEnabled(false);
					selectPlayerXBtn.setEnabled(false);
					selectPlayerOBtn.setEnabled(false);
				}
			}
		});
		
		
		doneBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!doneBtn.isEnabled()) return;
				if (logic.isFinished(board)) {
					view.getBoardPanel().resetBoard();
					view.visibleBoardPanel(false);
					view.visibleHofPanel(true);
					logic.setDone();
					ready_x.setEnabled(true);
					ready_o.setEnabled(true);
					selectPlayerXBtn.setEnabled(true);
					selectPlayerOBtn.setEnabled(true);
					doneBtn.setEnabled(false);
					view.getBoardPanel().setMessage("<<<   X");
				}
			}
		});
		
		quit.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		
		addPlayerBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String newPlayer = view.addPlayerDialog();
				if (newPlayer != null) {
					view.messageDialog(roster.addPlayer(newPlayer));
					view.getHofPanel().setHof(roster.getHallOfFame());
				}
			}
		});
		
		selectPlayerXBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!selectPlayerXBtn.isEnabled()) return;
				String selection = view.selectPlayerDialog(roster.getAllPlayersString(), 'X');
				if (selection == null) return;
				Player selected = roster.getPlayer(selection);
				String result = roster.setSelectedPlayerX(selected);
				if (result != null) view.messageDialog(result);
				else {
					view.getxPanel().updateLabels(selected);
					ready_x.setEnabled(true);
				}
				// TODO Do sth with the selected player
			}
		});
		
		selectPlayerOBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!selectPlayerOBtn.isEnabled()) return;
				String selection = view.selectPlayerDialog(roster.getAllPlayersString(), 'O');
				if (selection == null) return;
				Player selected = roster.getPlayer(selection);
				String result = roster.setSelectedPlayerO(selected);
				if (result != null) view.messageDialog(result);
				else {
					view.getoPanel().updateLabels(selected);
					ready_o.setEnabled(true);
				}
				//view.getoPanel().setPlayerName(selection);
				// TODO Do sth with the selected player
			}
		});
	}
	
	public void consoleMessage(String message) {
		System.out.println(message);
	}
}
