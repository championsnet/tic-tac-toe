package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.model.Player;


class PlayerTest {

    @Test
    void games_more_than_wins_loses() {
    	Player player = new Player("Joe");
        assertTrue(player.getGames()>= player.getWins());
        assertTrue(player.getGames()>= player.getLoses());
    }

}
