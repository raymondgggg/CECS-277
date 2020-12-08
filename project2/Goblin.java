/**Base Goblin enemy class that is to be decorated */
public class Goblin extends Enemy{
    /**
     * Constructor - initilizes default name and hp of the golblin and passes
     * in item that the goblin will have
     * 
     */
    public Goblin() {
        super("Goblin", 2, ItemGenerator.getInstance().generateItem()); //Default name and hp gotten from original .txt enemy list.
    }
}