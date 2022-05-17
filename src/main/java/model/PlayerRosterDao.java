package main.java.model;

import java.util.ArrayList;

public interface PlayerRosterDao {
	public ArrayList<Player> getAllPlayers();
	public String[] getAllPlayersString();
	public Player getPlayer(String name);
	public String addPlayer(String name);
	public boolean deletePlayer(String name);
	public Player[] getHallOfFame();
	public Player getSelectedPlayerX();
	public Player getSelectedPlayerO();
}
