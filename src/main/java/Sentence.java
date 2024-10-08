import java.util.ArrayList;
import java.util.List;

public class Sentence {
    List<SentencePart> sentenceParts;

    public Sentence() {
        sentenceParts = new ArrayList<SentencePart>();
    }

    public Sentence(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public void addSentencePart(SentencePart sentencePart) {
        if(isEmpty() && sentencePart instanceof PunctuationMark)
            return;

        sentenceParts.add(sentencePart);
    }

    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (SentencePart sentencePart : sentenceParts)
            output.append(sentencePart.getValue());
        return output.toString();
    }

    public String getLastPart() {
        return sentenceParts.get(sentenceParts.size() - 1).getValue();
    }

    public boolean isEmpty() {
        return sentenceParts.isEmpty();
    }

    public int getAmountOfWords() {
        return (int) sentenceParts.stream().filter(part -> part instanceof Word).count();
    }
}
