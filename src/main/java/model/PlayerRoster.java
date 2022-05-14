package main.java.model;

import java.util.ArrayList;

public class PlayerRoster implements PlayerRosterDao{
	
	ArrayList<Player> players;

	public PlayerRoster(){
		players = new ArrayList<Player>();
		// edw 8a fortonoume apo arxeio
	}
	   
	   
	@Override
	public void deletePlayer(Player player) {
	   players.remove(player);
	   System.out.println("Player: " + player.getName() + ", deleted from database");
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
	public void addPlayer(Player player) {
		players.add(player);
		System.out.println("Player: " + player.getName() + ", added in the database");
	}
	
	//TODO Define getHallofFame()  

}
