public abstract class Symbol {
    protected char symbol;

    public Symbol(char symbol) {
        if(symbol == '\t')
            symbol = ' ';

        this.symbol = symbol;
    }

    public String getValue() {
        return String.valueOf(symbol);
    }
}
