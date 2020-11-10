import java.util.ArrayList;
import java.util.Scanner;
/**
 * This abstract class holds methods that each card needs to hold, and defines
 * methods that will be uniform among each type of card
 */
public abstract class FlashCard {

    protected String verb; // the verb to be conjugated
    protected String subject; // the form to be conjugated to
    private int attempts = 0; // number of attempts for each particular note card

    public String getAnswer() {
        return answer;
    } //end of getAnswer method

    protected String answer; // the correct conjugation

    FlashCard(String verb, String subject) {
        this.verb = verb;
        this.subject = subject;
        conjugateVerb();
    } //end of constructor

    protected static VerbDictionary<String, String> conjugations = new VerbDictionary<>();

    /**
     * This method will create a flashcard based on the verb, subject, and tense provided as arguments
     * @param verb: the verb the flashcard will use
     * @param subject: the subject the flashcard will use
     * @param tense: the tense the flashcard will use
     * @return: the completed card
     */
    public static FlashCard getCard(String verb, String subject, String tense) {
        if (tense.toLowerCase().equals("preterite")) return new PreteriteCard(verb, subject);
        if (tense.toLowerCase().equals("present")) return new PresentCard(verb, subject);
        if (tense.toLowerCase().equals("future")) return new FutureCard(verb, subject);
        if (tense.toLowerCase().equals("imperfect")) return new ImperfectCard(verb, subject);
        throw new IllegalArgumentException("Tense is not a valid tense.");
    } //end of getCard method

    /**
     * a method to conjugate the verb
     *
     * @return string the conjugated verb
     */
    protected abstract void conjugateVerb();


    /**
     * a method to find the type of verb
     *
     * @return a string of the last two letters
     */
    protected String findEnding() {
        return verb.substring(verb.length() - 2);
    } //end of findEnding method

    protected String getStem(){
        return verb.substring(0, verb.length() - 2);
    }

    /**
     * a method to conjugate irregular verbs
     *
     * @return the conjugated irregular verb
     */
    protected abstract boolean conjugateIrreg();

    /**
     * an array list of verbs to be used
     */
    public static ArrayList<String> verbs = new ArrayList<>();

    /**
     * a method to read a text file of verbs
     * stores the verbs in the verbs array list
     *
     * @param data the scanner that will read the verbs
     */
    public static ArrayList<String> readFile(Scanner data) {
        while (data.hasNext()) {
            verbs.add(data.next().trim());
        } //end of while
        data.close();
        return verbs;
    } //end of readFile method

    public int getAttempts() {
        return attempts;
    } //end of getAttempts method

    public void incrementAttempts() {
        attempts++;
    } //end of incrementAttempts method
} //end of FlashCard abstract class
