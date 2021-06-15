package edu.bsu.pig;

import java.util.Scanner;

/**
 * This is a view class and thus, there is going to be no unit tests
 * As the functional classes are already covered with unit tests, then it is fine
 *  not to have unit test for view class
 */
public final class ConsoleApplication {

    public static void main(String[] args) {
        Player player1 = new Player("Nirav");
        Player player2 = new Player("Kiran");
        Game game = new Game(player1, player2);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game of Pig");
        Turn turn = new Turn(new RolledDie());
        while(!game.isOver()) {
            System.out.println(player1.getName() + "'s score is " + player1.getScore());
            System.out.println(player2.getName() + "'s score is " + player2.getScore());
            System.out.println("It is " + game.currentPlayer().getName() + "'s turn");
            System.out.println("Press enter to roll");
            String line = scanner.nextLine();
            turn.roll();

            /* The following is kind of introducing cheat code in the game
            if(line.startsWith("!")) {
                player1.setScore(100);
            }
             */
            game.endTurn();
        }

        System.out.println("Game over: Winner is " + game.getWinner().getName());
    }

}
