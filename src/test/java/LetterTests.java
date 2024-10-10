import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterTests {
    @Test
    public void getValueTest() {
        Letter letter = new Letter('A');
        assertEquals("A", letter.getValue());
    }
}
