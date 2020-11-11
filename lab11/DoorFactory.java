/**Door Factory class where doors are created and opened based on input value passed in*/
public class DoorFactory {
    /** Method to create a new door based off int input, returns the door created
     * @param type the input to determine the type of door
     * @return Door created
     */
    public Door createDoor(int type){
        Door d;
        if (type == 1) {
            d = new BasicDoor();
        } else if (type == 2) {
            d = new LockedDoor();
        } else {
            d = new ComboDoor();
        }
        return d;
    }

    /** Method that goes through the process of opening the door, uses create door method
     *  to get a door, then goes through opening door routine.
     * @param type int that will be used to determine the door that will be used.
     */
    public void openDoor(int type){
        Door d = createDoor(type);
        System.out.println(d.examine());
        while (d.open() == false) {
            System.out.println(d.menu());
            int usrInput = CheckInput.getPositiveInt();
            while (d.unlock(usrInput) == null) {
                System.out.println("Invalid choice. Enter again.");
                usrInput = CheckInput.getPositiveInt();
            }
            System.out.println(d.unlock(usrInput));
            if (d.open()) {
                System.out.println(d.success() + "\n");
            } else {
                System.out.println(d.clue());
            }
        }
    }
}