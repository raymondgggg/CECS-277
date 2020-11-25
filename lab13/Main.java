/**Main class where user is given the options to play or feed their new puppy */
public class Main{
    /**
     * main method where the other previously made classes are put together to create 
     * playing with puppy simulation
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        System.out.println("Congratulations on your new puppy!");
        menu();
        int usrInput = CheckInput.getIntRange(1, 3);
        while (usrInput != 3){
            if (usrInput == 1)
                puppy.eat();
            else
                puppy.play();
            menu();
            usrInput = CheckInput.getIntRange(1, 3);
        }
    }

    /**
     * Helper method that prints out the menu and options for the user
     */
    public static void menu(){
        System.out.println("What would you like to do?\n1. Feed\n2. Play\n3. Quit");
    }
}