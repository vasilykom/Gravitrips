package lv.javaguru.gravitrips;

import java.util.Set;

public abstract class Player {
    private String name;
    private Symbol symbol;

    public Player(String name) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public abstract int move(Set set);


}
