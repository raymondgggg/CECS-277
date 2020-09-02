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

    public static char menu(){
        System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
        Scanner usrInput = new Scanner(System.in);
        char charInput = usrInput.next().charAt(0);
        charInput = Character.toLowerCase(charInput); // to make sure the character is lower case for while loop comparisons

        while(charInput != 'w' || charInput != 'a' || charInput != 's' || charInput != 'd'){// go into loop at least once to check if charInput is actually valid
            if(charInput == 'w'){
                usrInput.close();
                return charInput;
            }
            else if(charInput == 'a'){
                usrInput.close();
                return charInput;
            }
            else if(charInput == 's'){
                usrInput.close();
                return charInput;
            }
            else if (charInput == 'd'){
                usrInput.close();
                return charInput;
            }
            System.out.println("\nSorry, please enter one of the characters above");
            System.out.println("Which Direction:\nW. Up\nA. Left\nS. Down\nD. Right");
            charInput = usrInput.next().charAt(0);
        }
        usrInput.close();
        return charInput;
    }

  
}