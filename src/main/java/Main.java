package main.java;

import main.java.model.*;
import main.java.view.*;

public class Main {

	public static void main(String[] args) {
		PlayerRoster a = new PlayerRoster();
		Player b = new Player("Harry");
		a.addPlayer(b);
		
		MainWindow window = new MainWindow();
		
		char[][] initTable = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
		
		GameLogic logic = new GameLogic(initTable);
		
		Board board = new Board(0, 'T', 'x');
		int x = 0, y = 0; 
		if (logic.isEmpty(x, y)) logic.move(x, y, board);
		
		if (logic.isFinished(board)) {
			System.out.println(board.getState() + " is the winner!");
		}
		
		window.getBoardPanel().setCell(0, 0, 1);
		window.getBoardPanel().setCell(1, 0, 0);
		window.getBoardPanel().setCell(1, 1, 1);
		
		
		
		
		
		
//		x = 1;
//		y = 1; 
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}
//		
//		x = 1;
//		y = 0; 
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}
//		
//		x = 1;
//		y = 2; 
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}
//		
//		x = 2;
//		y = 0; 
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}
//		
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}
//		
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}
//		
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}
//		
//		board = new Board(board.getFilledPos()+1, board.getState(), board.nextPlayer());
//		if (logic.isEmpty(x, y)) logic.move(x, y, board);
//		
//		if (logic.isFinished(board)) {
//			System.out.println(board.getState() + " is the winner!");
//		}

	}

}
