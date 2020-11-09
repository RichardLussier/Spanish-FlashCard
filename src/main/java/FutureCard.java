/**
 * This class holds the methods needed to create a card in the future tense
 */
public class FutureCard extends FlashCard {

    FutureCard(String verb, String subject) {
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

        if (ending.equals("ar") || ending.equals("er") || ending.equals("ir")) {
            addFutureAll();
            answer = verb + conjugations.getValue(subject);
        } //end of if
        else {
            throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
        } //end of else
    } //end of conjugateVerb method

    /**
     * a method to add the correct future endings to a dictionary
     */
    private void addFutureAll() {
        conjugations.add("yo", "e");
        conjugations.add("tu", "as");
        conjugations.add("usted", "a");
        conjugations.add("nosotros", "emos");
        conjugations.add("ustedes", "an");
    } //end of addFutureAll method

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
    protected String conjugateIrreg() {
        return null;
    } //end of conjugateIrreg method
} //end of FutureCard method
