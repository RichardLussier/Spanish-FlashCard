public class PresentCard extends FlashCard {

    PresentCard(String verb, String subject) {
        super(verb, subject);
    }

    /**
     * a method to conjugate the verb
     *
     * @return string the conjugated verb
     */
    @Override
    public void conjugateVerb() {
        String ending = findEnding();
        String stem = verb.substring(0, verb.length() - 2);
        if (ending.equals("ar")) {
            addPresentAr();
            answer = stem + conjugations.getValue(subject);
        } //end of if
        else if (ending.equals("er") || ending.equals("ir")) {
            addPresentErIr();
            answer = stem + conjugations.getValue(subject);
        } //end of if
        else {
            throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
        } //end of else
    }

    /**
     * a method to add the correct present endings to a dictionary
     */
    private void addPresentAr() {
        conjugations.add("yo", "o");
        conjugations.add("tu", "as");
        conjugations.add("usted", "a");
        conjugations.add("nosotros", "amos");
        conjugations.add("ustedes", "an");
    } //end of addPresentAr method

    /**
     * a method to add the correct present endings to a dictionary
     */
    private void addPresentErIr() {
        conjugations.add("yo", "o");
        conjugations.add("tu", "es");
        conjugations.add("usted", "e");
        conjugations.add("nosotros", "emos");
        conjugations.add("ustedes", "en");
    } //end of addPresentErIr method

    /**
     * a method to check if the verb given is irregular
     *
     * @return true if it is irregular, false if not
     */
    @Override
    protected boolean checkIrreg() {
        return false;
    }

    /**
     * a method to conjugate irregular verbs
     *
     * @return the conjugated irregular verb
     */
    @Override
    protected String conjugateIrreg() {
        return null;
    }
}
