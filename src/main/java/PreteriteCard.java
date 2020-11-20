import java.util.List;

/**
 * This class holds the methods needed to create a flashcard in the preterite tense
 */
public class PreteriteCard extends FlashCard {

    PreteriteCard(String verb, String subject) {
        super(verb, subject);
    } //end of constructor

    /**
     * a method to conjugate the verb
     */
    @Override
    public void conjugateVerb() {
        String ending = findEnding();

        if (!conjugateIrreg()) { //Only execute the rest of
                                // the code if the word hasn't already been conjugated
            if (ending.equals("ar")) {
                addPreteriteAr();
                answer = getStem() + conjugations.getValue(subject);
            } //end of if
            else if (ending.equals("er") || ending.equals("ir")) {
                addPreteriteErIr();
                answer = getStem() + conjugations.getValue(subject);
            } //end of if
            else {
                throw new IllegalArgumentException(verb + " doesn't end of ar, er, or ir.");
            } //end of else
        } //end of if
    } //end of conjugateVerb method

    /**
     * a method to conjugate irregular verbs
     *
     * @return true if the verb has been conjugated
     * false if otherwise
     */
    @Override
    protected boolean conjugateIrreg() {
        if (conjugateStemIrreg()) return true; //Do nothing if the verb has already
                                            // been conjugated with the complete irregulars
        VerbDictionary<String, String> iregRoots = new VerbDictionary<>(); //Dictionary of irregular verbs
        iregRoots.add("poder", "pud");
        iregRoots.add("querer", "quis");
        iregRoots.add("poner", "pus");
        iregRoots.add("hacer", "hic");
        iregRoots.add("tener", "tuv");
        iregRoots.add("ander", "anduv");
        iregRoots.add("saber", "sup");
        iregRoots.add("venir", "vin");
        iregRoots.add("haber", "hub");
        iregRoots.add("caber", "cup");
        iregRoots.add("estar", "estuv");

        if (iregRoots.getValue(verb.toLowerCase()) != null ||
                (verb.length() > 3 && verb.endsWith("ucir"))) { //All of the listed verbs and verbs ending in
                                                            // "ucir" have a separate set of irregular endings
            conjugations.add("yo", "e"); //Irregular set of endings
            conjugations.add("tu", "iste");
            conjugations.add("usted", "o");
            conjugations.add("nosotros", "imos");
            conjugations.add("ustedes", "ieron");
            if (verb.length() > 3 && verb.endsWith("ucir")) {  //"ucir" verbs have a seperate set of endings
                answer = verb.substring(0, verb.length() - 3) + "j" + conjugations.getValue(subject);
                return true;
            } //end of if
            if (iregRoots.getValue(verb.toLowerCase()) != null) {
                answer = iregRoots.getValue(verb.toLowerCase()) +
                        conjugations.getValue(subject); //Replace the stem with the value paired with the key
                return true;
            } //end of if
        } //end of if
        if (!verb.endsWith("ar")) {
            String ending = verb.substring(verb.length() - 3, verb.length() - 2);
            if ("aeiou".contains(ending)) { //
                conjugations.add("yo", "i"); // If the words ends with a vowel, add y to to usted and ustedes
                conjugations.add("tu", "iste");
                conjugations.add("usted", "yo");
                conjugations.add("nosotros", "imos");
                conjugations.add("ustedes", "yeron");
                answer = getStem() + conjugations.getValue(subject); //The original stem but with added y
                return true;
            } //end of if
        } //end of if
        return false;
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

    /**
     * This method is used to conjugate irregular stem-changing verbs
     *
     * @return true if the verb has been conjugated
     * false if otherwise
     */
    private boolean conjugateStemIrreg() {
        switch (verb.toLowerCase()) {
            case "ir": //ir and ser have the same preterite conjugations
            case "ser":
                conjugations.add("yo", "fui");
                conjugations.add("tu", "fuiste");
                conjugations.add("usted", "fue");
                conjugations.add("nosotros", "fuimos");
                conjugations.add("ustedes", "fueron");
                answer = conjugations.getValue(subject);
                break;
            case "dar":
                conjugations.add("yo", "di");
                conjugations.add("tu", "diste");
                conjugations.add("usted", "dio");
                conjugations.add("nosotros", "dimos");
                conjugations.add("ustedes", "dieron");
                answer = conjugations.getValue(subject);
                break;
            case "ver":
                conjugations.add("yo", "vi");
                conjugations.add("tu", "viste");
                conjugations.add("usted", "vio");
                conjugations.add("nosotros", "vimos");
                conjugations.add("ustedes", "vieron");
                answer = conjugations.getValue(subject);
                break;
            case "reir":
                conjugations.add("yo", "rei");
                conjugations.add("tu", "reiste");
                conjugations.add("usted", "rio");
                conjugations.add("nosotros", "reimos");
                conjugations.add("ustedes", "rieron");
                answer = conjugations.getValue(subject);
                break;
            case "decir":
                conjugations.add("yo", "dije");
                conjugations.add("tu", "dijiste");
                conjugations.add("usted", "dijo");
                conjugations.add("nosotros", "dijimos");
                conjugations.add("ustedes", "dijeron");
                answer = conjugations.getValue(subject);
                break;
            case "traer":
                conjugations.add("yo", "traje");
                conjugations.add("tu", "trajiste");
                conjugations.add("usted", "trajo");
                conjugations.add("nosotros", "trajimos");
                conjugations.add("ustedes", "trajeron");
                answer = conjugations.getValue(subject);
                break;
            default:
                return false;
        } // end switch
        return true;
    } // end conjugateStemIrreg

    /**
     * this method will return the stem of car-gar-zar verbs and will fix e-to-i verbs
     *
     * @return: the correct conjugated stem (no root yet)
     */
    protected String getStem() {
        if (findEnding().equals("ir") && (subject.equals("usted") || subject.equals("ustedes"))) { //The stem may change
                                                                                            // with certain ir verbs
                                                                                            // only in usted or ustedes
                                                                                            // subjects
            if (verb.toLowerCase().equals("morir") || verb.toLowerCase().equals("dormir")) //Replace all o's with u's
                return super.getStem().replaceAll("o", "u");

            if (List.of("pedir", "decir", "seguir", "servir", "competir", "elegir",
                    "cerregir", "vestir", "freir", "gemir", "repetir", "preferir",
                    "venir", "mentir", "hervir", "sentir").contains(verb.toLowerCase())) //In these verbs replace the
                                                                                        // last e with i
                for (int i = verb.length() - 1; i > 0; i--) {
                    if (verb.charAt(i) == 'e')
                        return verb.substring(0, i) + "i" + verb.substring(i + 1, verb.length() - 2);
                } // end of for
        } //end if

        if (subject.equals("yo")) { //Verbs that end in car, gar, or zar will change their endings if the subject is yo
            if (verb.length() < 3) return verb;
            String last3 = verb.substring(verb.length() - 3); //The ending of the verbs
            String stem3 = verb.substring(0, verb.length() - 3); //The original verb without the ending
            switch (last3) {
                case "car":
                    return stem3 + "qu";
                case "gar":
                    return stem3 + "gu";
                case "zar":
                    return stem3 + "c";
            } //end switch
        } //end if
        return super.getStem(); //If there are no irregularities, return the verb without the ending
    } //end of getStem method


    /**
     * This method will return "Preterite", which is the tense of this card
     *
     * @return: "Preterite"
     */
    public String getTense() {
        return "Preterite";
    } //end of getTense method
} //end of PreteriteCard class
