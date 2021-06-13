package edu.bsu.pig;

public final class Game {

    private static final int POINTS_TO_WIN = 100;

    /* ZOI principle */
    private final Player player1;
    private final Player player2;
    private Player current;
    private boolean isOver = false;

    public Game(Player player1, Player player2) {
        /* There should be null or error checks here */
        this.player1 = player1;
        this.player2 = player2;
        this.current = player1;
    }

    public Player currentPlayer() {
        return current;
    }

    public void endTurn() {
        if(this.current.getScore() >= POINTS_TO_WIN) {
            this.isOver = true;
        }
        this.current = this.current.equals(player1) ? player2 : player1;
    }

    public boolean isOver() {
        return isOver;
    }
}
