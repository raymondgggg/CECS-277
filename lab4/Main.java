import java.util.ArrayList;

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


    }

    public static void displayGrid(char grid[][]){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Rect(int usrRectCount){
        
    }

}


