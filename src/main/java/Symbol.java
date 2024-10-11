/**
 * Abstract class which represents any single symbol.
 */
public abstract class Symbol {
    protected char symbol;

    /**
     * Constructor. Tabulation replaced with space.
     * @param symbol character to wrap
     */
    public Symbol(char symbol) {
        if(symbol == '\t')
            symbol = ' ';

        this.symbol = symbol;
    }

    /**
     * Returns string value of wrapped character
     * @return String
     */
    public String getValue() {
        return String.valueOf(symbol);
    }
}
