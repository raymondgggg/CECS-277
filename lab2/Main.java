// Raymond Guevara
//Johnerson Li
//CECS 277-Sec 10 Tu

import java.util.Scanner;
import java.lang.Character;

public class Main {
    
    /** 
     * Uses no command line arguments for this program. Intializes 2D game grid
     * and uses while loop to repeatedly call the move() and displayGrid() methods
     * to get new user position and update and display grid until user
     * reaches position (9,9) of game grid.
     * @param args
     */
    public static void main(String[] args) {
        char[][] grid = {
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                            { '.', '.', '.', '.', '.', '.', '.', '.', '.', 'f' } 
                        };

        int bugXPosition = 0;
        int bugYPosition = 0;

        while (!(bugXPosition == 10 && bugYPosition == 10)) {
            if (bugXPosition == 9 && bugYPosition == 9) { // update grid when we are in position (9,9)
                grid[bugYPosition][bugXPosition] = 'x';
                grid[9][9] = 'o';
                displayGrid(grid, bugXPosition, bugYPosition);
                bugXPosition++;
                bugYPosition++;
            } 
            else {
                displayGrid(grid, bugXPosition, bugYPosition);
                char updatedPosition = move(bugXPosition, bugYPosition);
                if (updatedPosition == 'w') {
                    grid[bugYPosition][bugXPosition] = 'x';
                    bugYPosition--;
                } else if (updatedPosition == 'a') {
                    grid[bugYPosition][bugXPosition] = 'x';
                    bugXPosition--;
                    
                } else if (updatedPosition == 's') {
                    grid[bugYPosition][bugXPosition] = 'x';
                    bugYPosition++;
                } else if (updatedPosition == 'd') {
                    grid[bugYPosition][bugXPosition] = 'x';
                    bugXPosition++;
                }
            }
        }
        System.out.println("Congrats! You have made it to the end and will have good fortune for the rest of your life!!!! XD");
    }
    
    /** 
     * Takes in user's current positon as well as prompts user for next move.
     * Verifies move is legal then returns char value of next move to be used to 
     * update the grid respectively in main() method.
     * @param xPosition
     * @param yPosition
     * @return char
     */
    public static char move(int xPosition, int yPosition) {
        System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
        Scanner usrInput = new Scanner(System.in);
        char charInput = usrInput.next().charAt(0);
        charInput = Character.toLowerCase(charInput); // to make sure the character is lower case for while loop

        while (charInput != 'w' || charInput != 'a' || charInput != 's' || charInput != 'd') { //validation of char inputted
            if (charInput == 'w' && yPosition > 0) {
                System.out.println();
                return charInput;
            } else if (charInput == 'a' && xPosition > 0) {
                System.out.println();
                return charInput;
            } else if (charInput == 's' && yPosition < 9) {
                System.out.println();
                return charInput;
            } else if (charInput == 'd' && xPosition < 9) {
                System.out.println();
                return charInput;
            }
            //conditions if user puts invalid char or pick invalid position
            System.out.println("\nSorry, please enter a valid character or move");
            System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
            charInput = usrInput.next().charAt(0);
        }
        return charInput;
    }

    /** 
     * Takes in grid and new position of user to update and display
     * the grid with 'o' according to the new position the user chose in 
     * move() method.
     * @param grid[][]
     * @param xPosition
     * @param yPosition
     */
    public static void displayGrid(char grid[][], int xPosition, int yPosition) {
        grid[yPosition][xPosition] = 'o'; // positions are flipped due to how 2D arrays work
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}