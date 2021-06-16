package edu.bsu.pig;

public final class Game {

    private static final int POINTS_TO_WIN = 100;
    private static final Die DIE = new RolledDie();

    /* ZOI principle */
    private final Player player1;
    private final Player player2;
    private boolean isOver = false;
    private Player winner;
    private Turn turn;

    public Game(Player player1, Player player2) {
        /* There should be null or error checks here */
        this.player1 = player1;
        this.player2 = player2;
        this.turn = new Turn(player1, DIE);
    }

    public Player currentPlayer() {
        return turn.getPlayer();
    }

    public void bankAndEndTurn() {
        turn.end();
        if(currentPlayer().getScore() >= POINTS_TO_WIN) {
            this.winner = currentPlayer();
            this.isOver = true;
        }
    }

    public void startNextTurn() {
        turn = new Turn(getNextPlayer(), DIE);
    }

    private Player getNextPlayer() {
        return currentPlayer().equals(player1) ? player2 : player1;
    }

    public boolean isOver() {
        return isOver;
    }

    public Player getWinner() {
        if(!isOver()) {
            throw new IllegalStateException("Game is not over yet");
        } else {
            return this.winner;
        }
    }

    public int roll(){
        return turn.roll();
    }

    public Turn currentTurn() {
        return turn;
    }
}
