package lv.javaguru.gravitrips;

import java.util.LinkedHashSet;
import java.util.Set;

public class Board {
    private final static int COLUMNS = 7;
    private final static int ROWS = 7;
    private final int WIN = 4;
    private int userColumnNumber;
    private int rowAvailable;
    private String symbolOfPlayer;
    private int counter;

    private String[][] boardState = new String[ROWS][COLUMNS];
    private Set<Integer> numbersOfAvailableColumns = new LinkedHashSet<>();
    public static int getCOLUMNS() {
        return COLUMNS;
    }


    public void makeNewListOfValidColumnNumbers() {
        for (int t = 1; t <= COLUMNS; t++) {
            numbersOfAvailableColumns.add(t);
        }
    }

    public Set createListOfValidColumns() {
        for (int s = 0; s < COLUMNS; s++) {
            if (boardState[1][s] != ".") {

                numbersOfAvailableColumns.remove(s + 1);
            }
        }
        return numbersOfAvailableColumns;
    }

    public void resetBoardToNew() {
        this.counter=0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (i == 0) {
                    boardState[0][j] = String.valueOf(j + 1);

                } else {
                    boardState[i][j] = Symbol.EMPTY.toString();
                }
            }
        }
    }


    void writeUserNumberToBoard() {

        if (boardState[rowAvailable][userColumnNumber - 1].equals(Symbol.EMPTY.toString())) {

            if (counter % 2 == 0) {
                boardState[rowAvailable][userColumnNumber - 1] = Symbol.X.toString();
            } else {
                boardState[rowAvailable][userColumnNumber - 1] = Symbol.O.toString();
            }
            rowAvailable--;
            counter++;
        }
        createListOfValidColumns();
        printBoardToConsole();
    }

    boolean checkAllDiagonalsForWinner() {
        if ((checkDiagonalsLeftBottomToRightTop1()) || checkDiagonalsLeftBottomToRightTop2() ||
                checkDiagonalsRightTopToLeftBottom1() || checkDiagonalsRightTopToLeftBottom2() ||
                checkVerticalLines()|| checkHorizontalLines()) {
            return true;
        }
        return false;
    }


    void printBoardToConsole() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(boardState[i][j] + " ");
            }
            System.out.println();
        }
    }


    boolean checkHorizontalLines() {
        for (int m = 0; m < ROWS; m++) {
            int counterHorizontal = 0;
            for (int n = 0; n < COLUMNS; n++) {
                boolean symbolCheckHorizontal = boardState[m][n].equals(symbolOfPlayer);
                if (symbolCheckHorizontal) {
                    counterHorizontal++;
                    System.out.println("x"+m+"y"+n);
                    System.out.println(counterHorizontal);
                } else {
                    counterHorizontal = 0;
                }
                if (counterHorizontal == WIN) {
                    System.out.println("Hit in the Horizontal Line!");
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkVerticalLines() {

        for (int m = 0; m < ROWS; m++) {
            int counterVertical = 0;
            for (int n = 0; n < COLUMNS; n++) {
                boolean symbolCheckVertical = boardState[n][m].equals(symbolOfPlayer);
                if (symbolCheckVertical) {
                    counterVertical++;
                } else {
                    counterVertical = 0;
                }
                if (counterVertical == WIN) {
                    System.out.println("Hit in the Vertical Line!");
                    return true;

                }
            }
        }
        return false;
    }

    boolean checkDiagonalsRightTopToLeftBottom1() {
        int counterDiagonalR = 0;
        int startPointX = rowAvailable + 1;
        int startPointY = userColumnNumber - 1;

        if (startPointX >= startPointY) {
            startPointX = startPointX - startPointY;
            for (int n = 0; n < (ROWS - startPointX); n++) {
                boolean symbolCheckDiagonalR = boardState[(startPointX + n)][n].equals(symbolOfPlayer);
                if (symbolCheckDiagonalR) {
                    counterDiagonalR++;
                } else {
                    counterDiagonalR = 0;
                }
                if (counterDiagonalR == WIN) {
                    System.out.println("Hit in the Lower Diagonal from Top to Bottom");
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkDiagonalsRightTopToLeftBottom2() {
        int counterDiagonalR = 0;
        int startPointX = rowAvailable + 1;
        int startPointY = userColumnNumber - 1;

        if (startPointX < startPointY) {
            startPointY = startPointY - startPointX;
            for (int n = 0; n < ROWS - startPointY; n++) {
                boolean symbolCheckDiagonalR = boardState[n][startPointY + n].equals(symbolOfPlayer);
                if (symbolCheckDiagonalR) {
                    counterDiagonalR++;
                } else {
                    counterDiagonalR = 0;
                }
                if (counterDiagonalR == WIN) {
                    System.out.println("Hit in the Upper Diagonal from Top to Bottom");
                    return true;
                }
            }
        }
        return false;
    }

    void setSymbolOfPlayer() {
        if (counter % 2 == 0) {
            this.symbolOfPlayer = Symbol.X.toString();
        } else {
            this.symbolOfPlayer = Symbol.O.toString();
        }
    }

    boolean checkDiagonalsLeftBottomToRightTop1() {
        int counterDiagonalL = 0;
        int startPointX = rowAvailable + 1;
        int startPointY = userColumnNumber - 1;
        if (startPointX + startPointY < ROWS) {
            startPointX = startPointX + startPointY;
            for (int n = 0; n < startPointX; n++) {
                boolean symbolCheckDiagonalL = boardState[startPointX - n][n].equals(symbolOfPlayer);
                if (symbolCheckDiagonalL) {
                    counterDiagonalL++;

                } else {
                    counterDiagonalL = 0;
                }
                if (counterDiagonalL == WIN) {
                    System.out.println("Hit in the Lower Diagonal from Bottom to Top");
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkDiagonalsLeftBottomToRightTop2() {

        int counterDiagonalL = 0;
        int startPointX = rowAvailable + 1;
        int startPointY = userColumnNumber - 1;
        if (startPointX + startPointY >= ROWS) {
            startPointY = startPointY - ((ROWS - 1) - startPointX);
            for (int n = 0; n < ROWS - startPointX; n++) {
                boolean symbolCheckDiagonalL = boardState[(ROWS-1) - n][n + startPointY].equals(symbolOfPlayer);
                if (symbolCheckDiagonalL) {
                    counterDiagonalL++;

                } else {
                    counterDiagonalL = 0;

                }
                if (counterDiagonalL == WIN) {
                    System.out.println("Hit in the Upper Diagonal from Bottom to Top");

                    return true;
                }
            }
        }
        return false;
    }


    protected void checkWhichRowIsAvailable(int userColumnNumber) {
        int maxNumberOfRowNotUsed = ROWS - 1;
        while (boardState[maxNumberOfRowNotUsed][userColumnNumber - 1] != Symbol.EMPTY.toString()) {
            if (maxNumberOfRowNotUsed >= 1) {
                maxNumberOfRowNotUsed--;
            }
        }
        this.rowAvailable = maxNumberOfRowNotUsed;
        this.userColumnNumber = userColumnNumber;
        writeUserNumberToBoard();
    }

}
