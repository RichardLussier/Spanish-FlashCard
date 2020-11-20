import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectFlashCardArrayTest {


        // creating a new array
        CorrectFlashCardArray test = new CorrectFlashCardArray();

        // creating new Flashcards
        FlashCard estar = new FutureCard("estar", "yo");
        FlashCard venir = new FutureCard("venir", "yo");
        FlashCard bailar = new FutureCard("bailar", "yo");
        FlashCard comprar = new FutureCard("comprar", "yo");
        FlashCard revolver = new FutureCard("revolver", "yo");

    @Test
    void addTest() {
        assertEquals(estar, test.add(estar));
        assertEquals(venir, test.add(venir));
        assertEquals(bailar, test.add(bailar));
        assertEquals(comprar, test.add(comprar));
        assertEquals(revolver, test.add(revolver));
    } // end addTest

} // end CorrectFlashCardArrayTest