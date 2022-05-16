package main.java.model;

//Importing required classes
import java.util.HashMap;

final public class Board {
	// Ari8mos mi kenwn thesewn
	private int filledPos;
	private char state;
	// autos pou paizei
	private char currentPlayer;
	
	
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
	
	public void setCurrentPlayer() {
		if (this.currentPlayer == 'x'){
			this.currentPlayer = 'o';
		}
		else {
			this.currentPlayer = 'x';
		}
	}
	
	public void setFilledPos(int pos) {
		this.filledPos = pos;
	}
	
	public void setState(char s) {
		this.state = s;
	}

}
