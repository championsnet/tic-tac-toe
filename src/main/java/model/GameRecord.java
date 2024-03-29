package main.java.model;


public class GameRecord {

	// Mporei na allaksei se object references pio meta
	private final String playerX;
	private final String playerO;
	private final char result;
	private final float scoreX;
	private final float scoreO;
	private final String timestamp;
	
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
		
		// Texnito score ka8e partidas gia na sygkrinoume paixnidia
		// Paizoume me takseis mege8ous wste na sevomaste ta vimata
		// sygkrisis stis odigies ths ekfwnishs
		if (result == 'X') {
			this.relativeScoreX = 100000;
			this.relativeScoreO = 1000;
		}
		else if (result == 'T') {
			this.relativeScoreX = 10000;
			this.relativeScoreO = 10000;
		}
		else {
			this.relativeScoreX = 1000;
			this.relativeScoreO = 100000;
		}
		
		// Oso pio psilo to score antipalou toso pio kalo to relative score
		this.relativeScoreX += scoreO;
		this.relativeScoreO += scoreX;
		
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

	public int getRelativeScore(String name) {
		if (name.equals(playerX)) return relativeScoreX;
		else return relativeScoreO;
	}
	
	
}
