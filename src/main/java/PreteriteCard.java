/**
 * This class holds the methods needed to create a flashcard in the preterite tense
 */
public class PreteriteCard extends FlashCard {

    PreteriteCard(String verb, String subject) {
        super(verb, subject);
    } //end of constructor

    /**
     * a method to conjugate the verb
     *
     * @return string the conjugated verb
     */
    @Override
    public void conjugateVerb() {
        String ending = findEnding();
        String stem = verb.substring(0, verb.length() - 2);

        if (checkIrreg())
            conjugateIrreg();
        else if (ending.equals("ar")) {
            addPreteriteAr();
            answer = stem + conjugations.getValue(subject);
        } //end of if
        else if (ending.equals("er") || ending.equals("ir")) {
            addPreteriteErIr();
            answer = stem + conjugations.getValue(subject);
        } //end of if
        else {
            throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
        } //end of else
    } //end of conjugateVerb method

    /**
     * a method to check if the verb given is irregular
     *
     * @return true if it is irregular, false if not
     */
    @Override
    protected boolean checkIrreg() {
        return false;
    } //end of checkIrreg method

    /**
     * a method to conjugate irregular verbs
     *
     * @return the conjugated irregular verb
     */
    @Override
    protected void conjugateIrreg() {

    } //end of conjugateIrreg method

    /**
     * a method to add the correct preterite endings to a dictionary
     */
    private void addPreteriteAr() {
        conjugations.add("yo", "e");
        conjugations.add("tu", "aste");
        conjugations.add("usted", "o");
        conjugations.add("nosotros", "amos");
        conjugations.add("ustedes", "aron");
    } //end of addPreteriteAr method

    /**
     * a method to add the correct preterite endings to a dictionary
     */
    private void addPreteriteErIr() {
        conjugations.add("yo", "i");
        conjugations.add("tu", "iste");
        conjugations.add("usted", "io");
        conjugations.add("nosotros", "imos");
        conjugations.add("ustedes", "ieron");
    } //end of addPreteriteErIr method
} //end of PreteriteCard class
