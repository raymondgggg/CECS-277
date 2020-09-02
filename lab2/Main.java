import java.util.Scanner;

import java.lang.Character;
public class Main{
    public static void main(String[] args) {
        char [][] grid ={
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'f'}
                        };
        int bugXPosition = 0;
        int bugYPosition = 0;
        
        while (grid[9][9] == 'f'){
            displayGrid(grid, bugXPosition, bugYPosition);
            char updatedPosition = move(bugXPosition, bugYPosition);
            if(updatedPosition == 'w'){
                grid[bugYPosition][bugXPosition] = 'x';
                bugYPosition--;
            }
            else if(updatedPosition == 'a'){
                grid[bugYPosition][bugXPosition] = 'x';
                bugXPosition--;
            }
            else if (updatedPosition == 's'){
                grid[bugYPosition][bugXPosition] = 'x';
                bugYPosition++;
            }
            else if (updatedPosition == 'd'){
                grid[bugYPosition][bugXPosition] = 'x';
                bugXPosition++;
            }

        }
    }

    public static char move(int xPosition, int yPosition){
        System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
        Scanner usrInput = new Scanner(System.in);
        char charInput = usrInput.next().charAt(0);
        charInput = Character.toLowerCase(charInput); // to make sure the character is lower case for while loop comparisons

        while(charInput != 'w' || charInput != 'a' || charInput != 's' || charInput != 'd'){// go into loop at least once to check if charInput is actually valid
            if(charInput == 'w' && xPosition > 0){
                System.out.println();
                return charInput;
            }
            else if(charInput == 'a' && yPosition > 0){
                System.out.println();
                return charInput;
            }
            else if(charInput == 's' && xPosition < 9){
                System.out.println();
                return charInput;
            }
            else if (charInput == 'd' && yPosition < 9){
                System.out.println();
                return charInput;
            }
            System.out.println("\nSorry, please enter a valid character or move");
            System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
            charInput = usrInput.next().charAt(0);
        }
        return charInput;
    }

    public static void displayGrid(char grid[][], int xPosition, int yPosition){
        grid[yPosition][xPosition] = 'o';
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}