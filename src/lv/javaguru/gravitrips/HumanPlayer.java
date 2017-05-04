package lv.javaguru.gravitrips;

import java.util.Scanner;
import java.util.Set;


public class HumanPlayer extends Player {


    public HumanPlayer(String name) {

        super(name);
    }

    @Override
    public int move(Set set) {
        int numberOfColumnFromUser = 0;
        boolean playerChoosedValidColumnNumber=false;
        while (!playerChoosedValidColumnNumber) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Player = " + getName() + ", please input the Nr. of the column: ");
                numberOfColumnFromUser = Integer.parseInt(scanner.nextLine());

                if (!set.contains(numberOfColumnFromUser)&&numberOfColumnFromUser>=1&&numberOfColumnFromUser<=Board.getCOLUMNS()) {
                    System.out.println("\nCoulumn Nr. " + numberOfColumnFromUser + " can not be used!!!");

                } else if (numberOfColumnFromUser<1||numberOfColumnFromUser>Board.getCOLUMNS()){
                    System.out.println("Please, use column number from 1 to "+ (Board.getCOLUMNS())+"\n");
                }

                else if (set.contains(numberOfColumnFromUser)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nWrong input value, please use numbers only!");
            }
        }
        return numberOfColumnFromUser;
    }
}

