package lv.javaguru.gravitrips;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board = new Board();
     boolean gameOver;
    private int gameTypeNr;
    boolean playerChoosedGameType = false;

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    void startGame() {
        showGameSettingsMenu();
        currentPlayer = player1;
        board.resetBoardToNew();
        board.printBoardToConsole();
        board.makeNewListOfValidColumnNumbers();
        while (!gameOver) {

            board.setSymbolOfPlayer();
            board.checkWhichRowIsAvailable(currentPlayer.move(board.createListOfValidColumns()));
            if (board.createListOfValidColumns().isEmpty()) {
                System.out.println("Nobody won!!! Please replay the Game!!!\n");
                showGameSettingsMenu();
                startGame();
            } else if (board.checkAllDiagonalsForWinner()) {
                System.out.println("The winner is = " + currentPlayer.getName() + " !!!\n");
                showGameSettingsMenu();
                startGame();
            }
            switchPlayer();
        }
    }

    void showGameSettingsMenu() {
        showGameGreeting();
        showGameModes();
        sellectGamePlayOptionNumber();
        while (!playerChoosedGameType) {
            if (gameTypeNr == 1) {
                proceedGameOption1();
            } else if (gameTypeNr == 2) {
                proceedGameOption2();
            } else if (gameTypeNr == 3) {
                proceedGameOption3();
            } else if (gameTypeNr == 4) {
                proceedGameOption4();
            }
        }
    }

    void proceedGameOption1() {
        player1 = new HumanPlayer("X");
        player2 = new AiPlayer("O");
        System.out.println("Game is started!");
        System.out.println("\n**** Player vs Computer ****");
        playerChoosedGameType = true;
    }

    void proceedGameOption2() {
        System.out.println("***Game is started!***");
        System.out.println("\n**** Computer vs Player ****");
        player1 = new AiPlayer("X");
        player2 = new HumanPlayer("O");
        playerChoosedGameType = true;
    }

    void proceedGameOption3() {
        System.out.println("***Game is started!***");
        System.out.println("\n**** Player vs Player ****");
        player1 = new HumanPlayer("X");
        player2 = new HumanPlayer("O");

        playerChoosedGameType = true;
    }

    void proceedGameOption4() {
        System.out.println("***Game is started!***");
        System.out.println("\n**** Computer vs Computer ****");
        player1 = new AiPlayer("X");
        player2 = new AiPlayer("O");
        playerChoosedGameType = true;
    }

    void sellectGamePlayOptionNumber() {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        while (true) {
            try {
                System.out.println();
                System.out.print("Input Game Play option number: ");
                inputNumber = Integer.parseInt(scanner.nextLine());

                if (inputNumber>=1&&inputNumber<=4) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput number is wrong!");
            }
        }
        gameTypeNr = inputNumber;
    }

    void showGameModes() {

        System.out.println("1-Player vs Computer");
        System.out.println("2-Computer vs Player");
        System.out.println("3-Player vs Player");
        System.out.println("4-Computer vs Computer");
    }

    void showGameGreeting() {
        System.out.println("************************");
        System.out.println("*Welcome to GRAVITRIPS!*");
        System.out.println("************************");
        System.out.println("");
        System.out.println("Select Game mode:");
        System.out.println("");
    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }


}
