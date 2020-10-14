public interface Door {

    /**Method to show what type of door we are dealing with
     * @return String description of the door
     */
    String examine();

    /*** Method that displays a list of options for the user to try and unlock door
     * @return a list of options the user can do to unlock the door.
     */
    String menu();

    /**takes in user's menu selection, checks that it is in the bounds of menu
     * choices, and then performs the action the user chose.
     * @param option the user chose
     * @return String representation related to user action
     */
    String unlock(int option);

    /**Method to test to see if the door has been unlocked
     * @return boolean value of t/f based on if door has been unlocked
     */
    boolean open();

    /**Method to give the user a clue to open the door 
     * @return String clue to help user
     */
    String clue();

    /**Method to return success message to the user for opening the door
     * @return success message
     */
    String success();
}
