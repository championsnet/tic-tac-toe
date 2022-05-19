package main.java.model;

import java.util.ArrayList;
import java.util.Random;

public class AI extends Player{
	
	private final String mode;
	
	public AI(String name, String mode) {
		super(name);
		this.mode = mode;
	}
	
	public AI(String name, String mode, int games, int wins, int loses, ArrayList<GameRecord> gameRecords) {
		super(name, games, wins, loses, gameRecords);
		this.mode = mode;
	}
	
	public String getMode() {
		return this.mode;
	}
	
	public int[] move(Board board, GameLogic logic) {
		int x = -1;
		int y = -1;
		int bestScore = -100;
		Random rand = new Random();
		if (this.mode.equals("random")) {
			do {
				x = rand.nextInt(3);
				y = rand.nextInt(3);
				if (board.getFilledPos() == 9) {
					break;
				}
			} while(!logic.isEmpty(x, y));
		}
		else {
			int [] perfect = perfectMove(board, logic);
			System.out.println(perfect[0] + ":" + perfect[1]);
			if (perfect[0] != -1) return perfect;
			do {
				int[][] score =new int[3][3];
				int own2 = 0;
				int own1 = 0;
				int opp2 = 0;
				int opp1 = 0;
				char[][] arr = logic.getTable();
				for (int i=0 ; i<3; i++) {
					for (int j=0 ; j<3; j++) {
						if (arr[i][j] == ' '){
							arr[i][j] = board.getCurrentPlayer();
							// Check for 2 and ' ' lines
							for (int k=0 ; k<3; k++) {
								if (arr[k][0] == arr[k][1] && arr[k][0] == board.getCurrentPlayer() && arr[k][2] == ' ') {
									own2++;
								}
								if (arr[k][0] == arr[k][2] && arr[k][0] == board.getCurrentPlayer() && arr[k][1] == ' ') {
									own2++;
								}
								if (arr[k][1] == arr[k][2] && arr[k][1] == board.getCurrentPlayer() && arr[k][0] == ' '){
									own2++;
								}
								if (arr[0][k] == arr[1][k] && arr[0][k] == board.getCurrentPlayer() && arr[2][k] == ' ') {
									own2++;
								}
								if (arr[0][k] == arr[2][k] && arr[0][k] == board.getCurrentPlayer() && arr[1][k] == ' ') {
									own2++;
								}
								if (arr[1][k] == arr[2][k] && arr[1][k] == board.getCurrentPlayer() && arr[0][k] == ' '){
									own2++;
								}
							}
							if (arr[0][0] == arr[1][1] && arr[0][0] == board.getCurrentPlayer() && arr[2][2] == ' ') {
								own2++;
							}
							if (arr[0][0] == arr[2][2] && arr[0][0] == board.getCurrentPlayer() && arr[1][1] == ' ') {
								own2++;
							}
							if (arr[1][1] == arr[2][2] && arr[1][1] == board.getCurrentPlayer() && arr[0][0] == ' ') {
								own2++;
							}
							if (arr[2][0] == arr[1][1] && arr[2][0] == board.getCurrentPlayer() && arr[0][2] == ' ') {
								own2++;
							}
							if (arr[2][0] == arr[0][2] && arr[2][0] == board.getCurrentPlayer() && arr[1][1] == ' ') {
								own2++;
							}
							if (arr[1][1] == arr[0][2] && arr[1][1] == board.getCurrentPlayer() && arr[2][0] == ' ') {
								own2++;
							}
							// Check for 1 and 2 ' ' lines
							for (int k=0 ; k<3; k++) {
								if (arr[k][0] == arr[k][1] && arr[k][0] == ' ' && arr[k][2] == board.getCurrentPlayer()) {
									own1++;
								}
								if (arr[k][0] == arr[k][2] && arr[k][0] == ' ' && arr[k][1] == board.getCurrentPlayer()) {
									own1++;
								}
								if (arr[k][1] == arr[k][2] && arr[k][1] == ' ' && arr[k][0] == board.getCurrentPlayer()){
									own1++;
								}
								if (arr[0][k] == arr[1][k] && arr[0][k] == ' ' && arr[2][k] == board.getCurrentPlayer()) {
									own1++;
								}
								if (arr[0][k] == arr[2][k] && arr[0][k] == ' ' && arr[1][k] == board.getCurrentPlayer()) {
									own1++;
								}
								if (arr[1][k] == arr[2][k] && arr[1][k] == ' ' && arr[0][k] == board.getCurrentPlayer()){
									own1++;
								}
							}
							if (arr[0][0] == arr[1][1] && arr[0][0] == ' ' && arr[2][2] == board.getCurrentPlayer()) {
								own1++;
							}
							if (arr[0][0] == arr[2][2] && arr[0][0] == ' ' && arr[1][1] == board.getCurrentPlayer()) {
								own1++;
							}
							if (arr[1][1] == arr[2][2] && arr[1][1] == ' ' && arr[0][0] == board.getCurrentPlayer()) {
								own1++;
							}
							if (arr[2][0] == arr[1][1] && arr[2][0] == ' ' && arr[0][2] == board.getCurrentPlayer()) {
								own1++;
							}
							if (arr[2][0] == arr[0][2] && arr[2][0] == ' ' && arr[1][1] == board.getCurrentPlayer()) {
								own1++;
							}
							if (arr[1][1] == arr[0][2] && arr[1][1] == ' ' && arr[2][0] == board.getCurrentPlayer()) {
								own1++;
							}
							board.setCurrentPlayer();
							// Check for 2 and ' ' lines
							for (int k=0 ; k<3; k++) {
								if (arr[k][0] == arr[k][1] && arr[k][0] == board.getCurrentPlayer() && arr[k][2] == ' ') {
									opp2++;
								}
								if (arr[k][0] == arr[k][2] && arr[k][0] == board.getCurrentPlayer() && arr[k][1] == ' ') {
									opp2++;
								}
								if (arr[k][1] == arr[k][2] && arr[k][1] == board.getCurrentPlayer() && arr[k][0] == ' '){
									opp2++;
								}
								if (arr[0][k] == arr[1][k] && arr[0][k] == board.getCurrentPlayer() && arr[2][k] == ' ') {
									opp2++;
								}
								if (arr[0][k] == arr[2][k] && arr[0][k] == board.getCurrentPlayer() && arr[1][k] == ' ') {
									opp2++;
								}
								if (arr[1][k] == arr[2][k] && arr[1][k] == board.getCurrentPlayer() && arr[0][k] == ' '){
									opp2++;
								}
							}
							if (arr[0][0] == arr[1][1] && arr[0][0] == board.getCurrentPlayer() && arr[2][2] == ' ') {
								opp2++;
							}
							if (arr[0][0] == arr[2][2] && arr[0][0] == board.getCurrentPlayer() && arr[1][1] == ' ') {
								opp2++;
							}
							if (arr[1][1] == arr[2][2] && arr[1][1] == board.getCurrentPlayer() && arr[0][0] == ' ') {
								opp2++;
							}
							if (arr[2][0] == arr[1][1] && arr[2][0] == board.getCurrentPlayer() && arr[0][2] == ' ') {
								opp2++;
							}
							if (arr[2][0] == arr[0][2] && arr[2][0] == board.getCurrentPlayer() && arr[1][1] == ' ') {
								opp2++;
							}
							if (arr[1][1] == arr[0][2] && arr[1][1] == board.getCurrentPlayer() && arr[2][0] == ' ') {
								opp2++;
							}
							// Check for 1 and 2 ' ' lines
							for (int k=0 ; k<3; k++) {
								if (arr[k][0] == arr[k][1] && arr[k][0] == ' ' && arr[k][2] == board.getCurrentPlayer()) {
									opp1++;
								}
								if (arr[k][0] == arr[k][2] && arr[k][0] == ' ' && arr[k][1] == board.getCurrentPlayer()) {
									opp1++;
								}
								if (arr[k][1] == arr[k][2] && arr[k][1] == ' ' && arr[k][0] == board.getCurrentPlayer()){
									opp1++;
								}
								if (arr[0][k] == arr[1][k] && arr[0][k] == ' ' && arr[2][k] == board.getCurrentPlayer()) {
									opp1++;
								}
								if (arr[0][k] == arr[2][k] && arr[0][k] == ' ' && arr[1][k] == board.getCurrentPlayer()) {
									opp1++;
								}
								if (arr[1][k] == arr[2][k] && arr[1][k] == ' ' && arr[0][k] == board.getCurrentPlayer()){
									opp1++;
								}
							}
							if (arr[0][0] == arr[1][1] && arr[0][0] == ' ' && arr[2][2] == board.getCurrentPlayer()) {
								opp1++;
							}
							if (arr[0][0] == arr[2][2] && arr[0][0] == ' ' && arr[1][1] == board.getCurrentPlayer()) {
								opp1++;
							}
							if (arr[1][1] == arr[2][2] && arr[1][1] == ' ' && arr[0][0] == board.getCurrentPlayer()) {
								opp1++;
							}
							if (arr[2][0] == arr[1][1] && arr[2][0] == ' ' && arr[0][2] == board.getCurrentPlayer()) {
								opp1++;
							}
							if (arr[2][0] == arr[0][2] && arr[2][0] == ' ' && arr[1][1] == board.getCurrentPlayer()) {
								opp1++;
							}
							if (arr[1][1] == arr[0][2] && arr[1][1] == ' ' && arr[2][0] == board.getCurrentPlayer()) {
								opp1++;
							}
							score[i][j] = 3 * own2 + own1 - (3 * opp2 + opp1);
							arr[i][j] = ' ';
							board.setCurrentPlayer();
						}
						else{
							score[i][j] = -50;
						}
					}
				}
				for (int i=0 ; i<3; i++) {
					for (int j=0 ; j<3; j++) {
						if (score[i][j] > bestScore) {
							bestScore = score[i][j];
							x = i;
							y = j;
						}
					}
				}
			} while(!logic.isEmpty(x, y));
		}
		return new int[]{x,y};

	}

