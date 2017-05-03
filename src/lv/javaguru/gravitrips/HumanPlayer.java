package lv.javaguru.gravitrips;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HumanPlayer extends Player {


    public HumanPlayer(String name) {

        super(name);
    }

    @Override
    public int move(Set set) {
        //System.out.println("Player = " + getName() + ", now it is your turn!");
        int numberOfColumnFromUser = 0;
        boolean playerChoosedValidColumnNumber=false;
        while (!playerChoosedValidColumnNumber) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Player = " + getName() + ", please input the Nr. of the column: ");
                numberOfColumnFromUser = Integer.parseInt(scanner.nextLine());

                if (!set.contains(numberOfColumnFromUser)) {
                    System.out.println("\nCoulumn Nr. " + numberOfColumnFromUser + " can not be used!!!");
                }
                if (((set.contains(numberOfColumnFromUser)))) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nWrong ipnput number!");
            }
        }
        return numberOfColumnFromUser;
    }
}

