/**
 * Class which represents single sentence.
 * @see SentencePart
 */
public class Sentence {
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
     * Array of sentence parts in sentence.
     */
    SentencePart[] sentenceParts;

    /**
     * Constructor. Creates empty array of SentencePart objects.
     * @see SentencePart
     */
    public Sentence() {
        sentenceParts = new SentencePart[currentMaxSize];
    }

    /**
     * Adds <code>letter</code> object to array.
     * @param sentencePart sentencePart object to add
     */
    public void addSentencePart(SentencePart sentencePart) {
        if(isEmpty() && sentencePart instanceof PunctuationMark)
            return;

        if (currentAmountOfElements == currentMaxSize)
            extend();

        sentenceParts[currentAmountOfElements++] = sentencePart;
    }

    /**
     * Extends the size of the internal array when the capacity is reached.
     */
    private void extend() {
        currentMaxSize = (int) (currentMaxSize * extensionRate);
        SentencePart[] newSentenceParts = new SentencePart[currentMaxSize];
        System.arraycopy(sentenceParts, 0, newSentenceParts, 0, currentAmountOfElements);
        sentenceParts = newSentenceParts;
    }

    /**
     * Returns string representation of sentence.
     * @return String
     * @see SentencePart#getValue()
     */
    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < currentAmountOfElements; i++)
            output.append(sentenceParts[i].getValue());
        return output.toString();
    }

    /**
     * Returns string representation of last part of sentence.
     * @return String
     */
    public String getLastPart() {
        return sentenceParts[currentAmountOfElements-1].getValue();
    }

    /**
     * Returns true if there are no words of punctuation marks in sentence. Else returns false.
     * @return boolean
     */
    public boolean isEmpty() {
        return currentAmountOfElements == 0;
    }

    /**
     * Returns amount of words in sentence.
     * @return int
     */
    public int getAmountOfWords() {
        int amountOfWords = 0;
        for (SentencePart sentencePart : sentenceParts) {
            if(sentencePart instanceof Word)
                amountOfWords++;
        }
        return amountOfWords;
    }
}
