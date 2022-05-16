package main.java.model;

import java.util.ArrayList;

public class Player {

	private String name;
	private int games;
	private int wins;
	private int loses;
	private float score;
	private ArrayList<GameRecord> recentGames;
	private ArrayList<GameRecord> bestGames;
	
	
	public Player(String name) {
		super();
		this.name = name;
		this.games = 0;
		this.wins = 0;
		this.loses = 0;
		this.recentGames = new ArrayList<GameRecord>();
		this.bestGames = new ArrayList<GameRecord>();
		this.score = 0;
	}
	
	
	public Player(String name, int games, int wins, int loses, ArrayList<GameRecord> recentGames,
			ArrayList<GameRecord> bestGames) {
		super();
		this.name = name;
		this.games = games;
		this.wins = wins;
		this.loses = loses;
		this.recentGames = recentGames;
		this.bestGames = bestGames;
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

	
	public ArrayList<GameRecord> getRecentGames() {
		return recentGames;
	}

	
	public ArrayList<GameRecord> getBestGames() {
		return bestGames;
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
	public void setScore() {
		this.score = 50 * (2 * getWins() + (getGames() - getWins() - getLoses())) / getGames();
	}


	public void setRecentGames(ArrayList<GameRecord> recentGames) {
		this.recentGames = recentGames;
	}


	public void setBestGames(ArrayList<GameRecord> bestGames) {
		this.bestGames = bestGames;
	}
	
	
	
	
}
