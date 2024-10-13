import java.util.Arrays;
import java.util.Comparator;

/**
 * Class which represents a piece of text.
 * @see Sentence
 */
public class Text {
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
     * Array of sentences in text.
     */
    Sentence[] sentences;

    /**
     * Constructor. Creates empty array of sentence objects.
     * @see Sentence
     */
    public Text() {
        sentences = new Sentence[currentMaxSize];
    }

    /**
     * Adds <code>sentence</code> object to array.
     * @param sentence sentence object to add
     */
    public void addSentence(Sentence sentence) {
        if (currentAmountOfElements == currentMaxSize)
            extend();

        sentences[currentAmountOfElements++] = sentence;
    }

    /**
     * Extends the size of the internal array when the capacity is reached.
     */
    private void extend() {
        currentMaxSize = (int) (currentMaxSize * extensionRate);
        Sentence[] newSentences = new Sentence[currentMaxSize];
        System.arraycopy(sentences, 0, newSentences, 0, currentAmountOfElements);
        sentences = newSentences;
    }

    /**
     * Returns string representation of text. At the end of each sentence except last adds space.
     * @return String
     * @see Sentence#getValue()
     */
    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < currentAmountOfElements; i++) {
            output.append(sentences[i].getValue());
            output.append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    /**
     * Sorts sentences of text in words amount ascending order.
     */
    public void sortSentencesByWordsAmount() {
        Arrays.sort(sentences, 0, currentAmountOfElements, Comparator.comparing(Sentence::getAmountOfWords));
    }
}
