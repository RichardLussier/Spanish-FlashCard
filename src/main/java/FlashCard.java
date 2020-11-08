import java.util.ArrayList;
import java.util.Scanner;

public class FlashCard {

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
        VerbDictionary<String, String> conjugations = new VerbDictionary();
        String conjugatedVerb;

        if (checkIrreg(verb, tense))
            return conjugateIrreg(verb, subject, tense);
        if (tense.toLowerCase().equals("preterite"))
        {
            if (ending.equals("ar"))
            {
                addPreteriteAr(conjugations);
                conjugatedVerb = stem + conjugations.getValue(subject);
            } //end of if
            else if (ending.equals("er") || ending.equals("ir"))
            {
                addPreteriteErIr(conjugations);
                conjugatedVerb = stem + conjugations.getValue(subject);
            } //end of if
            else{
                throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
            } //end of else
        } //end of if
        else if(tense.toLowerCase().equals("present")){
            if (ending.equals("ar"))
            {
                addPresentAr(conjugations);
                conjugatedVerb = stem + conjugations.getValue(subject);
            } //end of if
            else if (ending.equals("er") || ending.equals("ir"))
            {
                addPresentErIr(conjugations);
                conjugatedVerb = stem + conjugations.getValue(subject);
            } //end of if
            else{
                throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
            } //end of else
        } //end of else if
        else if(tense.toLowerCase().equals("future")){
            if(ending.equals("ar") || ending.equals("er") || ending.equals("ir")){
                addFutureAll(conjugations);
                conjugatedVerb = verb + conjugations.getValue(subject);
            } //end of if
            else{
                throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
            } //end of else
        } //end of else if
        else if(tense.toLowerCase().equals("imperfect")){
            if(ending.equals("ar")){
                addImperfectAr(conjugations);
                conjugatedVerb = stem + conjugations.getValue(subject);
            } //end of if
            else if(ending.equals("er") || ending.equals("ir")){
                addImperfectErIr(conjugations);
                conjugatedVerb = stem + conjugations.getValue(subject);
            } //end of else if
            else{
                throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
            } //end of else
        } //end of else if
        else{
            throw new IllegalArgumentException(tense + " is an invalid tense.");
        } //end of else
        return conjugatedVerb;
    } //end of conjugateVerb method

    /**
     * a method to add the correct preterite endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addPreteriteAr(VerbDictionary conjugations)
    {
        conjugations.add("yo", "e");
        conjugations.add("tu", "aste");
        conjugations.add("usted", "o");
        conjugations.add("nosotros", "amos");
        conjugations.add("ustedes", "aron");
    } //end of addPreteriteAr method

    /**
     * a method to add the correct preterite endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addPreteriteErIr(VerbDictionary conjugations)
    {
        conjugations.add("yo", "i");
        conjugations.add("tu", "iste");
        conjugations.add("usted", "io");
        conjugations.add("nosotros", "imos");
        conjugations.add("ustedes", "ieron");
    } //end of addPreteriteErIr method

    /**
     * a method to add the correct present endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addPresentAr(VerbDictionary conjugations){
        conjugations.add("yo", "o");
        conjugations.add("tu", "as");
        conjugations.add("usted", "a");
        conjugations.add("nosotros", "amos");
        conjugations.add("ustedes", "an");
    } //end of addPresentAr method

    /**
     * a method to add the correct present endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addPresentErIr(VerbDictionary conjugations){
        conjugations.add("yo", "o");
        conjugations.add("tu", "es");
        conjugations.add("usted", "e");
        conjugations.add("nosotros", "emos");
        conjugations.add("ustedes", "en");
    } //end of addPresentErIr method

    /**
     * a method to add the correct future endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addFutureAll(VerbDictionary conjugations){
        conjugations.add("yo", "e");
        conjugations.add("tu", "as");
        conjugations.add("usted", "a");
        conjugations.add("nosotros", "emos");
        conjugations.add("ustedes", "an");
    } //end of addFutureAll method

    /**
     * a method to add the correct imperfect endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addImperfectAr(VerbDictionary conjugations){
        conjugations.add("yo", "aba");
        conjugations.add("tu", "abas");
        conjugations.add("usted", "aba");
        conjugations.add("nosotros", "abamos");
        conjugations.add("ustedes", "aban");
    } //end of addImperfectAr method

    /**
     * a method to add the correct imperfect endings to a dictionary
     * @param conjugations the dictionary to be added to
     */
    private void addImperfectErIr(VerbDictionary conjugations){
        conjugations.add("yo", "ia");
        conjugations.add("tu", "ias");
        conjugations.add("usted", "ia");
        conjugations.add("nosotros", "iamos");
        conjugations.add("ustedes", "ian");
    } //end of addImperfectAr method

    /**
     * a method to find the type of verb
     * @param verb the verb to be conjugated
     * @return a string of the last two letters
     */
    private String findEnding(String verb)
    {
        return verb.substring(verb.length()-2);
    } //end of findEnding method

    /**
     * a method to check if the verb given is irregular
     * @param verb the verb being checked
     * @param tense the tense to be conjugated to
     * @return true if it is irregular, false if not
     */
    private boolean checkIrreg(String verb, String tense)
    {
        return false; // will check for irregulars
    } //end of checkIrreg method

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
    } //end of conjugateIrreg method

    /**
     * an array list of verbs to be used
     */
    public ArrayList<String> verbs = new ArrayList<>();

    /**
     * a method to read a text file of verbs
     * stores the verbs in the verbs array list
     * @param data the scanner that will read the verbs
     */
    public ArrayList readFile(Scanner data)
    {
        while (data.hasNext())
        {
            verbs.add(data.next().trim());
        } //end of while
        data.close();
        return verbs;
    } //end of readFile method
}
