package edu.bsu.pig;

public final class Turn {

    private int score = 0;
    private FixedValueDie fixedValueDie;

    public Turn(FixedValueDie fixedValueDie) {
        this.fixedValueDie = fixedValueDie;
    }

    public int getScore() {
        return score;
    }

    public void roll() {
        score += fixedValueDie.getValue();
    }

    /* as this  */
    void setScore(int score) {
        this.score = score;
    }
}
