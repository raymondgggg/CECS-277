public class Main {
    public static void main(String[] args) {
       CheckInput checkInput = new CheckInput();
       boolean usrInput;
       Player player = new Player();
       do {
           System.out.println("Yahtzee\n");
           player.takeTurn();
           System.out.println("Play again? (Y/N) ");
           usrInput = checkInput.getYesNo();
       }while(usrInput == true);
       System.out.println("Game Over.");
       System.out.println("Final Score = " + player.getPoints() + " point(s)");

    }
}
