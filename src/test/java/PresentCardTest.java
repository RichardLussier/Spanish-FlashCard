import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresentCardTest {
    PresentCard test = new PresentCard("hablar", "yo");

    PresentCard test1 = new PresentCard("tener", "yo");

    PresentCard test2 = new PresentCard("bailar", "nosotros");

    PresentCard test3 = new PresentCard("jugar", "tu");

    @Test
    void getTenseTest() {
        assertEquals("Present", test.getTense());
    }

    @Test
    void conjugateVerbTest() {
        test.conjugateVerb();
        assertEquals("hablo", test.answer);

        test2.conjugateVerb();
        assertEquals("bailamos", test2.answer);

        test1.conjugateVerb(); // tests the conjugateIrreg method as well
        assertEquals("tengo", test1.answer);

        test3.conjugateVerb(); // tests the conjugateIrreg method as well
        assertEquals("juegas", test3.answer);
    }
}