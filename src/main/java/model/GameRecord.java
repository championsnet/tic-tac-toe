package main.java.model;


public class GameRecord {

	// Mporei na allaksei se object references pio meta
	private String playerX;
	private String playerO;
	private char result;
	private float scoreX;
	private float scoreO;
	private String timestamp;
	
	
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
	
	
}
