import java.util.ArrayList;
import java.util.Scanner;

public abstract class FlashCard {

    protected String verb; // the verb to be conjugated
    protected String subject; // the form to be conjugated to
    private int attempts = 0; // number of attempts for each particular note card

    public String getAnswer() {
        return answer;
    }

    protected String answer; // the correct conjugation

    FlashCard(String verb, String subject) {
        this.verb = verb;
        this.subject = subject;
        conjugateVerb();
    }

    protected static VerbDictionary<String, String> conjugations = new VerbDictionary<>();

    public static FlashCard getCard(String verb, String subject, String tense) {
        if (tense.toLowerCase().equals("preterite")) return new PreteriteCard(verb, subject);
        if (tense.toLowerCase().equals("present")) return new PresentCard(verb, subject);
        if (tense.toLowerCase().equals("future")) return new FutureCard(verb, subject);
        if (tense.toLowerCase().equals("imperfect")) return new ImperfectCard(verb, subject);
        throw new IllegalArgumentException("Tense is not a valid tense.");
    }

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

    /**
     * a method to check if the verb given is irregular
     *
     * @return true if it is irregular, false if not
     */
    protected abstract boolean checkIrreg();

    /**
     * a method to conjugate irregular verbs
     *
     * @return the conjugated irregular verb
     */
    protected abstract String conjugateIrreg();

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
    }

    public void incrementAttempts() {
        attempts++;
    }
}
