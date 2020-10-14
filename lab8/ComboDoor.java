import java.util.concurrent.ThreadLocalRandom;
/**Combination door that implements door interface but for combination lock door */
public class ComboDoor implements Door{
    /**The correct value of the combination lock door */
    private int comboValue;
    /**The user guess for the combo value */
    private int guess;

    /**Constructor - pick random value between 1-10 for the combovalue and 
     * then intialize the guess value to 0
     */
    public ComboDoor(){
        int value = ThreadLocalRandom.current().nextInt(1,11);
        this.comboValue = value;
        this.guess = 0;
    }

    /** Method that tells the user the type of door they are dealing with
     *  and how to get past it
     * @return String representation of door
     */
    @Override
    public String examine() {
        return "You encounter a door with a combination lock.\nYou can spin the dial to a number 1-10.";
    }

    /** Give user options for what to do with the door
     * @return String prompt of options for the user
     */
    @Override
    public String menu() {
        return "Enter a number (1-10): ";
    }

    /** Method to handle the logic associated with unlocking the door
     * @param option the option the user put in
     * @return String representation of what the user is doing
     */
    @Override
    public String unlock(int option) {
        if (option >= 1 && option <= 10){
            this.guess = option;
            return "You turn the dial...";
        }
        return null;
    }

    /** Method to test and see if the door is open by comparing guess value and combo value
     * @return boolean t if both values are the same, f otherwise
     */
    @Override
    public boolean open() {
        if (this.guess == this.comboValue){
            return true;
        }
        return false;
    }

    /** Method to give the user a clue as to whether or not thier guess is in line with the actual 
     *  combo value
     * @return String representation of clue
     */
    @Override
    public String clue() {
        if (this.guess > this.comboValue){
            return "You feel the resistance as you turn the dial, it must be lower.";
        }
        return "You feel the resistance as you turn the dial, it must be higher.";
    }

    /** Method to tell the user the door has opened 
     * @return String representation of what happens
     */
    @Override
    public String success() {
        return "You have found the right value and opened the door";
    }
}