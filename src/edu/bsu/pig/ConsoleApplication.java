package edu.bsu.pig;

import java.util.Scanner;

/**
 * This is a view class and thus, there is going to be no unit tests
 * As the functional classes are already covered with unit tests, then it is fine
 *  not to have unit test for view class
 */
public final class ConsoleApplication {

    private static Player player1 = new Player("Nirav");
    private static Player player2 = new Player("Kiran");
    private static Scanner scanner = new Scanner(System.in);
    private static Game game = new Game(player1, player2);

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pig");
        Turn turn = new Turn(player1, new RolledDie());
        while(!game.isOver()) {
            playOneTurn();
        }
        printScores();
        System.out.println("Game over: Winner is " + game.getWinner().getName());
    }

    private static void playOneTurn() {
        while(!game.currentTurn().isOver()) {
            printScores();
            System.out.println("It is " + game.currentPlayer().getName() + "'s turn");
            System.out.println("This turn's score is " + game.currentTurn().getScore());
            System.out.println("Press enter to roll, q to end turn");
            String line = scanner.nextLine();
            if (line.startsWith("q")) {
                game.bankAndEndTurn();
            } else {
                int roll = game.roll();
                System.out.println("You rolled a " + roll);
            }

            /* The following is kind of introducing cheat code in the game
            if(line.startsWith("!")) {
                player1.setScore(100);
            }
             */
        }
        if(!game.isOver()) {
            game.startNextTurn();
        }
    }

    private static void printScores() {
        System.out.println(player1.getName() + "'s score is " + player1.getScore());
        System.out.println(player2.getName() + "'s score is " + player2.getScore());
    }

}
