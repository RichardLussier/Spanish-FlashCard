import java.util.Scanner;

/**
 * This class holds methods needed to run our study game
 */
public class StudyGame {

    Scanner userAnswer = new Scanner(System.in);
    private static final int DEFAULT_SIZE = 10;
    VerbDictionary<String, String> subjectDict;
    QueueForFlashCards<FlashCard> studyCards;
    CorrectFlashCardArray correctCards;
    public StudyGame(){
        this(DEFAULT_SIZE);
    } //end of constructor

    public StudyGame(int studySize){
        subjectDict = new VerbDictionary<>();
        studyCards = new QueueForFlashCards<>();
        correctCards = new CorrectFlashCardArray(studySize);
    } //end of constructor

    public void askForTense(){
        System.out.println("Which tense would you like to study? Please enter one at a time. You may choose from:" +
                "\n\"Future\"" +
                "\n\"Present\"" +
                "\n\"Imperfect\"" +
                "\n\"Preterite\"");
        String userTense = userAnswer.next();
        switch(userTense.toLowerCase()){
            case "preterite":
        }



    } //end of askForTense method

    public void fillQueue(){

    } //end of fillQueue method

    /**
     * This method will show the user the current tense, verb, and subject and prompt them to input
     * their answer. It will then compare their answer to the correct answer. If it's correct, we add
     * the flashcard to the correctCards array. If it's wrong, we enqueue the flashcard back into the queue.
     */
    public void showFlashCards(){
        instructionsMessage();
        while(!studyCards.isEmpty()){
            FlashCard currentCard = studyCards.dequeue();
            System.out.print("(" + currentCard.getTense() + "): " + currentCard.verb + ", " + currentCard.subject + ": ");
            currentCard.incrementAttempts();
            String userInput = userAnswer.nextLine();
            if(userInput.toLowerCase().equals(currentCard.answer)){
                System.out.println("Correct!");
                correctCards.add(currentCard);
            } //end of if
            else{
                System.out.println("Incorrect");
                studyCards.enqueue(currentCard);
            } //end of else
        } //end of while
        endStatistics();
    } //end of showFlashCard method

    public void instructionsMessage(){
        System.out.println("You will be presented with a tense, verb, and subject. You will then input your" +
                "answer. You will be notified whether it is correct or incorrect. Once you finish all of the flashcards, " +
                "you will be presented with some statistics about your session. (Note: capitalization won't matter)\n");
    } //end of startGame method

    public void endStatistics(){
        System.out.println("You averaged " + correctCards.calculateAverageAttempts() + " attempts per flashcard.");
    } //end of endStatistics method
} //end of StudyGame class
