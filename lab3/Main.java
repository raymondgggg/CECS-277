import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<Integer> population = new ArrayList<Integer>();
        menu();
        readFile(states, population);
    }

    public static void menu() {
        System.out.println("State Stats\n1.Display Sorted States\n2.Display Sorted Populations");
        System.out.println("3.Display Total US population\n4.Display State With Population Greater than\n6.Quit");
    }

    public static void readFile(ArrayList<String> states, ArrayList<Integer> population) {
        File inputFile = new File("StatePops.txt");
        try {
            Scanner input = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}