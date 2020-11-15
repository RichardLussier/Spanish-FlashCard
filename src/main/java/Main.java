import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
        }
        else if(tense == 1){
            verbTense = "future";
        }
        else if(tense == 2){
            verbTense = "preterite";
        }
        else if(tense == 3){
            verbTense = "imperfect";
        }

        int subject = (int)((Math.random() * 5));
        String subjectVerb = "";
        if(subject == 0){
            subjectVerb = "yo";
        }
        else if(subject == 1){
            subjectVerb = "tu";
        }
        else if(subject == 2){
            subjectVerb = "usted";
        }
        else if(subject == 3){
            subjectVerb = "nosotros";
        }
        else if(subject == 4){
            subjectVerb = "ustedes";
        }

        FlashCard test = FlashCard.getCard(verbs.get(index), subjectVerb, verbTense);
        System.out.println(verbTense);
        System.out.println(subjectVerb);
        System.out.println(test.getAnswer());
    } //end of main method
} //end of Main class
