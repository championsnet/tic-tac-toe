package main.java.model;

import java.util.ArrayList;

public class PlayerRoster implements PlayerRosterDao{
	
	ArrayList<Player> players;

	public PlayerRoster(){
		players = new ArrayList<Player>();
		// edw 8a fortonoume apo arxeio
	}
	   
	   
	@Override
	public boolean deletePlayer(String name) {
		if (getPlayer(name) == null) {
			System.out.println("Player with name: " + name + " does not exist");
			return false;
		}
		players.remove(getPlayer(name));
		System.out.println("Player: " + name + ", deleted from database");
		return true;
	}

	//retrive list of players from the database
	@Override
	public ArrayList<Player> getAllPlayers() {
	   return players;
	}

	@Override
	public Player getPlayer(String name) {
		for(Player player : players) {
	        if(player.getName().equals(name)) {
	            return player;
	        }
	    }
	    return null;
	}

	@Override
	// edw otan ftasoume sto shmeio auto tha ginetai elegxos prwta an uparxei to onoma
	public boolean addPlayer(String name) {
		if (getPlayer(name) != null) {
			System.out.println("Player with name: " + name + " already exists");
			return false;
		}
		Player player = new Player(name);
		players.add(player);
		System.out.println("Player: " + player.getName() + ", added in the database");
		return true;
	}
	
	//TODO Define getHallofFame()  
	public Player[] getHallOfFame() {
		Player[] hof = new Player[10];
		
		
		return hof;
	}

}
