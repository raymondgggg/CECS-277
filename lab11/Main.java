// Group 2
// Juan Anaya
// Raymond Guevara Lozano 
import java.util.concurrent.ThreadLocalRandom;
/**Main class where all the doors are made and then used to play door game */
public class Main {
    /** Reimplementation of escape room program using DoorFactory class to keep 
     *  program more modular.
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