import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerbDictionaryTest {

    // creating a new VerbDictionary
    VerbDictionary<String, String> test = new VerbDictionary<>();


    /**
     * The initial add will return null
     * A call for add with an already existing key will
     * return the old value
     */

    @Test
    void add() {
        // adding to a new empty dictionary, so the method
        // should return null
        assertNull(test.add("estar", "tu"));
        assertNull(test.add("ver", "yo"));
        assertNull(test.add("ser", "usted"));

        // Now testing the replace add method
        assertEquals("tu", test.add("estar", "yo"));
        assertEquals("yo", test.add("ver", "ustedes"));
    } // end add test

    @Test
    void getValue() {
        // adding to the empty dictionary
        test.add("estar", "yo");
        test.add("bailar", "tu");
        test.add("comprar", "usted");
        test.add("correr", "nosotros");
        test.add("olvidar", "ustedes");

        assertEquals("yo", test.getValue("estar"));
        assertEquals("tu", test.getValue("bailar"));
        assertEquals("usted", test.getValue("comprar"));
        assertEquals("nosotros", test.getValue("correr"));
        assertEquals("ustedes", test.getValue("olvidar"));

        // testing getValue on a nonexistent key
        assertNotEquals("tu", test.getValue("decir"));
    } // end getValue test
}