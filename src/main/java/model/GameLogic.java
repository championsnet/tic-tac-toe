package main.java.model;

public class GameLogic {
	
	private char[][] table = new char[3][3];
	
	
	public GameLogic(char[][] table) {
		super();
		this.table = table;
	}

	
	public char[][] get(){
		return this.table;
	}
	
	
	public void set(int x, int y, char player, Board board) {
		if (board.getFilledPos() % 2 == 0) {
			if (player == 'x') {
				this.table[x][y] = player;
			}
			else {
				System.out.println("It is player's 'x' turn");
			}
		}
		else {
			if (player == 'o') {
				this.table[x][y] = player;
			}
			else {
				System.out.println("It is player's 'o' turn");
			}
		}
	};
	
	
	public boolean isEmpty(int x, int y) {
		if (this.table[x][y] == ' '){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean isFinished(Board board) {
		if (board.getFilledPos() < 5){
			return false;
		}
		else {
			for (int i = 0 ; i <3 ; i++) {
				if ((this.table[i][0] == this.table[i][1]) && (this.table[i][0] == this.table[i][2])){
					return true;
				}
				else if ((this.table[0][i] == this.table[1][i]) && (this.table[0][i] == this.table[2][i])){
					return true;
				}
			}
			if ((this.table[0][0] == this.table[1][1]) && (this.table[0][0] == this.table[2][2])){
				return true;
			}
			else if ((this.table[0][2] == this.table[1][1]) && (this.table[0][2] == this.table[2][0])){
				return true;
			}
			else {
				return false;
			}
		}
	}
}
