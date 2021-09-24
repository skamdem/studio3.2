import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kamdem
 */
public class MainClass {
    static char[] charactersInString;
    static HashMap<Character, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String myString = "";  // Read user input

        while (!myString.equals("0") &&
                !myString.equals("1") &&
                !myString.equals("2")){
            System.out.println("Enter a choice as follows:");
            System.out.println("0: Go ahead with the default string");
            System.out.println("1: Read from keyboard");
            System.out.println("2: Read from a file");
            myString = scanner.nextLine();  // Read user input
            System.out.println("you typed: "+myString);
        }

        switch (myString) {
            case "0": myString = runWithDefaultString();
                break;
            case "1":  myString = runReadFromKeyboard();
                break;
            case "2":  myString = runReadFromFile();
                break;
            default:
                break;
        }

        myString = myString.replaceAll("[^a-zA-Z]", "");
        charactersInString = myString.toCharArray(); // convert it

        for (char c : charactersInString){
            hashMap.merge(Character.toLowerCase(c), 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> c : hashMap.entrySet()){
            System.out.println(c.getKey() +" "+ c.getValue());
        }
        scanner.close();
    }

    static String runWithDefaultString() {
        return "If the product of two terms is zero then common sense says at least one of the two terms has to be zero to start with. So if you move all the terms over to one side, you can put the quadratics into a form that can be factored allowing that side of the equation to equal zero. Once you’ve done that, it’s pretty straightforward from there.";
    }
    static String runReadFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text");
        return scanner.nextLine();  // Read user input
    }

    static String runReadFromFile() {
        String myString = "";
        String path ="C:\\Documents\\In the USA\\4-USA Jobs\\TA @ Philadelphia\\UNIT 2\\Some studio\\src";
        path += "\\my_file.txt";
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                myString += sc.next();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  myString;
    }
}
