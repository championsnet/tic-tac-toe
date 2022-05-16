package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import main.java.model.Player;


class PlayerTest {

    @Test
    void games_more_than_wins_loses() {
    	Player player = new Player("Joe");
        assertTrue(player.getGames()>= player.getWins());
        assertTrue(player.getGames()>= player.getLoses());
    }
    
//	// Test getBestGames();
//	int[][] relativeScores = {{60, 1}, {100, 2}, {70, 3}, {40, 4}, {55, 5}, {99, 6}, {71, 7}};
//	Arrays.sort(relativeScores, Comparator.comparingDouble(o -> o[0]));
//	for (int i = 0; i < 7; i++) System.out.println(relativeScores[7-i-1][1]);

}
