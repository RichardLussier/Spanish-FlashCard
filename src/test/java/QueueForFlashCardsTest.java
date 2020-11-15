import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueForFlashCardsTest {
    QueueForFlashCards<String> test = new QueueForFlashCards<>();

    @Test
    void enqueueTest() {
        assertEquals(0, test.getSize());
        test.enqueue("test");
        test.enqueue("apple");
        test.enqueue("orange");
        assertEquals(3, test.getSize());
    }

    @Test
    void dequeueTest() {
        test.enqueue("test");
        test.enqueue("apple");
        test.enqueue("orange");
        assertEquals("test", test.dequeue());
        assertEquals("apple", test.dequeue());
        assertEquals("orange", test.dequeue());
    }

    @Test
    void getFrontTest() {
        test.enqueue("test");
        test.enqueue("apple");
        test.enqueue("orange");
        assertEquals("test", test.getFront());
        test.dequeue();
        assertEquals("apple", test.getFront());
    }

    @Test
    void isEmptyTest() {
        assertTrue(test.isEmpty());
        test.enqueue("test");
        test.enqueue("apple");
        test.enqueue("orange");
        assertFalse(test.isEmpty());
        test.dequeue();
        test.dequeue();
        test.dequeue();
        assertTrue(test.isEmpty());
    }

    @Test
    void getSizeTest() {
        assertEquals(0, test.getSize());
        test.enqueue("test");
        test.enqueue("apple");
        test.enqueue("orange");
        assertEquals(3, test.getSize());
    }
}