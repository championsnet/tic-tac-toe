package main.java.model;

public class GameLogic {
	
	private char[][] table = new char[3][3];
	
	
	public GameLogic(char[][] table) {
		super();
		this.table = table;
	}

	
	public char[][] getTable(){
		return this.table;
	}
	
	
	public void move(int x, int y, Board board) {
		if (board.getFilledPos() % 2 == 0) {
			this.table[x][y] = 'x';
			System.out.println("X on " + x + ":" + y);
		}
		else {
			this.table[x][y] = 'o';
			System.out.println("O on " + x + ":" + y);
		}
	};
	
	
	public boolean isEmpty(int x, int y) {
		if (this.table[x][y] == ' '){
			return true;
		}
		else {
			System.out.println("The cell is occupied!");
			return false;
		}
	}
	
	
	public boolean isFinished(Board board) {
	
		if (board.getFilledPos() + 1 < 5){
			return false;
		}
		
		// Ama exoume 3 seri mi kena cells tote to board einai teliko
		else {
			for (int i = 0 ; i <3 ; i++) {
				if ((this.table[i][0] == this.table[i][1]) && (this.table[i][0] == this.table[i][2]) && this.table[i][0] != ' '){
					board.setState(board.getCurrentPlayer());
					return true;
				}
				else if ((this.table[0][i] == this.table[1][i]) && (this.table[0][i] == this.table[2][i]) && this.table[0][i] != ' '){
					board.setState(board.getCurrentPlayer());
					return true;
				}
			}
			if ((this.table[0][0] == this.table[1][1]) && (this.table[0][0] == this.table[2][2]) && this.table[0][0] != ' '){
				board.setState(board.getCurrentPlayer());
				return true;
			}
			else if ((this.table[0][2] == this.table[1][1]) && (this.table[0][2] == this.table[2][0]) && this.table[0][2] != ' '){
				board.setState(board.getCurrentPlayer());
				return true;
			}
			else if (board.getFilledPos() + 1 == 9) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
}
