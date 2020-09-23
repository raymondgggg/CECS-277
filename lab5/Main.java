//Raymond Guevara Lozano
//Catherine Bui
//Quoc Ngo
/**Main class where the program is executed */
public class Main {
    /** Method where the user is prompted to roll dice and
     *  is given choice to continue playing dice game 
     * @param args no command line arguments used for the main method
     */
    public static void main(String[] args) {
       CheckInput checkInput = new CheckInput();
       boolean usrInput;
       Player player = new Player();
       do {
           System.out.println("Yahtzee\n");
           player.takeTurn();
           System.out.println("Play again? (Y/N) ");
           usrInput = checkInput.getYesNo(); // input validation 
       }while(usrInput == true);
       System.out.println("Game Over.");
       System.out.println("Final Score = " + player.getPoints() + " point(s)"); // final score
    }
}
