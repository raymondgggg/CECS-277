import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<Integer> populations = new ArrayList<Integer>();
        menu();
        readFile(states, populations);
        
        displayState(states, populations);
        int sum = totalPopulation(populations);
        System.out.printf("%,d\n", sum);
        
        int greaterThan = 25000000;
        populationGreater(greaterThan, states, populations);
        
    }

    public static void menu() {
        System.out.println("State Stats\n1.Display Sorted States\n2.Display Sorted Populations");
        System.out.println("3.Display Total US population\n4.Display State With Population Greater than\n6.Quit");
    }

    public static void readFile(ArrayList<String> states, ArrayList<Integer> populations) {
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
                populations.add(Integer.parseInt(line.substring(i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayState(ArrayList<String> states, ArrayList<Integer> population){
        for (int i = 0; i < states.size(); i++) {
            System.out.printf("%-25s %,10d \n", states.get(i),population.get(i));
        }
    }

    public static int totalPopulation(ArrayList<Integer> populations){
        int sum = 0;
        for(int statepop : populations){
            sum += statepop;
        }
        return sum;
    }

    public static void populationGreater(int greaterThan, ArrayList<String> states, ArrayList<Integer> populations) {
        for (int i = 0; i < states.size(); i++) {
            if (populations.get(i) > greaterThan) {
                System.out.printf("%s   %,d\n", states.get(i), populations.get(i));
            }
        }
    }

    public static void sort(ArrayList<Integer> list){
        boolean swapped = false;
        do{
            swapped = false;
            for (int i =0; i < list.size(); i++){
                if(list.get(i) > list.get(i+1)){
                    int swap = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1, swap);
                    swapped = true;
                }
            }
        }while(swapped);
    }


    
}