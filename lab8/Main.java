// Group 4
// Andressa Murakami
// Raymond Guevara Lozano 
import java.util.concurrent.ThreadLocalRandom;
/**Main class where all the doors are made and then used to play door game */
public class Main {
    
    /** Main method where 3 doors are randomly chosen and user has to get through the randomly chosen door
     *  calls method openDoor() in order to handle game logic
     * @param args no command line arguments for this program
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Escape Room.\nYou must unlock 3 doors to escape...\n");
        for (int i = 0; i < 3; i++){
            int randDoor = ThreadLocalRandom.current().nextInt(3);
            Door door;
            if (randDoor == 1) {
                door = new BasicDoor();
            }
            else if (randDoor == 2){
                door = new LockedDoor();
            }
            else{
                door = new ComboDoor();
            }
            openDoor(door);
        }
        System.out.println("Congratualations! You escaped... this time.");
    }

    
    /** Passses in the door the user will try to unlock, calls examine, menu, 
     *  then gets user's input, then calls unlock and then attempts to open door,
     *  if the door is opened success method is called, otherwise clue is called then we repeat
     * @param d door the user will try to open
     */
    public static void openDoor(Door d){
        System.out.println(d.examine()); 
        while (d.open() == false){
            System.out.println(d.menu());
            int usrInput = CheckInput.getPositiveInt();
            while (d.unlock(usrInput) == null) {
                System.out.println("Invalid choice. Enter again.");
                usrInput = CheckInput.getPositiveInt();
            }
            System.out.println(d.unlock(usrInput));
            if (d.open()){
                System.out.println(d.success() + "\n");
            }
            else{
                System.out.println(d.clue());
            }
        }
    }
}