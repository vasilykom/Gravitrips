package lv.javaguru.gravitrips;

import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board = new Board();
    private boolean gameOver;
    private int gameTypeNr;
    private boolean playerChoosedGameType;
    private Scanner scanner = new Scanner(System.in);
    private int inputNumber;


    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    void startGame() {
        setUpGameGameMode();
        currentPlayer = player1;
        board.resetBoardToNew();
        board.printBoardToConsole();
        board.makeNewListOfValidColumnNumbers();

        while (!gameOver) {
            board.setSymbolOfPlayer();
            board.checkWhichRowIsAvailable(currentPlayer.move(board.createListOfValidColumns()));
            if (board.createListOfValidColumns().isEmpty()) {
                System.out.println("Nobody won!!! Please replay the Game!!!\n");
                gameOver=true;
            } else if (board.checkAllDiagonalsForWinner()) {
                System.out.println("The winner is = " + currentPlayer.getName() + " !!!\n");
                gameOver=true;
            }
            switchPlayer();
        }
        gameOver=false;
        startGame();

    }

    void setUpGameGameMode() {
        showGameGreeting();
        showGameModes();
        validateGamePlayOptionNumber();
        playerChoosedGameType = false;
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
        System.out.println("Game is started!");
        System.out.println("\n**** Player vs Computer ****");
        player1 = new HumanPlayer("X");
        player2 = new AiPlayer("O");
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

    void validateGamePlayOptionNumber() {
        boolean gameModeIsSelected = false;
        while (!gameModeIsSelected) {
            System.out.println();
            System.out.println("( To quit the Game enter: q)");
            System.out.print("Please, enter the Game Play mode number:");

            String q = scanner.nextLine();
            checkIfPlayerWantToQuitGame(q);

            try {

                inputNumber = Integer.parseInt(q);
                if (inputNumber >= 1 && inputNumber <= 4) {
                    gameTypeNr = inputNumber;
                    gameModeIsSelected = true;
                } else {
                    System.out.println("Please enter the correct Game mode");
                }

            } catch (NumberFormatException e) {
                System.out.println("\nInput number is wrong!");
            }
        }
    }

    public void checkIfPlayerWantToQuitGame(String q) {
        if (!Character.isDigit(q.charAt(0))) {
            scanner.close();
            System.exit(0);
        }
    }

    void showGameModes() {
        System.out.println("\nGame Play modes:\n");
        System.out.println("1-Player vs Computer");
        System.out.println("2-Computer vs Player");
        System.out.println("3-Player vs Player");
        System.out.println("4-Computer vs Computer");
    }

    void showGameGreeting() {
        System.out.println("**************************");
        System.out.println("* Welcome to GRAVITRIPS! *");
        System.out.println("**************************");


    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

}
