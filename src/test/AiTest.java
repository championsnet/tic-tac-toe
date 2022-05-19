package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.model.AI;
import main.java.model.Board;
import main.java.model.GameLogic;


public class AiTest {

    @Test
    void smart_ai_wins() {
        AI ai = new AI("Joe","Best");
        Board board = new Board(4, 'T', 'x');

        char[][] arr = {{'x', 'x', ' '},
                        {'o', 'o', ' '},
                        {' ', ' ', ' '}};
        GameLogic logic = new GameLogic(arr);
        int[] expected = {0, 2};
        int[] actual = ai.move(board, logic);

        assertSame(actual[0], expected[0]);
        assertSame(actual[1], expected[1]);
    }

    @Test
    void smart_ai_defends() {
        AI ai = new AI("Joe","Best");
        Board board = new Board(4, 'T', 'o');

        char[][] arr = {{'x', 'x', ' '},
                {'o', ' ', ' '},
                {' ', ' ', ' '}};
        GameLogic logic = new GameLogic(arr);
        int[] expected = {0, 2};
        int[] actual = ai.move(board, logic);

        assertSame(actual[0], expected[0]);
        assertSame(actual[1], expected[1]);
    }

    @Test
    void smart_ai_creates_win_condition() {
        AI ai = new AI("Joe","Best");
        Board board = new Board(4, 'T', 'x');

        char[][] arr = {{'x', 'o', ' '},
                {'o', ' ', ' '},
                {'x', ' ', ' '}};
        GameLogic logic = new GameLogic(arr);
        int[] expected_1 = {1, 1};
        int[] expected_2 = {2, 2};
        int[] actual = ai.move(board, logic);

        assertTrue((actual[0] == expected_1[0] && actual[1] == expected_1[1])
                        || (actual[0] == expected_2[0] && actual[1] == expected_2[1]));
    }
}
