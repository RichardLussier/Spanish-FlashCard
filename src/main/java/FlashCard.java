import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public abstract class FlashCard {

    String verb; // the verb to be conjugated
    String subject; // the form to be conjugated to
    String tense; // the tense to be conjugated to
    int numberOfAttempts = 0; // number of attempts for
    // each particular note card
    String answer; // the correct conjugation

    /**
     * a method to conjugate the verb
     * @param verb the verb to be conjugated
     * @param subject the form to conjugate to
     * @param tense the tense to be conjugated to
     * @return string the conjugated verb
     */
    public String conjugateVerb(String verb, String subject, String tense)
    {
        String ending = findEnding(verb);
        String stem = verb.substring(0, verb.length() -2);
        Dictionary<String, String> conjugations = new Dictionary<String, String>() {};

        if (checkIrreg(verb, tense))
            return conjugateIrreg(verb, subject, tense);
        if (tense.toLowerCase().equals("preterite"))
        {
            if (ending.equals("ar"))
            {
                addPreteriteAr(conjugations);
                return stem + conjugations.get(subject);
            }
            if (ending.equals("er") || ending.equals("ir"))
            {
                addPreteriteErIr(conjugations);
                return stem + conjugations.get(subject);
            }
        }
    }

    /**
     * a method to add the correct preterite endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addPreteriteAr(Dictionary conjugations)
    {
        conjugations.put("yo", "e");
        conjugations.put("tu", "aste");
        conjugations.put("usted", "o");
        conjugations.put("nosotros", "amos");
        conjugations.put("ustedes", "aron");
    }

    /**
     * a method to add the correct preterite endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addPreteriteErIr(Dictionary conjugations)
    {
        conjugations.put("yo", "i");
        conjugations.put("tu", "iste");
        conjugations.put("usted", "io");
        conjugations.put("nosotros", "emos");
        conjugations.put("ustedes", "ieron");
    }

    /**
     * a method to find the type of verb
     * @param verb the verb to be conjugated
     * @return a string of the last two letters
     */
    private String findEnding(String verb)
    {
        return verb.substring(verb.length()-2);
    }

    /**
     * a method to check if the verb given is irregular
     * @param verb the verb being checked
     * @param tense the tense to be conjugated to
     * @return true if it is irregular, false if not
     */
    private boolean checkIrreg(String verb, String tense)
    {
        return true; // will check for irregulars
    }

    /**
     * a method to conjugate irregular verbs
     * @param verb the irregular verb to be conjugated
     * @param subject the form to be conjugated to
     * @param tense the tense to be conjugated to
     * @return the conjugated irregular verb
     */
    private String conjugateIrreg(String verb, String subject, String tense)
    {
        return "";
    }

    /**
     * an array list of verbs to be used
     */
    ArrayList<String> verbs = new ArrayList<>();

    /**
     * a method to read a text file of verbs
     * stores the verbs in the verbs array list
     * @param data the scanner that will read the verbs
     */
    public void readFile(Scanner data)
    {
        while (data.hasNext())
        {
            verbs.add(data.next().trim());
        }
        data.close();
    }
}
