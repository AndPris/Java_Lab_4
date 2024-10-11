import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents single word.
 * @see Letter
 */
public class Word implements SentencePart {
    List<Letter> letters;

    /**
     * Constructor. Creates empty list of Letter objects.
     * @see Letter
     */
    public Word() {
        letters = new ArrayList<>();
    }

    /**
     * Adds <code>letter</code> object to list.
     * @param letter letter object to add
     */
    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    /**
     * Returns true if there are no letters in word. Else returns false.
     * @return boolean
     */
    public boolean isEmpty() {
        return letters.isEmpty();
    }

    /**
     * Returns string representation of word
     * @return String
     * @see Letter#getValue()
     */
    @Override
    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (Letter letter : letters)
            output.append(letter.getValue());
        return output.toString();
    }
}
