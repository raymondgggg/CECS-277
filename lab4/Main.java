import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] charArray = new char[30][30]; //initialization of 30x30 grid of chars 
        ArrayList<Rect> rectArrayList = new ArrayList<Rect>(); //intialization of rect array

        for (int i = 0; i < charArray.length; i++){ // populate the array with the char '.'
            for (int j =0; j < charArray.length; j++){
                charArray[i][j] = '.';
            }
        }

        displayGrid(charArray);
        int x = getRect(2);
        System.out.println(x);


    }

    public static void displayGrid(char grid[][]){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getRect(int currentRect){
        System.out.print("Please enter x location of rectangle " + currentRect + " (1-30): ");
        int x = getIntRange(1, 30);

        Rect r = new Rect(1, 2, 3, 4);
        return x;

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
                    System.out.println("Invalid Range.");
                }
            } else {
                in.next(); // clear invalid string
                System.out.println("Invalid Input.");
            }
        }
        return input;
    }

}


