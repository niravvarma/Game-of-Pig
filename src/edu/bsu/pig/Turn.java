package edu.bsu.pig;

public final class Turn {

    private int score = 0;
    private final Die die;

    public Turn(Die die) {
        this.die = die;
    }

    public int getScore() {
        return score;
    }

    public void roll() {
        score += die.roll();
    }

    /* as this  */
    void setScore(int score) {
        this.score = score;
    }
}
