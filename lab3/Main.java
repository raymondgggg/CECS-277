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
        
        displayState(states, population);

      

       
        
    }

    public static void menu() {
        System.out.println("State Stats\n1.Display Sorted States\n2.Display Sorted Populations");
        System.out.println("3.Display Total US population\n4.Display State With Population Greater than\n6.Quit");
    }

    public static void readFile(ArrayList<String> states, ArrayList<Integer> population) {
        File inputFile = new File("StatePops.txt");
        try {
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()){
                String line = input.nextLine();
                int i = 0;
                while(!Character.isDigit(line.charAt(i))){ //while loop to check where digit starts
                    i++;
                }
                states.add(line.substring(0,i-1));
                population.add(Integer.parseInt(line.substring(i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayState(ArrayList<String> states, ArrayList<Integer> population){
        for (int i = 0; i < states.size(); i++) {
            System.out.printf("%-25s %10d \n", states.get(i),population.get(i));
        }
    }
}