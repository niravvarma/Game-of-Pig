package edu.bsu.pig;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Player player1;
    private Player player2;
    private Game game;

    @Before
    public void setUp(){
        player1 = new Player();
        player2 = new Player();
        game = new Game(player1, player2);
    }

    @Test
    public void testCurrentPlayerIsPlayer1() {
        Assert.assertEquals(player1, game.currentPlayer());
    }

    @Test
    public void testCurrentPlayer_firstTurnFinished() {
        game.endTurn();
        Assert.assertEquals(player2, game.currentPlayer());
    }

    @Test
    public void testIsOver_initial() {
        Assert.assertFalse(game.isOver());
    }

    @Test
    public void testIsOver_player1Has100Points() {
        player1.setScore(100);
        game.endTurn();
        Assert.assertTrue(game.isOver());
    }

}
