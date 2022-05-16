package main.java.model;

import java.util.ArrayList;

public interface PlayerRosterDao {
	public ArrayList<Player> getAllPlayers();
	public Player getPlayer(String name);
	public boolean addPlayer(String name);
	public boolean deletePlayer(String name);
	public Player[] getHallOfFame();
}
