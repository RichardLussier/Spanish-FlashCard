import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FutureCardTest {
    FutureCard test = new FutureCard("haber", "tu");
    FutureCard test1 = new FutureCard("estar", "yo");

    @Test
    void getTenseTest() {
        assertEquals("Future", test.getTense());
    } // end of getTenseTest

    @Test
    void conjugateVerbTest() {
        test.conjugateVerb(); // tests the conjugateIrreg method as well
        assertEquals("habras", test.answer);
        test1.conjugateVerb();
        assertEquals("estare", test1.answer);

    } // end of conjugateVerbTest
} // end of FutureCardTest