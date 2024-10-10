import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Text {
    List<Sentence> sentences;

    /**
     * Constructor. Creates empty list of sentence objects.
     * @see SentencePart
     */
    public Text() {
        sentences = new ArrayList<>();
    }

    /**
     * Adds <code>sentence</code> object to list.
     * @param sentence sentence object to add
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Returns string representation of text. At the end of each sentence except last adds space.
     * @return String
     * @see Sentence#getValue()
     */
    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (Sentence s : sentences) {
            output.append(s.getValue());
            output.append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    /**
     * Sorts sentences of text in words amount ascending order.
     */
    public void sortSentencesByWordsAmount() {
        sentences.sort(Comparator.comparing(Sentence::getAmountOfWords));
    }
}
