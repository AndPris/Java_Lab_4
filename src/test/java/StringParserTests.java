import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringParserTests {
    private StringParser stringParser;

    @BeforeEach
    public void setUp() {
        stringParser = new StringParser();
    }

    @Test
    public void isLetterTest() {
        assertTrue(stringParser.isLetter('A'));
        assertFalse(stringParser.isLetter('2'));
    }

    @Test
    public void isSentenceEndTest() {
        assertTrue(stringParser.isSentenceEnd('.'));
        assertTrue(stringParser.isSentenceEnd('!'));
        assertTrue(stringParser.isSentenceEnd('?'));
        assertFalse(stringParser.isSentenceEnd(' '));
        assertFalse(stringParser.isSentenceEnd('a'));
    }

    @Test
    public void convertStringIntoTextTest1() {
        Text text = stringParser.convertStringIntoText("First sentence. Another one. This is the end.");
        assertEquals("First sentence. Another one. This is the end.", text.getValue());
    }

    @Test
    public void convertStringIntoTextTest2() {
        Text text = stringParser.convertStringIntoText("First  sentence.. Another \tone.\t This is the end.");
        assertEquals("First sentence. Another one. This is the end.", text.getValue());
    }
}
