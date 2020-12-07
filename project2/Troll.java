/** Troll enemy class that is to be decorated */
public class Troll extends Enemy {
    /**
     * Constructor, initilizes default name and health as well as 
     * passes in item that the troll will carry
     * @param i Item that will the troll will have
     */
    public Troll(Item i) {
        super("Troll", 5 , i); // default name and hp gotten from original enemy .txt file
    }
}