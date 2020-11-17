import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class holds methods needed to run our study game
 */
public class StudyGame {

    static Scanner userAnswer = new Scanner(System.in);
    static VerbDictionary<String, String> subjectDict;
    static QueueForFlashCards<FlashCard> studyCards;
    static CorrectFlashCardArray correctCards;
    static ArrayList<String> verbs = new ArrayList<>();
    private static final int DICTIONARY_SIZE = 5;

    public StudyGame(){
        fillVerbs();
        subjectDict = new VerbDictionary<>();
        studyCards = new QueueForFlashCards<>();
        askForTense();
        correctCards = new CorrectFlashCardArray(studyCards.getSize());
        playGame();
    } //end of constructor

    /**
     * This method fills the verbs array with the verbs in the text file
     */
    public void fillVerbs(){
        String verbFile = "Verbs.txt";

        try{
            Scanner data = new Scanner(new File(verbFile));
            verbs = FlashCard.readFile(data);
        } //end of try
        catch(
                FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        } //end of catch
    } //end of fillVerbs method

    /**
     * This method will ask for the tenses the user wants to use and will then fill the queue
     */
    public static void askForTense(){
        boolean finished = false;
        System.out.println("Which tense would you like to study? Please enter one at a time. You may choose from:" +
                "\n\"Future\"" +
                "\n\"Present\"" +
                "\n\"Imperfect\"" +
                "\n\"Preterite\"");
        while(!finished){
            String tense = userAnswer.next().toLowerCase();
            switch(tense){
                case "preterite", "future", "present", "imperfect":
                    System.out.print("How many flashcards of this tense would you like?: ");
                    int amountOfCards = userAnswer.nextInt();
                    fillQueue(amountOfCards, tense);
                    break;
                case "stop":
                    finished = true;
                    break;
                default:
                    System.out.println("Invalid tense. Please try again.");
            } //end of switch
            System.out.println("Please type the next tense you would like to study, or \"stop\" to finish.");
        } //end of while
    } //end of askForTense method

    /**
     * This method will fill the queue with flashcards of the given tense
     * @param numberToFill: the amount of cards we want to add
     * @param tense the tense we want to add
     */
    public static void fillQueue(int numberToFill, String tense){
        while(numberToFill != 0){
            int randomVerb = (int)(Math.random() * verbs.size());
            int randomSubject = (int)(Math.random() * DICTIONARY_SIZE);
            String subject = "";
            switch(randomSubject){
                case 0:
                    subject = "yo";
                    break;
                case 1:
                    subject = "tu";
                    break;
                case 2:
                    subject = "usted";
                    break;
                case 3:
                    subject = "nosotros";
                    break;
                case 4:
                    subject = "ustedes";
                    break;
            } //end of switch
            FlashCard newCard = FlashCard.getCard(verbs.get(randomVerb), subject, tense);
            studyCards.enqueue(newCard);
            numberToFill--;
        } //end of while
    } //end of fillQueue method

    /**
     * This method will show the user the current tense, verb, and subject and prompt them to input
     * their answer. It will then compare their answer to the correct answer. If it's correct, we add
     * the flashcard to the correctCards array. If it's wrong, we enqueue the flashcard back into the queue.
     */
    public static void playGame(){
        instructionsMessage();
        while(!studyCards.isEmpty()){
            FlashCard currentCard = studyCards.dequeue();
            System.out.print("(" + currentCard.getTense() + "): " + currentCard.verb + ", " + currentCard.subject + ": ");
            currentCard.incrementAttempts();
            String userInput = userAnswer.next();
            if(userInput.toLowerCase().equals(currentCard.answer.toLowerCase())){
                System.out.println("Correct!");
                correctCards.add(currentCard);
            } //end of if
            else{
                System.out.println("Incorrect. The correct answer is " + currentCard.answer);
                studyCards.enqueue(currentCard);
            } //end of else
        } //end of while
        endStatistics();
    } //end of showFlashCard method

    /**
     * This method shows the instruction message upon starting the game
     */
    public static void instructionsMessage(){
        System.out.println("You will be presented with a tense, verb, and subject. You will then input your " +
                "answer. You will be notified whether it is correct or incorrect.\nOnce you finish all of the flashcards, " +
                "you will be presented with some statistics about your session. (Note: capitalization won't matter)\n");
    } //end of startGame method

    /**
     * This method shows the user their average number of attempts
     */
    public static void endStatistics(){
        double average = correctCards.calculateAverageAttempts();
        if(average == 1)
            System.out.println("You averaged " + average + " attempt per flashcard.");
        else
            System.out.println("You averaged " + average + " attempts per flashcard.");
    } //end of endStatistics method
} //end of StudyGame class
