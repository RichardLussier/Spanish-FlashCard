import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImperfectCardTest {

    ImperfectCard test = new ImperfectCard("hablar", "usted");
    ImperfectCard test1 = new ImperfectCard("correr", "usted");
    ImperfectCard test2 = new ImperfectCard("ser", "nosotros");
    ImperfectCard test3 = new ImperfectCard("ir", "yo");
    ImperfectCard test4 = new ImperfectCard("ver", "tu");


    @Test
    void getTenseTest() {
        assertEquals("Imperfect", test.getTense());
    }

    @Test
    void conjugateVerb() {
        test.conjugateVerb();
        assertEquals("hablaba", test.answer);

        test1.conjugateVerb();
        assertEquals("corria", test1.answer);

        test2.conjugateVerb(); // tests the conjugateIrreg method as well
        assertEquals("eramos", test2.answer);

        test3.conjugateVerb(); // tests the conjugateIrreg method as well
        assertEquals("iba", test3.answer);

        test4.conjugateVerb(); // tests the conjugateIrreg method as well
        assertEquals("veias", test4.answer);
    }
}