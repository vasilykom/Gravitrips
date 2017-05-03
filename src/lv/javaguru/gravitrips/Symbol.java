package lv.javaguru.gravitrips;

enum Symbol {
    X("X"),
    O("O"),
    EMPTY(".");



    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return symbol;
    }


}

