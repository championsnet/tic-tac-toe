package main.java.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlayerRoster implements PlayerRosterDao{
	
	ArrayList<Player> players;
	Player selectedPlayerX;
	Player selectedPlayerO;

	public PlayerRoster(){
		players = new ArrayList<Player>();
		
		// Load Player Roster from XML file
		try {  
			//creating a constructor of file class and parsing an XML file  
			File file = new File("resources\\tuctactoe.ser");  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize(); 
			
			NodeList nodeList = doc.getElementsByTagName("player");
			// Manually load data from xml to appropriate structures cuz Java sucks
			for (int itr = 0; itr < nodeList.getLength(); itr++) {  
				Node node = nodeList.item(itr);   
				if (node.getNodeType() == Node.ELEMENT_NODE) {  
					Element e = (Element) node;  
					String name = e.getElementsByTagName("name").item(0).getTextContent();
					int games = Integer.parseInt(e.getElementsByTagName("games").item(0).getTextContent());
					int wins = Integer.parseInt(e.getElementsByTagName("wins").item(0).getTextContent());
					int loses = Integer.parseInt(e.getElementsByTagName("loses").item(0).getTextContent());
					ArrayList<GameRecord> records = new ArrayList<GameRecord>();
					
					NodeList nodeListRecs = doc.getElementsByTagName("record");
					for (int jtr = 0; jtr < nodeListRecs.getLength(); jtr++) {
						Node nodeRec = nodeListRecs.item(jtr);  
						if (nodeRec.getNodeType() == Node.ELEMENT_NODE) {  
							Element er = (Element) nodeRec; 
							String playerX = er.getElementsByTagName("playerX").item(0).getTextContent();
							String playerO = er.getElementsByTagName("playerO").item(0).getTextContent();
							char result = er.getElementsByTagName("result").item(0).getTextContent().charAt(0);
							float scoreX = Float.parseFloat(er.getElementsByTagName("scoreX").item(0).getTextContent());
							float scoreO = Float.parseFloat(er.getElementsByTagName("scoreO").item(0).getTextContent());
							String timestamp = er.getElementsByTagName("timestamp").item(0).getTextContent();
							
							GameRecord record = new GameRecord(playerX, playerO, result, scoreX, scoreO, timestamp);
							records.add(record);
						}
					}
					Player player = new Player(name, games, wins, loses, records);
					players.add(player);
				}  
			}   
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	// Save player roster to XML file (manually cuz Java sucks)
	public void savePlayerRoster() {
		try {

	        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();

	        Element root = doc.createElement("playerRoster");
	        doc.appendChild(root);
	        
	        for (Player pl : players) {
	        	Element player = doc.createElement("player");
		        root.appendChild(player);

	            Element name = doc.createElement("name");
	            name.appendChild(doc.createTextNode(String.valueOf(pl
	                    .getName())));
	            player.appendChild(name);

	            Element games = doc.createElement("games");
	            games.appendChild(doc.createTextNode(String.valueOf(pl
	                    .getGames())));
	            player.appendChild(games);
	            
	            Element wins = doc.createElement("wins");
	            wins.appendChild(doc.createTextNode(String.valueOf(pl
	                    .getGames())));
	            player.appendChild(wins);
	            
	            Element loses = doc.createElement("loses");
	            loses.appendChild(doc.createTextNode(String.valueOf(pl
	                    .getGames())));
	            player.appendChild(loses);
	            
	            Element score = doc.createElement("score");
	            score.appendChild(doc.createTextNode(String.valueOf(pl
	                    .getGames())));
	            player.appendChild(score);
	            
	            Element records = doc.createElement("records");
	            player.appendChild(records);
	            
	            for (GameRecord rec : pl.getGameRecords()) {
	            	Element record = doc.createElement("record");
		            records.appendChild(record);
		            
	            	Element playerx = doc.createElement("playerX");
	            	playerx.appendChild(doc.createTextNode(String.valueOf(rec
		                    .getPlayerX())));
	            	record.appendChild(playerx);
		            
		            Element playero = doc.createElement("playerO");
		            playero.appendChild(doc.createTextNode(String.valueOf(rec
		                    .getPlayerO())));
		            record.appendChild(playero);
		            
		            Element result = doc.createElement("result");
		            result.appendChild(doc.createTextNode(String.valueOf(rec
		                    .getResult())));
		            record.appendChild(result);
		            
		            Element scorex = doc.createElement("scoreX");
		            scorex.appendChild(doc.createTextNode(String.valueOf(rec
		                    .getScoreX())));
		            record.appendChild(scorex);
		            
		            Element scoreo = doc.createElement("scoreO");
		            scoreo.appendChild(doc.createTextNode(String.valueOf(rec
		                    .getScoreO())));
		            record.appendChild(scoreo);
		            
		            Element timestamp = doc.createElement("timestamp");
		            timestamp.appendChild(doc.createTextNode(String.valueOf(rec
		                    .getTimestamp())));
		            record.appendChild(timestamp);
	            }
	        }

	        // Save the document to the disk file
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();

	        // format the XML nicely
	        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

	        aTransformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "4");
	        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        DOMSource source = new DOMSource(doc);
	        try {
	            // location and name of XML file you can change as per need
	            FileWriter fos = new FileWriter("resources\\tuctactoe.ser");
	            StreamResult result = new StreamResult(fos);
	            aTransformer.transform(source, result);

	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    } catch (TransformerException ex) {
	        System.out.println("Error outputting document");

	    } catch (ParserConfigurationException ex) {
	        System.out.println("Error building document");
	    }
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

	//retrieve list of players from the database
	@Override
	public ArrayList<Player> getAllPlayers() {
		return players;
	}
	
	//retrieve list of players from the database in strings
	@Override
	public String[] getAllPlayersString() {
		String[] players = new String[this.players.size()];
		int i = 0;
		for (Player player : this.players) {
			players[i] = player.getName();
			i++;
		}
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
	// ginetai elegxos prwta an uparxei to onoma
	public String addPlayer(String name) {
		if (name.isEmpty()) {
			System.out.println("Name can't be empty");
			return "Name can't be empty";
		}
		if (name.startsWith(" ")) {
			System.out.println("Name can't start with space");
			return "Name can't start with space";
		}
		// Mexri 20 characters epitrepoume sto onoma
		if (name.length() > 20) {
			System.out.println("Too many characters (>20)!");
			return "Too many characters (>20)!";
		}
		if (getPlayer(name) != null) {
			System.out.println("Player with name: " + name + " already exists");
			return "Player with name: " + name + " already exists";
		}
		Player player = new Player(name);
		players.add(player);
		// After player is succesfully added, save roster to file
		this.savePlayerRoster();
		
		System.out.println("Player: " + player.getName() + ", added in the database");
		return "Player: " + player.getName() + " succesfully created!";
	}
	
	@Override 
	public Player[] getHallOfFame() {
		Player[] hof = new Player[10];
		ArrayList<Player> sortedPlayers = players;
		
		// Sort by ascending order
		sortedPlayers.sort(Comparator.comparing(Player::getScore));
		
		// Get top 10 players based on score. If there are less than 10 take those.
		for (int i = 0; i < Integer.min(10, sortedPlayers.size()); i++) {
			// Use sortedPlayers.size()-i-1 because we are in ascending order
			// But we need descending and was too lazy to do it before
			hof[i] = sortedPlayers.get(sortedPlayers.size() - i - 1);
			System.out.println((i+1) + ". " + hof[i].getScore());
		}
		return hof;
	}
	
	@Override
	public Player getSelectedPlayerX() {
		return selectedPlayerX;
	}
	
	@Override
	public Player getSelectedPlayerO() {
		return selectedPlayerO;
	}
	
	public String setSelectedPlayerX(Player selection) {
		if (selectedPlayerO == null || !selection.getName().equals(selectedPlayerO.getName())) {
			selectedPlayerX = selection;
			return null;
		}	
		else {
			return selection.getName() + " already selected in the opposite side!";
		}
	}
	
	public String setSelectedPlayerO(Player selection) {
		if (selectedPlayerX == null || !selection.getName().equals(selectedPlayerX.getName())) {
			selectedPlayerO = selection;
			return null;
		}	
		else {
			return selection.getName() + " already selected in the opposite side!";
		}
	}

}
