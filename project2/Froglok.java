/**Base Froglok enemy class that is to be decorated */
public class Froglok extends Enemy{
    /**
     * Constructor - initilizes default name and hp for the foglok 
     * and passes in the item that the enemy is suppose to have
     */
    public Froglok() {
        super("Froglok",2 , ItemGenerator.getInstance().generateItem()); // default values of name and hp gotten from original .txt file of enemies
    }
}