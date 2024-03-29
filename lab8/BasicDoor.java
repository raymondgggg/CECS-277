import java.util.concurrent.ThreadLocalRandom;
/** BasicDoor class that will be used in game, implements door interface */
public class BasicDoor implements Door{
    /**Boolean value to see if door needs to be pushed*/
    private boolean push;
    /**Boolean value to see if input is true and opens door*/
    private boolean input;

    /**Constructor - randomly sets push value for door, and then sets input to false
     */
    public BasicDoor(){
        int pushValue = ThreadLocalRandom.current().nextInt(1,3);
        if (pushValue == 1){
            this.push = true;
        }
        else{
            this.push = false;
        }
        this.input = false;
    }

    /** Method that returns the type of door the user is dealing with
     * @return String representation of door
     */
    @Override
    public String examine() {
        return "You've encountered a basic door. You can either push or pull to open";
    }
    
    /** Menu options for what the user can do
     * @return String representation of menu
     */
    @Override
    public String menu() {
        return "1. Push\n2. Pull";
    }

    /** Takes in user choice for menu option, check to see if it is between 1-2 (inclusive) 
     *  then updates the instance variable input if the user picked the right option
     *  returns the action the user takes.
     * @param option the user chose
     * @return String representation of user action (null if option is not in range)
     */
    @Override
    public String unlock(int option) {
        if (option >= 1 && option <= 2){
            if (option == 1 && this.push == true){
                this.input = true;
                return "You have pushed the door";
            }
            else if (option == 1 && this.push == false){
                return "You have pushed the door\nBut the door did not open";
            }
            else if (option == 2 && this.push == false){
                this.input = true;
                return "You have pulled the door";
            }
            return "You have pulled the door\nBut the door did not open";
        }
        return null;// value retured if the option entered is out of range.
    }

    /** Method to test and see if the door has been opened
     * @return boolean value t/f to see if door is open
     */
    @Override
    public boolean open() {
        if (this.input == true){
            return true;
        }
        return false;
    }

    /** Method to give the user a clue as to how to open door
     * @return String representation of clue
     */
    @Override
    public String clue() {
        return "Try the other option";
    }

    /** Method to give user praise for opening door successfully
     * @return String representaion of praise
     */
    @Override
    public String success() {
        return "And the door has opened.";
    }
}
