package main.java.model;


public class GameRecord {

	// Mporei na allaksei se object references pio meta
	private String playerX;
	private String playerO;
	private char result;
	private float scoreX;
	private float scoreO;
	private String timestamp;
	
	// Gia na krinoume to poso kalo einai to paixnidi
	private int relativeScoreX;
	private int relativeScoreO;
	
	
	// Mia fora orizontai ta dedomena kathe record opote de xreiazontai setters
	public GameRecord(String playerX, String playerO, char result, float scoreX, float scoreO, String timestamp) {
		super();
		this.playerX = playerX;
		this.playerO = playerO;
		this.result = result;
		this.scoreX = scoreX;
		this.scoreO = scoreO;
		
		// Metatropi string se localdatetime
		this.timestamp = timestamp;
		
		if (result == 'X') {
			this.relativeScoreX = 10000;
			this.relativeScoreO = 100;
		}
		else if (result == 'T') {
			this.relativeScoreX = 1000;
			this.relativeScoreO = 1000;
		}
		else {
			this.relativeScoreX = 100;
			this.relativeScoreO = 10000;
		}
		if (scoreX >= scoreO) {
			this.relativeScoreX += 10;
		}
		else {
			this.relativeScoreO += 10;
		}
		
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


	public String getTimestamp() {
		return timestamp;
	}
	
	public int getRelativeScoreX() {
		return relativeScoreX;
	}
	
	public int getRelativeScoreO() {
		return relativeScoreO;
	}
	
	public int getRelativeScore(String name) {
		if (name == playerX) return relativeScoreX;
		else return relativeScoreO;
	}
	
	
}