	ArrayList<int[]> getThirdsInRow(char[][] state, char player) {
		ArrayList<int[]> thirds = new ArrayList<>();
		for (int k=0 ; k<3; k++) {
			
			if (state[k][0] == state[k][1] && state[k][0] == player && state[k][2] == ' ') {
				int[] move = {k,2};
				thirds.add(move);
			}
			if (state[k][0] == state[k][2] && state[k][0] == player && state[k][1] == ' ') {
				int[] move = {k,1};
				thirds.add(move);
			}
			if (state[k][1] == state[k][2] && state[k][1] == player && state[k][0] == ' '){
				int[] move = {k,0};
				thirds.add(move);
			}
			if (state[0][k] == state[1][k] && state[0][k] == player && state[2][k] == ' ') {
				int[] move = {2,k};
				thirds.add(move);
			}
			if (state[0][k] == state[2][k] && state[0][k] == player && state[1][k] == ' ') {
				int[] move = {1,k};
				thirds.add(move);
			}
			if (state[1][k] == state[2][k] && state[1][k] == player && state[0][k] == ' '){
				int[] move = {0,k};
				thirds.add(move);
			}
		}
		if (state[0][0] == state[1][1] && state[0][0] == player && state[2][2] == ' ') {
			int[] move = {2,2};
			thirds.add(move);
		}
		if (state[0][0] == state[2][2] && state[0][0] == player && state[1][1] == ' ') {
			int[] move = {1,1};
			thirds.add(move);
		}
		if (state[1][1] == state[2][2] && state[1][1] == player && state[0][0] == ' ') {
			int[] move = {0,0};
			thirds.add(move);
		}
		if (state[2][0] == state[1][1] && state[2][0] == player && state[0][2] == ' ') {
			int[] move = {0,2};
			thirds.add(move);
		}
		if (state[2][0] == state[0][2] && state[2][0] == player && state[1][1] == ' ') {
			int[] move = {1,1};
			thirds.add(move);
		}
		if (state[1][1] == state[0][2] && state[1][1] == player && state[2][0] == ' ') {
			int[] move = {2,0};
			thirds.add(move);
		}
		return thirds;
		
	}
	
