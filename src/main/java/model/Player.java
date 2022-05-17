package main.java.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Player {

	private String name;
	private int games;
	private int wins;
	private int loses;
	private float score;
	private ArrayList<GameRecord> gameRecords;
	
	
	public Player(String name) {
		super();
		this.name = name;
		this.games = 0;
		this.wins = 0;
		this.loses = 0;
		this.gameRecords = new ArrayList<GameRecord>();
		this.score = 0;
	}
	
	
	public Player(String name, int games, int wins, int loses, ArrayList<GameRecord> gameRecords) {
		super();
		this.name = name;
		this.games = games;
		this.wins = wins;
		this.loses = loses;
		this.gameRecords = gameRecords;
	}


	public String getName() {
		return name;
	}

	
	public int getGames() {
		return games;
	}

	
	public int getWins() {
		return wins;
	}

	
	public int getLoses() {
		return loses;
	}
	
	public float getScore() {
		return score;
	}
	
	
	public float getRecentScore() {
		GameRecord last = getGameRecords().get(getGameRecords().size()-1);
		if (last.getPlayerX() == getName()) return last.getScoreX();
		else return last.getScoreO();
	}
	
	
	public void addGameRecord(GameRecord record) {
		getGameRecords().add(record);
	}
	
	
	public ArrayList<GameRecord> getGameRecords() {
		return gameRecords;
	}

	// Return last i records from newest to oldest.
	// The way records are saved the oldest ones are first
	public ArrayList<GameRecord> getRecentGames(int number) {
		ArrayList<GameRecord> recentGames = new ArrayList<GameRecord>();
		for (int i=0; i<Integer.min(number, getGameRecords().size()); i++) {
			recentGames.add(getGameRecords().get(getGameRecords().size() - i - 1));
		}
		return recentGames;
	}

	// Get n best games by utilizing a new array with respective indices
	// and sorting and then returning according to the sorted indices
	// Complexity is still nlogn but uses more memory alla siga
	public ArrayList<GameRecord> getBestGames(int games) {
		ArrayList<GameRecord> bestGames = new ArrayList<GameRecord>();
		
		// All relative scores and their respective indices
		int[][] relativeScores = new int[gameRecords.size()][2];
		int i = 0;
		for (GameRecord record : gameRecords) { 		      
			relativeScores[i][0] = record.getRelativeScore(getName());
			relativeScores[i][1] = i;
			i++;
	    }
		Arrays.sort(relativeScores, Comparator.comparingDouble(o -> o[0]));
		for (i = 0; i < games; i++) bestGames.add(gameRecords.get(relativeScores[games-i-1][1]));
		System.out.println();
		return bestGames;
	}
	
	// Get best games as string in form 'W vs xyz'
	public String[] getBestGamesString(int games) {
		ArrayList<GameRecord> bestGames = getBestGames(games);
		String[] best = new String[games];
		for (int i = 0; i < bestGames.size(); i ++) {
			char result = bestGames.get(i).getResult();
			
			// Determine what side was the player playing
			if (this.name == bestGames.get(i).getPlayerX()) {
				if (result == 'X') result = 'W';
				else if (result == 'O') result = 'L';
				// If 'T' then no need to change anything
				best[i] = result + " vs " + bestGames.get(i).getPlayerO();
			}
			else {
				if (result == 'X') result = 'L';
				else if (result == 'O') result = 'W';
				// If 'T' then no need to change anything
				best[i] = result + " vs " + bestGames.get(i).getPlayerX();
			}			
		}
		// If there are not enough games, then the rest positions are returned as '-'
		for (int i = 5; i > bestGames.size(); i--) best[i] = "-";
		
		return best;
	}
	
	public void setGames(int games) {
		this.games = games;
	}


	public void setWins(int wins) {
		this.wins = wins;
	}


	public void setLoses(int loses) {
		this.loses = loses;
	}
	
	// Score is set automatically based on wins, ties, loses
	// Ties = Games - Wins - Loses
	public void setScore() {
		if (getGames() == 0) this.score = 0;
		this.score = 50 * (2 * getWins() + (getGames() - getWins() - getLoses())) / getGames();
	}
	
	// Have a choice to set score manually (Mostly for testing purposes)
	public void setScore(float score) {
		this.score = score;
	}


	public void setGameRecords(ArrayList<GameRecord> gameRecords) {
		this.gameRecords = gameRecords;
	}
	
	
	
	
}
