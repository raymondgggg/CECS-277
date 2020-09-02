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
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        };
        int bugXPosition = 0;
        int bugYPosition = 0;
    }

    public static char menu(int xPosition, int yPosition){
        System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
        Scanner usrInput = new Scanner(System.in);
        char charInput = usrInput.next().charAt(0);
        charInput = Character.toLowerCase(charInput); // to make sure the character is lower case for while loop comparisons

        while(charInput != 'w' || charInput != 'a' || charInput != 's' || charInput != 'd'){// go into loop at least once to check if charInput is actually valid
            if(charInput == 'w' && xPosition > 0){
                usrInput.close();
                return charInput;
            }
            else if(charInput == 'a' && yPosition > 0){
                usrInput.close();
                return charInput;
            }
            else if(charInput == 's' && xPosition < 9){
                usrInput.close();
                return charInput;
            }
            else if (charInput == 'd' && yPosition < 9){
                usrInput.close();
                return charInput;
            }
            System.out.println("\nSorry, please enter a valid character or move");
            System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
            charInput = usrInput.next().charAt(0);
        }
        usrInput.close();
        return charInput;
    }

    
}