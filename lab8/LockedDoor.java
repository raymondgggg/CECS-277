import java.util.concurrent.ThreadLocalRandom;
/**Locked door class for game, implments Door interface */
public class LockedDoor implements Door {
    /**Location of the key */
    private int keyLocation;
    /**Location that the user searches for key */
    private int keyChoice;

    /** Constructor - randomly initializes the location of the key
     */
    public LockedDoor(){
        this.keyLocation = ThreadLocalRandom.current().nextInt(1,4);
    }

    
    /** Method to simulate the user examining the door
     * @return String representation of user examining door
     */
    @Override
    public String examine() {
        return "You have encountered a locked door";
    }

    
    /** Method that shows the options the user has in interacting with the door
     * @return String representation of the menu
     */
    @Override
    public String menu() {
        return "1. Look Under Mat\n2. Look Under Flower Pot\n3. Look Under Fake Rock";
    }

    
    /** Method that checks if the user's input is with the range of options then 
     *  returns a string representation of the user interacting with the door.
     * @param option
     * @return String
     */
    @Override
    public String unlock(int option) {
        if (option >= 1 && option <= 3){
            this.keyChoice = option;
            if (option == 1){
                return "You look under the mat";
            }
            else if (option == 2){
                return "You look under the flower pot";
            }
            return "You look under the fake rock";
        }
        return null;
    }

    
    /** Method to check to see if the user's choice matches with the correct key location 
     *  returns true if it does, false otherwise
     * @return boolean value if choice matches location
     */
    @Override
    public boolean open() {
        if (this.keyChoice == this.keyLocation){
            return true;
        }
        return false;
    }

    
    /** Method to give the user a clue to unlock the door
     * @return String representation of clue
     */
    @Override
    public String clue() {
        return "Try looking somewhere else";
    }

    
    /** Method to give user success message if they unlock the door
     * @return String representation of success message.
     */
    @Override
    public String success() {
        return "You have unlocked the door!";
    }
    
}
