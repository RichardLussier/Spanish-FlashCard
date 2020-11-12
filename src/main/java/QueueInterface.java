/**
 * This interface holds the methods needed for our queue
 * @param <T>: the abstract type of our queue
 */
public interface QueueInterface<T> {

    /**
     * This method will add an entry into the back of the queue
     * @param anEntry: the item we want to add to the back
     */
    public void enqueue(T anEntry);

    /**
     * This method takes the entry from the front of the queue
     * @return: the item that we removed from the queue
     */
    public T dequeue();

    /**
     * This method returns the front of the queue without removing it
     * @return: the entry at the front of the queue
     */
    public T getFront();

    /**
     * This method checks whether the queue is empty
     * @return: true if the queue is empty, false otherwise
     */
    public boolean isEmpty();
} //end of QueueInterface interface
