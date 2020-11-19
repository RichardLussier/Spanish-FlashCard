import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This method was used early on in the project in order to test
 * the methods before client or the JUnit tests were created
 */
public class Main {

    public static void main(String[] args) {

        String verbFile = "Verbs.txt";
        ArrayList<String> verbs = new ArrayList<>();

        try{
            Scanner data = new Scanner(new File(verbFile));
            verbs = FlashCard.readFile(data);
        } //end of try
        catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        } //end of catch
        String verbTense = "";

        int index = (int)(Math.random() * verbs.size());
        int tense = (int)((Math.random() * 4));
        if(tense == 0){
            verbTense = "present";
        } //end of if
        else if(tense == 1){
            verbTense = "future";
        } //end of else if
        else if(tense == 2){
            verbTense = "preterite";
        } //end of else if
        else if(tense == 3){
            verbTense = "imperfect";
        } //end of else if

        int subject = (int)((Math.random() * 5));
        String subjectVerb = "";
        if(subject == 0){
            subjectVerb = "yo";
        } //end of if
        else if(subject == 1){
            subjectVerb = "tu";
        } //end of else if
        else if(subject == 2){
            subjectVerb = "usted";
        } //end of else if
        else if(subject == 3){
            subjectVerb = "nosotros";
        } //end of else if
        else if(subject == 4){
            subjectVerb = "ustedes";
        } //end of else if

        FlashCard test = FlashCard.getCard(verbs.get(index), subjectVerb, verbTense);
        System.out.println(verbTense);
        System.out.println(subjectVerb);
        System.out.println(test.getAnswer());
    } //end of main method
} //end of Main class
