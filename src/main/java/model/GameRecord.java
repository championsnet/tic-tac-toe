package main.java.model;

public class GameRecord {

	// Mporei na allaksei se object references pio meta
	private String playerX;
	private String playerO;
	private char result;
	private float scoreX;
	private float scoreO;
	private float duration;
	
	
	// Mia fora orizontai ta dedomena kathe record opote de xreiazontai setters
	public GameRecord(String playerX, String playerO, char result, float scoreX, float scoreO, float duration) {
		super();
		this.playerX = playerX;
		this.playerO = playerO;
		this.result = result;
		this.scoreX = scoreX;
		this.scoreO = scoreO;
		this.duration = duration;
	}
	
	
	public String getPlayerX() {
		return playerX;
	}


	public String getPlayerO() {
		return playerO;
	}


	public char getResult() {
		return result;
	}


	public float getScoreX() {
		return scoreX;
	}


	public float getScoreO() {
		return scoreO;
	}


	public float getDuration() {
		return duration;
	}
	
	
}
