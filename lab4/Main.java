// Raymond Guevara Lozano 
// Juan Anaya

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    /** 
     * Main method where the 30x30 char array is initialized, as well as the array list of 
     * type Rect. User is prompted to enter desired number of rectangles and other methods
     * within the main class are called to append Rect objects to arraylist and modify existing
     * grid with new rectangles.
     * @param args No command line arguments used in this program
     */
    public static void main(String[] args) {
        char[][] charArray = new char[30][30]; //initialization of 30x30 grid of chars 
        ArrayList<Rect> rectArrayList = new ArrayList<Rect>(); //intialization of rect array
        char[] rectangleChars = {'O', 'X', '*', '#', '-'};

        for (int i = 0; i < charArray.length; i++){ // populate the array with the char '.'
            for (int j =0; j < charArray.length; j++){
                charArray[i][j] = '.';
            }
        }

        System.out.print("How many rectangles would you like to draw (1-5)? ");
        int recCount = getIntRange(1, 5);

        for (int i = 1; i<= recCount; i++){
            rectArrayList.add(getRect(i));
            fillRect(charArray, rectArrayList.get(i-1), rectangleChars[i-1]);
        }
        displayGrid(charArray);

    }

    
    /** 
     * Method for displaying the 30x30 grid of chars where 
     * the rectangles will eventually be put 
     * @param grid 2D Array that contains the char characters
     */
    public static void displayGrid(char grid[][]){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    /** 
     * Method for prompting user to give values that are needed 
     * to instantiate the Rect object. Uses input validation to 
     * make sure that the fields are within the rang for the 2D
     * array.
     * @param currentRect Number of current rectangle that is being instantiated
     * @return r Rectangle object made after getting fields for object from user
     */
    public static Rect getRect(int currentRect){
        System.out.print("Please enter x location of rectangle " + currentRect + " (1-30): ");
        int x = getIntRange(1, 30);
        System.out.print("\nPlease enter y location of of rectangle " + currentRect + " (1-30): ");
        int y = getIntRange(1, 30);
        System.out.print("\nPlease enter the width of rectangle " + currentRect + "(1-25): ");
        int width = getIntRange(1, 25);
        System.out.print("\nPlease enter the height of rectangle " + currentRect + " (1-25): ");
        int height = getIntRange(1, 25);

        Rect r = new Rect(x, y, width, height);
        return r;

    }

    
    /** 
     * Method for filling rectangle grid with the rectangle objects and corresponding 
     * char character  
     * @param grid 2D Array containing the char values
     * @param rectangle Object that will be used to fill grid
     * @param c Character that will be used to represent the rectangle object
     */
    public static void fillRect(char grid[][], Rect rectangle, char c){
        for (int i = 0; i<rectangle.getWidth(); i++){
            for(int j = 0; j<rectangle.getHeight(); j++){
                grid[(rectangle.getY()-1) + j][(rectangle.getX()-1) + i] = c;
            }
        }
    }

    
    /**
     * Checks if the inputted value is an integer and within the specified range
     * (ex: 1-10)
     * 
     * @param low  lower bound of the range.
     * @param high upper bound of the range.
     * @return the valid input.
     */
    public static int getIntRange(int low, int high) {
        Scanner in = new Scanner(System.in);
        int input = 0;
        boolean valid = false;
        while (!valid) {
            if (in.hasNextInt()) {
                input = in.nextInt();
                if (input <= high && input >= low) {
                    valid = true;
                } else {
                    System.out.println("Invalid Range. Enter again please: ");
                }
            } else {
                in.next(); // clear invalid string
                System.out.println("Invalid Input. Enter again please: ");
            }
        }
        return input;
    }
}


