package main.java.model;

//Importing required classes
import java.util.HashMap;

final public class Board {
	// Ari8mos mi kenwn thesewn
	private final int filledPos;
	private char state;
	// autos pou paizei
	private final char currentPlayer;
	
	
	public Board(int filledPos, char state, char currentPlayer) {
		super();
		this.filledPos = filledPos;
		this.state = state;
		this.currentPlayer = currentPlayer;
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
	
	
	public void setState(char s) {
		this.state = s;
	}

}
