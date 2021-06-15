package edu.bsu.pig;

public final class Turn {

    private int score = 0;
    private final Die die;
    private final Player player;

    public Turn(Player player, Die die) {
        this.player = player;
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

    public void end() {
        this.player.setScore(player.getScore() + this.score);
    }

    public Player getPlayer() {
        return player;
    }
}
