package main.java.model;

import java.util.ArrayList;
import java.util.Random;

import main.java.view.MainWindow;

public class AI extends Player{
	
	private String mode;
	
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
	
	public int[] move(Board board, GameLogic logic, MainWindow view) {
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
			int[] arr = {x,y};
			return arr;
		}
		else {
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
			System.out.println(x + ":"+ y);
			int[] arr2 = {x,y};
			return arr2;
		}
		
	}

}
