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
        player1 = new Player("Nirav");
        player2 = new Player("Kiran");
        game = new Game(player1, player2);
    }

    @Test
    public void testCurrentPlayerIsPlayer1() {
        Assert.assertEquals(player1, game.currentPlayer());
    }

    @Test
    public void testStartNextTurn() {
        game.startNextTurn();
        Assert.assertEquals(player2, game.currentPlayer());
    }

    @Test
    public void testIsOver_initial() {
        Assert.assertFalse(game.isOver());
    }

    @Test
    public void testIsOver_player1Has100Points() {
        player1.setScore(100);
        game.bankAndEndTurn();
        Assert.assertTrue(game.isOver());
    }

    @Test
    public void testGameWinner_player1IsWinner() {
        player1.setScore(100);
        game.bankAndEndTurn();
        Assert.assertEquals(player1.getName(), game.getWinner().getName());
    }

    /**
     * This method throws error if getWinner is called before even game is finished
     * Also called as Temporal Coupling in defensive programming: this method should only work
     * when other methods are called first
     */
    @Test(expected = IllegalStateException.class)
    public void testGetWinner_noWinner() {
        game.getWinner();
    }

}
