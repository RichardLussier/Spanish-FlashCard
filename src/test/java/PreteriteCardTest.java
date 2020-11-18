import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreteriteCardTest {
    PreteriteCard test = new PreteriteCard("hablar", "yo");
    PreteriteCard test1 = new PreteriteCard("correr", "yo");
    PreteriteCard test2 = new PreteriteCard("tener", "usted");
    PreteriteCard test3 = new PreteriteCard("estar", "yo");
    PreteriteCard test4 = new PreteriteCard("dar", "tu");
    PreteriteCard test5 = new PreteriteCard("jugar", "yo");

    @Test
    void conjugateVerbTest() {
        test.conjugateVerb();
        assertEquals("hable", test.answer);
        test1.conjugateVerb();
        assertEquals("corri", test1.answer);
        test2.conjugateVerb();
        assertEquals("tuvo", test2.answer); // also tests conjugateIrreg
        test3.conjugateVerb();
        assertEquals("estuve", test3.answer); // also tests conjugateIrreg
        test4.conjugateVerb();
        assertEquals("diste", test4.answer); // also tests conjugateIrreg
        test5.conjugateVerb();
        assertEquals("jugue", test5.answer); // also tests conjugateIrreg
    } // end of conjugateVerbTest

    @Test
    void getTenseTest() {
        assertEquals("Preterite", test.getTense());
    } // end of getTenseTest
} // end of PreteriteCardTest