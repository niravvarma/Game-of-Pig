package edu.bsu.pig;

import java.security.SecureRandom;

public final class RolledDie implements Die {

    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public int roll() {
        return RANDOM.nextInt(6) + 1;
    }
}
