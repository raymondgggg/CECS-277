import java.util.concurrent.ThreadLocalRandom;
/**DeadBoltDoor object that has two bolts that must be unlocked in order to open door */
public class DeadBoltDoor implements Door {
    /**First bolt for the door, t if unlocked, f otherwise */
    private boolean bolt1;
    /**Second bolt for the door, t if unlocked, f otherwise */
    private boolean bolt2;

    /**Constructor - randomly set the values of the bolts so that one is always unlocked and one is always
     * locked
     */
    public DeadBoltDoor(){
        int truthValue = ThreadLocalRandom.current().nextInt(1,3); //get int from 1-2
        //randomly set the truth values so that either bolt1 or bolt2 will always be in the correct 
        //position but never both.
        if (truthValue == 1){
            this.bolt1 = true;
            this.bolt2 = !this.bolt1;
        }
        else{
            this.bolt1 = false;
            this.bolt2 = !this.bolt1;
        }
    }

    /** Method to return the type of door the user user is dealing with 
     * @return String representation of what door the user is confronted with
     */
    @Override
    public String examine() {
        return "You have encountered a double deadbolt door, both deadbolts must be unlocked but you can't tell which are locked or unlocked";
    }

    /** Method to give the user options as to what they can do with the door
     * @return String representation of options
     */
    @Override
    public String menu() {
        return "1. Toggle Bolt 1\n2. Toggle Bolt 2";
    }

    /** Method that takes in the user's option and modifies truth values for bolts accordingly 
     * @param option the user chose 
     * @return String reprsentation of action
     */
    @Override
    public String unlock(int option) {
        if (option >= 1 && option <= 2){
            if (option == 1){
                this.bolt1 = !this.bolt1;
                return "You toggle the first bolt";
            }
            this.bolt2 = !this.bolt2;
            return "You toggle the second bolt";
        }
        return null;
    }

    /** Method to test and see if the door is unlocked
     * @return boolean value t if door is unlocked, f otherwise
     */
    @Override
    public boolean open() {
        if (this.bolt1 && this.bolt2){
            System.out.println(success());
            return true;
        }
        System.out.println("You jiggle the door " + clue());
        return false;
    }

    /** Method that gives the user clue based on the status of the two deadbolts
     * @return String representation of clue given to the user
     */
    @Override
    public String clue() {
        if ((this.bolt1 == true && this.bolt2 == false) || (this.bolt1 == false && this.bolt2 == true)){
            return "One of the bolts seems to feel unlocked";
        }
        return "The door appears to be bolted tight and won't budge";
    }

    /** Method to let user know if they have opened the door
     * @return String message telling user the door has opened
     */
    @Override
    public String success() {
        return "You unlocked both deadbolts and opened the door";
    }
}
