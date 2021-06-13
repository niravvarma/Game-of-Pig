package edu.bsu.pig;

public final class Game {

    /* ZOI principle */
    private final Player player1;
    private final Player player2;
    private Player current;

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
        this.current = this.current.equals(player1) ? player2 : player1;
    }
}
