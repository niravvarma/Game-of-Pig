package edu.bsu.pig;

import org.junit.Assert;
import org.junit.Test;

public class TurnTest {

    @Test
    public void testGetScore_startsAtZero() {
        Turn turn = new Turn(new FixedValueDie(3));
        Assert.assertEquals(0, turn.getScore());
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
        Turn turn = new Turn(new FixedValueDie(3));
        turn.roll();
        Assert.assertEquals(3, turn.getScore());
    }

    @Test
    public void testRoll_secondRollNotBust() {
        Turn turn = new Turn(new FixedValueDie(4));
        turn.setScore(3);
        turn.roll();
        Assert.assertEquals(7, turn.getScore());
    }

}
