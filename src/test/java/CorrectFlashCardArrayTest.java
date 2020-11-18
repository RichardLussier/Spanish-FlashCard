import org.junit.jupiter.api.Test;

class CorrectFlashCardArrayTest {

    // creating a new array
    CorrectFlashCardArray test = new CorrectFlashCardArray();

    // creating new Flashcards
    FlashCard estar = new FutureCard("estar", "yo");
    FlashCard venir = new FutureCard("venir", "yo");
    FlashCard bailar = new FutureCard("bailar", "yo");
    FlashCard comprar = new FutureCard("comprar", "yo");
    @Test
    void addTest() {
        test.add(estar);
    }

    @Test
    void calculateAverageAttemptsTest() {
    }
}