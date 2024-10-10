import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTests {
    private Text text;

    @BeforeEach
    public void setUp() {
        text = new Text();

        Sentence sentence = new Sentence();

        Word w = new Word();
        w.addLetter(new Letter('T'));
        w.addLetter(new Letter('e'));
        w.addLetter(new Letter('s'));
        w.addLetter(new Letter('t'));
        sentence.addSentencePart(w);

        PunctuationMark pm = new PunctuationMark(' ');
        sentence.addSentencePart(pm);

        w = new Word();
        w.addLetter(new Letter('d'));
        w.addLetter(new Letter('a'));
        w.addLetter(new Letter('t'));
        w.addLetter(new Letter('a'));

        sentence.addSentencePart(w);

        pm = new PunctuationMark('.');
        sentence.addSentencePart(pm);

        text.addSentence(sentence);

        sentence = new Sentence();
        w = new Word();
        w.addLetter(new Letter('S'));
        w.addLetter(new Letter('e'));
        w.addLetter(new Letter('c'));
        w.addLetter(new Letter('o'));
        w.addLetter(new Letter('n'));
        w.addLetter(new Letter('d'));
        sentence.addSentencePart(w);

        pm = new PunctuationMark(' ');
        sentence.addSentencePart(pm);

        w = new Word();
        w.addLetter(new Letter('p'));
        w.addLetter(new Letter('a'));
        w.addLetter(new Letter('r'));
        w.addLetter(new Letter('t'));

        sentence.addSentencePart(w);

        pm = new PunctuationMark('.');
        sentence.addSentencePart(pm);

        text.addSentence(sentence);
    }

    @Test
    public void getValueTest() {
        assertEquals("Test data. Second part.", text.getValue());
    }
}
