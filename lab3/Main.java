import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    /** 
     * Main method for the program, where the Arraylists are intiailized an user is prompted 
     * to input the different options to see the stats for the state populations
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<Integer> populations = new ArrayList<Integer>();

        Scanner usrInput = new Scanner(System.in);

        ArrayList<Integer> options = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int num = 0;
        readFile(states, populations);
         
        boolean repeat = true;
        while(repeat && num != options.get(4)){
            menu();
            try{
                num = usrInput.nextInt();
                while (!options.contains(num)) {
                    System.out.println("Please enter one of the above options");
                    num = usrInput.nextInt();
                }
                if (num == options.get(0)) {
                    sortAlphabetical(states, populations);
                    displayState(states, populations);
                    System.out.println();
                } else if (num == options.get(1)) {
                    sortPopulation(states, populations);
                    displayState(states, populations);
                    System.out.println();
                } else if (num == options.get(2)) {
                    System.out.printf("US Population: %,d\n", totalPopulation(populations));
                    System.out.println();
                } else if (num == options.get(3)) {
                    System.out.print("Enter Population: ");
                    int greaterThan = usrInput.nextInt();
                    populationGreater(greaterThan, states, populations);
                    System.out.println();
                } else if (num == options.get(4)){
                    repeat = false;
                    usrInput.close();
                }
            }
            catch (InputMismatchException e){
                System.out.println("please enter valid input");
                usrInput.next();
            }
        }
    }

    /**
     * method that repeatedly prints out the menu
     * 
     */
    public static void menu() {
        System.out.println("State Stats\n1.Display Sorted States\n2.Display Sorted Populations");
        System.out.println("3.Display Total US population\n4.Display State With Population Greater than\n5.Quit");
    }

    
    /** 
     * Method that reads the StatePop.txt file and puts states and 
     * populations in corresponding parallel ArrayLists for states and populations
     * @param states ArrayList that contains states and territories
     * @param populations Arraylist that contains populations of states and territories
     */
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

    
    /**
     * Method that displays the states and corresponding populatons
     * on their own line
     * @param states ArrayList that contains states and territories
     * @param populations Arraylist that contains populations of states and territories
     */
    public static void displayState(ArrayList<String> states, ArrayList<Integer> populations){
        for (int i = 0; i < states.size(); i++) {
            System.out.printf("%-25s %,10d \n", states.get(i),populations.get(i));
        }
    }

    
    /**
     * Method that takes in ArrayList for populations and returns the sum
     * of populations 
     * @param populations Arraylist that contains populations of states and
     *                    territories
     * 
     * @return int sum of the populations for all states and territories
     */
    public static int totalPopulation(ArrayList<Integer> populations){
        int sum = 0;
        for(int statepop : populations){
            sum += statepop;
        }
        return sum;
    }

    
    /**
     * Method that takes in greaterThan parameter and compares state populations 
     * with parameter, displays states and populations with values greater than 
     * greaterThan paramerter on own line
     * @param greaterThan value that user enters to find states with populations
     *                    greater than value
     * 
     * @param states      ArrayList that contains states and territories
     * 
     * @param populations Arraylist that contains populations of states and
     *                    territories
     */
    public static void populationGreater(int greaterThan, ArrayList<String> states, ArrayList<Integer> populations) {
        for (int i = 0; i < states.size(); i++) {
            if (populations.get(i) > greaterThan) {
                System.out.printf("%s   %,d\n", states.get(i), populations.get(i));
            }
        }
    }

    
    /**
     * Method that takes in states ArrayList and populations ArrayList and 
     * sorts both lists according to population (non-decreasing order)
     * @param states      ArrayList that contains states and territories
     * @param populations Arraylist that contains populations of states and territories
     */
    public static void sortPopulation(ArrayList<String> states,ArrayList<Integer> populations){
        boolean swapped = false;
        do{
            swapped = false;
            for (int i =0; i < populations.size() - 1; i++){
                if(populations.get(i) > populations.get(i+1)){
                    int popSwap = populations.get(i);
                    populations.set(i,populations.get(i+1));
                    populations.set(i+1, popSwap);

                    String stateSwap = states.get(i);
                    states.set(i, states.get(i+1));
                    states.set(i+1, stateSwap);
                    swapped = true;
                }
            }
        }while(swapped);
    }

    
    /**
     * Method that takes in states ArrayList and populations ArrayList and 
     * sorts both lists according to alphabetical order
     * @param states      ArrayList that contains states and territories
     * @param populations Arraylist that contains populations of states and
     *                    territories
     */
    public static void sortAlphabetical(ArrayList<String> states, ArrayList<Integer> populations){
        boolean swapped = false;
        do{
            swapped = false;
            for (int i = 0; i < states.size() - 1; i++){
                if(states.get(i).compareTo(states.get(i+1)) > 0){
                    int popSwap = populations.get(i);
                    populations.set(i, populations.get(i + 1));
                    populations.set(i + 1, popSwap);

                    String stateSwap = states.get(i);
                    states.set(i, states.get(i + 1));
                    states.set(i + 1, stateSwap);
                    swapped = true;
                }
            }
        }while(swapped);
    }
}