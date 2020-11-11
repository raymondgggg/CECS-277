// Group 2 - Lab 11
// Juan Anaya
// Raymond Guevara Lozano 
import java.util.concurrent.ThreadLocalRandom;
/**Main class where all the classes are combined to make escape room game for user to play*/
public class Main {
    /** Main method where the reimplementation of escape room program takes place using DoorFactory class to 
     *  modularize the program
     * @param args no command line arguments for this program
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Escape Room.\nYou must unlock 3 doors to escape...\n");
        for (int i = 0; i < 3; i++){
            int randDoor = ThreadLocalRandom.current().nextInt(1,4);
            DoorFactory df = new DoorFactory();
            df.openDoor(randDoor);
        }
        System.out.println("Congratualations! You escaped... this time.");
    }
}