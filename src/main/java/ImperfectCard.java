/**
 * This class holds the methods needed to create a card in the imperfect tense
 */
public class ImperfectCard extends FlashCard {

    ImperfectCard(String verb, String subject) {
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
            addImperfectAr();
            answer = stem + conjugations.getValue(subject);
        } //end of else if
        else if (ending.equals("er") || ending.equals("ir")) {
            addImperfectErIr();
            answer = stem + conjugations.getValue(subject);
        } //end of else if
        else {
            throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
        } //end of else
    } //end of conjugateVerb method

    /**
     * a method to add the correct imperfect endings to a dictionary
     */
    private void addImperfectAr() {
        conjugations.add("yo", "aba");
        conjugations.add("tu", "abas");
        conjugations.add("usted", "aba");
        conjugations.add("nosotros", "abamos");
        conjugations.add("ustedes", "aban");
    } //end of addImperfectAr method

    /**
     * a method to add the correct imperfect endings to a dictionary
     */
    private void addImperfectErIr() {
        conjugations.add("yo", "ia");
        conjugations.add("tu", "ias");
        conjugations.add("usted", "ia");
        conjugations.add("nosotros", "iamos");
        conjugations.add("ustedes", "ian");
    } //end of addImperfectAr method


    /**
     * a method to check if the verb given is irregular
     *
     * @return true if it is irregular, false if not
     */
    @Override
    protected boolean checkIrreg() {
        if (verb.equals("ver") || verb.equals("ser") || verb.equals("ir"))
            return true;
        else
            return false;
    } //end of checkIrreg method

    /**
     * a method to conjugate irregular verbs
     *
     * @return the conjugated irregular verb
     */
    @Override
    protected void conjugateIrreg() {
        if (verb.equals("ver"))
        {
            conjugations.add("yo", "veia");
            conjugations.add("tu", "veias");
            conjugations.add("usted", "veia");
            conjugations.add("nosotros", "veiamos");
            conjugations.add("ustedes", "veian");
            answer = conjugations.getValue(subject);
        } // end if
        else if (verb.equals("ser"))
        {
            conjugations.add("yo", "era");
            conjugations.add("tu", "eras");
            conjugations.add("usted", "era");
            conjugations.add("nosotros", "eramos");
            conjugations.add("ustedes", "eran");
            answer = conjugations.getValue(subject);
        } // end else if
        else if (verb.equals("ir"))
        {
            conjugations.add("yo", "iba");
            conjugations.add("tu", "ibas");
            conjugations.add("usted", "iba");
            conjugations.add("nosotros", "ibamos");
            conjugations.add("ustedes", "iban");
            answer = conjugations.getValue(subject);
        } // end else if
    } //end of conjugateIrreg method
} //end of ImperfectCard class
