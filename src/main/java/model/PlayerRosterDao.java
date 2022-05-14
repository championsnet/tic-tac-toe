package main.java.model;

import java.util.ArrayList;

public interface PlayerRosterDao {
	public ArrayList<Player> getAllPlayers();
	public Player getPlayer(String name);
	public void addPlayer(Player student);
	public void deletePlayer(Player student);
}
