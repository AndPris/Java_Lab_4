import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SentenceTests {
    private Sentence sentence;

    @BeforeEach
    public void setUp() {
        sentence = new Sentence();

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
    }

    @Test
    public void getValueTest() {
        assertEquals("Test data.", sentence.getValue());
    }

    @Test
    public void getLastPartTest() {
        assertEquals(".", sentence.getLastPart());
    }

    @Test
    public void isEmptyTest1() {
        assertFalse(sentence.isEmpty());
    }

    @Test
    public void isEmptyTest2() {
        Sentence sentence2 = new Sentence();
        assertTrue(sentence2.isEmpty());
    }

    @Test
    public void getAmountOfWordsTest() {
        assertEquals(2, sentence.getAmountOfWords());
    }
}
