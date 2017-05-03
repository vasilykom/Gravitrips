package lv.javaguru.gravitrips;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver = false;
    private Board board = new Board();


    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame() {
        currentPlayer = player1;
        board.resetBoardToNew();
        board.printBoardToConsole();
        board.makeNewListOfValidColumnNumbers();

        while (true) {
            board.setSymbolOfPlayer();
            board.checkWhichRowIsAvailable(currentPlayer.move(board.createListOfValidColumns()));
            if(board.createListOfValidColumns().isEmpty()){
                System.out.println("Nobody won!!! Please replay the Game!!!\n");
                SetUp setUp = new SetUp();
                setUp.setUpGameSettings();

            } else if (board.checkAllDiagonalsForWinner()){
                System.out.println("The winner is = " +currentPlayer.getName()+ " !!!\n");
                SetUp setUp = new SetUp();
                setUp.setUpGameSettings();

            }
            switchPlayer();

        }
    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
