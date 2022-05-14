package main.java;

import main.java.model.*;
import main.java.view.*;

public class Main {

	public static void main(String[] args) {
		PlayerRoster a = new PlayerRoster();
		Player b = new Player("Harry");
		a.addPlayer(b);
		
		new MainWindow(2);

	}

}
