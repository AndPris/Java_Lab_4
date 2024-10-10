import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WordTests {
    @Test
    public void getValueTest() {
        Word word = new Word();
        word.addLetter(new Letter('t'));
        word.addLetter(new Letter('e'));
        word.addLetter(new Letter('s'));
        word.addLetter(new Letter('t'));
        assertEquals("test", word.getValue());
    }

    @Test
    public void isEmptyTest1() {
        Word word = new Word();
        assertTrue(word.isEmpty());
    }

    @Test
    public void isEmptyTest2() {
        Word word = new Word();
        word.addLetter(new Letter('t'));
        assertFalse(word.isEmpty());
    }
}
