import java.util.ArrayList;
import java.util.List;

public class Sentence {
    List<SentencePart> sentenceParts;

    /**
     * Constructor. Creates empty list of SentencePart objects.
     * @see SentencePart
     */
    public Sentence() {
        sentenceParts = new ArrayList<>();
    }

    /**
     * Adds <code>letter</code> object to list.
     * @param sentencePart sentencePart object to add
     */
    public void addSentencePart(SentencePart sentencePart) {
        if(isEmpty() && sentencePart instanceof PunctuationMark)
            return;

        sentenceParts.add(sentencePart);
    }

    /**
     * Returns string representation of sentence.
     * @return String
     * @see SentencePart#getValue()
     */
    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (SentencePart sentencePart : sentenceParts)
            output.append(sentencePart.getValue());
        return output.toString();
    }

    /**
     * Returns string representation of last part of sentence.
     * @return String
     */
    public String getLastPart() {
        return sentenceParts.getLast().getValue();
    }

    /**
     * Returns true if there are no words of punctuation marks in sentence. Else returns false.
     * @return boolean
     */
    public boolean isEmpty() {
        return sentenceParts.isEmpty();
    }

    /**
     * Returns amount of words in sentence.
     * @return int
     */
    public int getAmountOfWords() {
        return (int) sentenceParts.stream().filter(part -> part instanceof Word).count();
    }
}
