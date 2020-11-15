import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreteriteCardTest {
    PreteriteCard test = new PreteriteCard("hablar", "yo");
    PreteriteCard test1 = new PreteriteCard("correr", "yo");

    @Test
    void conjugateVerbTest() {
        test.conjugateVerb();
        assertEquals("hable", test.answer);
        test1.conjugateVerb();
        assertEquals("corri", test1.answer);
    }

    @Test
    void getTenseTest() {
        assertEquals("Preterite", test.getTense());
    }
}