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
     */
    @Override
    public void conjugateVerb() {
        String ending = findEnding();
        if (!conjugateIrreg()) {
            if (ending.equals("ar") || ending.equals("er") || ending.equals("ir")) {
                addFutureAll();
                answer = verb + conjugations.getValue(subject);
            } //end of if
            else {
                throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
            } //end of else
        } //end of if
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
     * a method to conjugate irregular verbs
     *
     * @return true if the verb has been conjugated
     * false if otherwise
     */
    @Override
    protected boolean conjugateIrreg() {
        addFutureAll();
        switch (verb) {
            case "decir":
                answer = "dir" + conjugations.getValue(subject);
                break;
            case "haber":
                answer = "habr" + conjugations.getValue(subject);
                break;
            case "hacer":
                answer = "har" + conjugations.getValue(subject);
                break;
            case "poder":
                answer = "podr" + conjugations.getValue(subject);
                break;
            case "poner":
                answer = "pondr" + conjugations.getValue(subject);
                break;
            case "saber":
                answer = "sabr" + conjugations.getValue(subject);
                break;
            case "salir":
                answer = "saldr" + conjugations.getValue(subject);
                break;
            case "tener":
                answer = "tendr" + conjugations.getValue(subject);
                break;
            case "venir":
                answer = "vendr" + conjugations.getValue(subject);
                break;
            case "querer":
                answer = "querr" + conjugations.getValue(subject);
                break;
            default:
                return false;
        }
        return true;
    } //end of conjugateIrreg method

    /**
     * This method will return "Future", which is the tense of this card
     * @return: "Future"
     */
    public String getTense(){
        return "Future";
    } //end of getTense method
} //end of FutureCard method
