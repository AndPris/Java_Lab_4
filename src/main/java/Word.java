/**
 * Class which represents single word.
 * @see Letter
 */
public class Word implements SentencePart {
    /**
     * Default initial capacity of the array.
     */
    private final int DEFAULT_MAX_SIZE = 15;

    /**
     * The current maximum size of the array.
     */
    private int currentMaxSize = DEFAULT_MAX_SIZE;

    /**
     * The number of elements currently in the array.
     */
    private int currentAmountOfElements = 0;

    /**
     * The rate at which the internal array grows when resizing is required.
     * The array size increases by 30% when full.
     */
    private final double extensionRate = 1.3;

    /**
     * Array of letters in word.
     */
    Letter[] letters;

    /**
     * Constructor. Creates empty array of Letter objects.
     * @see Letter
     */
    public Word() {
        letters = new Letter[currentMaxSize];
    }

    /**
     * Adds <code>letter</code> object to array.
     * @param letter letter object to add
     */
    public void addLetter(Letter letter) {
        if (currentAmountOfElements == currentMaxSize)
            extend();

        letters[currentAmountOfElements++] = letter;
    }

    /**
     * Extends the size of the internal array when the capacity is reached.
     */
    private void extend() {
        currentMaxSize = (int) (currentMaxSize * extensionRate);
        Letter[] newLetters = new Letter[currentMaxSize];
        System.arraycopy(letters, 0, newLetters, 0, currentAmountOfElements);
        letters = newLetters;
    }
    /**
     * Returns true if there are no letters in word. Else returns false.
     * @return boolean
     */
    public boolean isEmpty() {
        return currentAmountOfElements == 0;
    }

    /**
     * Returns string representation of word
     * @return String
     * @see Letter#getValue()
     */
    @Override
    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < currentAmountOfElements; ++i)
            output.append(letters[i].getValue());
        return output.toString();
    }
}
