/**
 * This interface give sus the methods needed for our array, which will hold the correct flashcards
 */
public interface ArrayInterface {

    /**
     * This method adds a new entry into the array
     * @param newEntry: the entry we want to add
     * @return: the item that we just added
     */
    public FlashCard add(FlashCard newEntry);

    /**
     * This method will calculate the average number of attempts for
     * everything inside of the array
     * @return: the average number of attempts per flashcard
     */
    public double calculateAverageAttempts();
} //end of ArrayInterface interface
