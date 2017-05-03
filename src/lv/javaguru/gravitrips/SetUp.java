package lv.javaguru.gravitrips;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetUp {
    private int playMode;

    protected void setUpGameSettings() {
        while (true) {
            System.out.println("************************");
            System.out.println("*Welcome to GRAVITRIPS!*");
            System.out.println("************************");
            System.out.println("");
            System.out.println("Select Game mode:");
            System.out.println("");
            System.out.println("1-Player vs Computer");
            System.out.println("2-Computer vs Player");
            System.out.println("3-Player vs Player");
            System.out.println("4-Computer vs Computer");

            getGamePlayOptionNumber();
            if (playMode == 1) {
                Game game = new Game(new HumanPlayer("X"), new AiPlayer("O"));
                System.out.println("Game is started!");
                System.out.println("\n**** Player vs Computer ****");
                game.startGame();
                break;
            } else if (playMode == 2) {
                System.out.println("***Game is started!***");
                System.out.println("\n**** Computer vs Player ****");
                Game game = new Game(new AiPlayer("X"), new HumanPlayer("O"));
                game.startGame();

            } else if (playMode == 3) {
                System.out.println("***Game is started!***");
                System.out.println("\n**** Player vs Player ****");
                Game game = new Game(new HumanPlayer("X"), new HumanPlayer("O"));
                game.startGame();

            } else if (playMode == 4) {
                System.out.println("***Game is started!***");
                System.out.println("\n**** Computer vs Computer ****");
                Game game = new Game(new AiPlayer("X"), new AiPlayer("O"));
                game.startGame();

                break;
            }
        }
    }


    private void getGamePlayOptionNumber() {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        while (true) {
            try {
                System.out.println();
                System.out.print("Input Game Play option number: ");
                inputNumber = Integer.parseInt(scanner.nextLine());
                Set<Integer> set;
                set = IntStream
                        .range(1, 5)
                        .boxed()
                        .collect(Collectors.toSet());

                if (set.contains(inputNumber)) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        }
        playMode = inputNumber;
    }
}