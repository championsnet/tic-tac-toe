package main.java.model;

//Importing required classes
import java.util.HashMap;

final public class Board {
	// Monadikos ari8mos klassis
	private final int regNo;
	// Ari8mos mi kenwn thesewn
	private final int filledPos;
	private final char state;
	// autos pou paizei
	private final char currentPlayer;
	
	
	public Board(int regNo, int filledPos, char state, char currentPlayer) {
		super();
		this.regNo = regNo;
		this.filledPos = filledPos;
		this.state = state;
		this.currentPlayer = currentPlayer;
	}


	public int getRegNo() {
		return regNo;
	}


	public int getFilledPos() {
		return filledPos;
	}


	public char getState() {
		return state;
	}


	public char getCurrentPlayer() {
		return currentPlayer;
	}
	
	public char nextPlayer() {
		if (this.state == 'x'){
			return 'o';
		}
		else {
			return 'x';
		}
	}

}
