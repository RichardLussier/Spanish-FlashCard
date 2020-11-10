/**
 * This class holds the methods that allow us to operate the array
 * which holds the flashcards that the user has gotten correct.
 */
public class CorrectFlashCardArray implements ArrayInterface {

    private FlashCard[] correctCards;
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 10;

    public CorrectFlashCardArray(){
        this(DEFAULT_CAPACITY);
    } //end of constructor

    public CorrectFlashCardArray(int capacity){
        correctCards = new FlashCard[capacity];
        numberOfEntries = 0;
        integrityOK = true;
    } //end of constructor

    /**
     * This method will add the given entry into the array
     * @param newEntry: the entry we want to add
     * @return: the flashcard that we just added
     */
    @Override
    public FlashCard add(FlashCard newEntry) {
        checkInitialization();
        checkCapacity();
        correctCards[numberOfEntries] = newEntry;
        return newEntry;
    } //end of add method

    /**
     * This method will calculate the average number of attempts per flashcard
     * @return: the average number of attempts
     */
    @Override
    public double calculateAverageAttempts() {
        int sumOfAttempts = 0;
        for(FlashCard card : correctCards){
            sumOfAttempts += card.getAttempts();
        } //end of for
        double average = sumOfAttempts / numberOfEntries;
        return average;
    } //end of calculateAverageAttempts method

    /**
     * This method will make sure that everything has been initialized properly
     */
    private void checkInitialization(){
        if(!integrityOK){
            throw new SecurityException("There was an issue initializing the array.");
        } //end of if
    } //end of checkInitialization method

    /**
     * This method will ensure that we don't go over our allowed capacity
     */
    private void checkCapacity(){
        if(numberOfEntries > correctCards.length){
            throw new SecurityException("The array was filled.");
        } //end of if
    } //end of checkCapacity method
} //end of CorrectFlashCardArray class
