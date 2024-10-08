import java.util.ArrayList;
import java.util.List;

public class Word implements SentencePart {
    List<Letter> letters;

    public Word() {
        letters = new ArrayList<>();
    }

    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    public boolean isEmpty() {
        return letters.isEmpty();
    }

    @Override
    public String getValue() {
        StringBuilder output = new StringBuilder();
        for (Letter letter : letters)
            output.append(letter.getValue());
        return output.toString();
    }
}
