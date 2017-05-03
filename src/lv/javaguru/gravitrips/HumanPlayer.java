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
        int numberOfColumnFromUser;
        while (true) {
            Scanner scanner = new Scanner(System.in);

            try {


                System.out.print("Player = " + getName() + ", please input the Nr. of the column: ");
                numberOfColumnFromUser = Integer.parseInt(scanner.nextLine());
                Set<Integer> setFilter;
                setFilter = IntStream
                        .range(1, 8)
                        .boxed()
                        .collect(Collectors.toSet());
                if (!set.contains(numberOfColumnFromUser)) {
                    System.out.println("\nCoulumn Nr. " + numberOfColumnFromUser + " can not be used!!!");
                }
                if ((setFilter.contains(numberOfColumnFromUser) && (set.contains(numberOfColumnFromUser)))) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        }
        return numberOfColumnFromUser;
    }
}