	int[] perfectMove(Board board, GameLogic logic) {
		char player = board.getCurrentPlayer();
		char opponent = 'x';
		if (player == 'x') opponent = 'o';
		char[][] state = logic.getTable();
		int[] sample = {-1, -1};
		// Check if we have 2 in a row and return if so
		ArrayList<int[]> perfectMoves = getThirdsInRow(state, player);
		if (perfectMoves.size() != 0) {
			Random rand = new Random();
			System.out.println("WIN");
			return perfectMoves.get(rand.nextInt(perfectMoves.size()));
		}
		
		// Now check if opponent has 2 in a row and block them
		perfectMoves = getThirdsInRow(state, opponent);
		if (perfectMoves.size() != 0) {
			Random rand = new Random();
			System.out.println("2 IN A ROW BLOCK");
			return perfectMoves.get(rand.nextInt(perfectMoves.size()));
		}
		
		// Try create a winning opportunity with 2 ways
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (state[i][j] == ' ') {
					char[][] interstate = new char[3][3];
					for(int k = 0; k < 3; k++) interstate[k] = state[k].clone();
					interstate[i][j] = player;
					if (getThirdsInRow(interstate, player).size() >= 2) {
						int[] move = {i,j};
						perfectMoves.add(move);
					}	
				}
			}
		}
		if (perfectMoves.size() != 0) {
			Random rand = new Random();
			System.out.println("2 WAY OPPORTUNITY");
			return perfectMoves.get(rand.nextInt(perfectMoves.size()));
		}
		
		// Try create a winning opportunity with 1 way to force into defending
		// but without the opponent creating a 2 way winning opportunity
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (state[i][j] == ' ') {
					char[][] interstate = new char[3][3];
					for(int k = 0; k < 3; k++) interstate[k] = state[k].clone();
					interstate[i][j] = player;
					if (getThirdsInRow(interstate, player).size() >= 1) {
						boolean okMove = true;
						// Try deter a winning opportunity for opponent
						for (int m=0; m<3; m++) {
							for (int n=0; n<3; n++) {
								if (interstate[m][n] == ' ') {
									char[][] interinterstate = new char[3][3];
									for(int k = 0; k < 3; k++) interinterstate[k] = interstate[k].clone();
									interinterstate[m][n] = opponent;
									
									if (getThirdsInRow(interinterstate, opponent).size() - getThirdsInRow(interinterstate, player).size() >= 2) {	
										okMove = false;
										printBoard(interinterstate);
									}	
								}
							}
						}
						if (okMove) {
							int[] move = {i,j};
							perfectMoves.add(move);
						}
					}	
				}
			}
		}
		if (perfectMoves.size() != 0) {
			Random rand = new Random();
			System.out.println("1 WAY OPPORTUNITY ON TWO WAY BLOCK");
			return perfectMoves.get(rand.nextInt(perfectMoves.size()));
		}
		
		// If all previous is not covered, play at the center if empty
		if (state[1][1] == ' ') {
			sample[0] = 1;
			sample[1] = 1;
			System.out.println("AT CENTER");
			return sample;
		}
		
		// If all previous is not covered and opponent has covered a corner, play on the opposite
		if (state[0][0] == opponent && state[2][2] == ' ') {
			int[] move = {2,2};
			perfectMoves.add(move);
		}
		if (state[0][2] == opponent && state[2][0] == ' ') {
			int[] move = {2,0};
			perfectMoves.add(move);
		}
		if (state[2][0] == opponent && state[0][2] == ' ') {
			int[] move = {0,2};
			perfectMoves.add(move);
		}
		if (state[2][2] == opponent && state[0][0] == ' ') {
			int[] move = {0,0};
			perfectMoves.add(move);
		}
		if (perfectMoves.size() != 0) {
			Random rand = new Random();
			System.out.println("OPPOSITE CORNER");
			return perfectMoves.get(rand.nextInt(perfectMoves.size()));
		}
		
		// Then just play in an empty corner
		// If all previous is not covered and opponent has covered a corner, play on the opposite
		if (state[2][2] == ' ') {
			int[] move = {2,2};
			perfectMoves.add(move);
		}
		if (state[2][0] == ' ') {
			int[] move = {2,0};
			perfectMoves.add(move);
		}
		if (state[0][2] == ' ') {
			int[] move = {0,2};
			perfectMoves.add(move);
		}
		if (state[0][0] == ' ') {
			int[] move = {0,0};
			perfectMoves.add(move);
		}
		if (perfectMoves.size() != 0) {
			Random rand = new Random();
			System.out.println("JUST A CORNER");
			return perfectMoves.get(rand.nextInt(perfectMoves.size()));
		}
		
		// If everything fails just play whatever (side)
		if (state[0][1] == ' ') {
			int[] move = {0,1};
			perfectMoves.add(move);
		}
		if (state[1][0] == ' ') {
			int[] move = {1,0};
			perfectMoves.add(move);
		}
		if (state[1][2] == ' ') {
			int[] move = {1,2};
			perfectMoves.add(move);
		}
		if (state[2][1] == ' ') {
			int[] move = {2,1};
			perfectMoves.add(move);
		}
		if (perfectMoves.size() != 0) {
			Random rand = new Random();
			System.out.println("JUST A SIDE");
			return perfectMoves.get(rand.nextInt(perfectMoves.size()));
		}
		return sample;
		
		
		
	}
	
	void printBoard(char[][] state) {
		System.out.println(state[0][0] + "|" + state[0][1] + "|" + state[0][2]);
		System.out.println(state[1][0] + "|" + state[1][1] + "|" + state[1][2]);
		System.out.println(state[2][0] + "|" + state[2][1] + "|" + state[2][2]);
		System.out.println("-------");
	}
	
}
