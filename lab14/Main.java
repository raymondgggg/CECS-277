
/*
  @author Brian Phung
  @author Raymond Guevara
  @version CECS 277 - Lab 14
  @since 12/1/20
*/
import java.util.Scanner;
import java.util.Stack;
/**Main class where the tic tac toe game is to be played */
public class Main {
    /**
     * Main method - history stack is created and user is prompted to place token, revert, 
     * or quit the epic game of tic tac toe.
     * @param args
     */
    public static void main(String[] args) {
        Stack<Memento> history = new Stack<Memento>();
        Board b = new Board();
        int currentChoice = 0;
        char[] choices = {'x', 'o'};
        int choice;
        do {
            b.display();
            System.out.println("1. Place token");
            System.out.println("2. Revert");
            System.out.println("3. Quit");
            choice = getIntRange(1, 3);
            if (choice == 1) {
                if (choices[currentChoice % choices.length] == 'x') 
                    history.push(b.save());
                System.out.println("Place an " + choices[currentChoice % choices.length]);// alternate between X and out
                System.out.print("Row: ");
                int row = getIntRange(0, 2); // its really indices 0-2
                System.out.print("Col: ");
                int col = getIntRange(0, 2);

                
                while (b.placeToken(choices[currentChoice % choices.length], row, col) == false){
                    System.out.println("Token cannot be placed there, enter input again");
                    System.out.print("Row: ");
                    row = getIntRange(0, 2);
                    System.out.print("Col:");
                    col = getIntRange(0, 2);
                }
                currentChoice++;
            } else if (choice == 2) {
                if (history.isEmpty())
                    System.out.println("There is no history to restore from.");
                else{
                    b.restore(history.pop());// return the last save
                    currentChoice--;
                }
                
            } else if (choice == 3) {
                System.out.println("Thanks for playing!");
            }
        } while (choice != 3);
    }

    /**
     * Helper Method to get the input from the user over a specified range.
     * @param low lower bound of the range
     * @param high higher bound of the range
     * @return the int entered by the user that is within the specified range
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