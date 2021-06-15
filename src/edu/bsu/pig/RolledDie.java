package edu.bsu.pig;

import java.util.Random;

public final class RolledDie implements Die {

    private static final Random RANDOM = new Random();

    @Override
    public int roll() {
        return RANDOM.nextInt(6) + 1;
    }
}
