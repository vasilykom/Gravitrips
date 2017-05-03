package lv.javaguru.gravitrips;


import java.util.Set;


public class AiPlayer extends Player {
    protected AiPlayer(String name) {
        super(name);
    }

    @Override
    public int move(Set set) {
        int columnNumberFromAiPlayer;
        do{
            columnNumberFromAiPlayer = ((int) (Math.random() * Board.COLUMNS)+1);
        } while (!set.contains(columnNumberFromAiPlayer));

        System.out.println("Computer = "+ getName()+ ", number of column is:" + (columnNumberFromAiPlayer)+"\n");
        return columnNumberFromAiPlayer;
    }
}
