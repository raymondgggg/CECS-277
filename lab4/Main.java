import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] charArray = new char[30][30]; //initialization of 30x30 grid of chars 
        ArrayList<Rect> rectArrayList = new ArrayList<Rect>(); //intialization of rect array
        char[] rectangleChars = {'O', 'X', '*', '#', '-'};

        for (int i = 0; i < charArray.length; i++){ // populate the array with the char '.'
            for (int j =0; j < charArray.length; j++){
                charArray[i][j] = '.';
            }
        }

        displayGrid(charArray);
        rectArrayList.add(getRect(1));
        fillRect(charArray, rectArrayList.get(0), rectangleChars[0]);
        displayGrid(charArray);

    }

    public static void displayGrid(char grid[][]){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Rect getRect(int currentRect){
        System.out.print("Please enter x location of rectangle " + currentRect + " (1-30): ");
        int x = getIntRange(1, 30);
        System.out.print("\nPlease enter y location of of rectangle " + currentRect + " (1-30): ");
        int y = getIntRange(1, 30);
        System.out.print("\nPlease enter the width of rectangel " + currentRect + "(1-25): ");
        int width = getIntRange(1, 25);
        System.out.print("\nPlease enter the height of rectangle " + currentRect + " (1-25): ");
        int height = getIntRange(1, 25);

        Rect r = new Rect(x, y, width, height);
        return r;

    }

    public static void fillRect(char grid[][], Rect rectangle, char c){
        for (int i = 0; i<rectangle.getWidth(); i++){
            for(int j = 0; j<rectangle.getHeight(); j++){
                grid[(rectangle.getY()-1) + j][(rectangle.getX()-1) + i] = c;
            }
        }
    }

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


