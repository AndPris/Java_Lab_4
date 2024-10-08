import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Text {
    List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    public void addSentence(Sentence s) {
        sentences.add(s);
    }

    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (Sentence s : sentences) {
            output.append(s.getValue());
            output.append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    public void sortSentencesByWordsAmount() {
        sentences.sort(Comparator.comparing(Sentence::getAmountOfWords));
    }
}
