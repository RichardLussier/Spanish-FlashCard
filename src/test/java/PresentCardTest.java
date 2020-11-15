import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresentCardTest {
    PresentCard test = new PresentCard("hablar", "yo");

    PresentCard test1 = new PresentCard("tener", "yo");

    @Test
    void getTenseTest() {
        assertEquals("Present", test.getTense());
    }

    @Test
    void conjugateVerbTest() {
        test.conjugateVerb();
        assertEquals("hablo", test.answer);

        test1.conjugateVerb();
        assertEquals("tengo", test1.answer);
    }
}