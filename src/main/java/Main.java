package main.java;

import main.java.model.*;
import main.java.view.*;
import main.java.controller.*;

public class Main {

	public static void main(String[] args) {
		// Initialize player roster
		PlayerRoster roster = new PlayerRoster();
		// Initialize logic object
		char[][] initTable = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
		GameLogic logic = new GameLogic(initTable);
		// Initialize view object
		MainWindow view = new MainWindow();
		// Initialize board object
		Board board = new Board(0,'T','x');
		// Initialize Controller object
		Controller c = new Controller(roster, logic, view, board);
		c.runPlayerVsPlayer(c.getTable(), board, logic, view, c.getReadyX(), 
							c.getReadyO(), c.getDoneBtn(), c.getQuit());
	}

}
