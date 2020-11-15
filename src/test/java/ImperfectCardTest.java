import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImperfectCardTest {

    ImperfectCard test = new ImperfectCard("hablar", "usted");
    ImperfectCard test1 = new ImperfectCard("correr", "usted");
    ImperfectCard test2 = new ImperfectCard("ser", "nosotros");


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

        test2.conjugateVerb();
        assertEquals("eramos", test2.answer);
    }
}