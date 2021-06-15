package edu.bsu.pig;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player("Test Player");
    }

    @Test
    public void testGetScore_startsAtZero() {
        Turn turn = makeTurnWithFixedDieValue(3);
        Assert.assertEquals(0, turn.getScore());
    }

    private Turn makeTurnWithFixedDieValue(int value) {
        return new Turn(player, new FixedValueDie(value));
    }

    /**
     * Dependency injection: Turn class depends on Die class
     *
     * 1 option to create Die in Turn but unit test class does not access if Die is created in Turn class
     * so basically we can inject Die class in the Turn
     *
     */
    @Test
    public void testRoll_modifiesScoresByRollsAmount() {
        Turn turn = makeTurnWithFixedDieValue(3);
        turn.roll();
        Assert.assertEquals(3, turn.getScore());
    }

    @Test
    public void testRoll_secondRollNotBust() {
        Turn turn = makeTurnWithFixedDieValue(4);
        turn.setScore(3);
        turn.roll();
        Assert.assertEquals(7, turn.getScore());
    }

    @Test
    public void testEnd_modifiesPlayersScore() {
        Turn turn = makeTurnWithFixedDieValue(4);
        turn.setScore(10);
        turn.end();
        Assert.assertEquals(10, turn.getPlayer().getScore());
    }

}
