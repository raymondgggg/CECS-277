/** Troll enemy class that is to be decorated */
public class Troll extends Enemy {
    /**
     * Constructor, initilizes default name and health as well as 
     * passes in item that the troll will carry
     */
    public Troll() {
        super("Troll", 5 , ItemGenerator.getInstance().generateItem());// default name and hp gotten from original enemy .txt file
    }
}