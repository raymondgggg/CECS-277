/**Base Goblin enemy class that is to be decorated */
public class Goblin extends Enemy{
    /**
     * Constructor - initilizes default name and hp of the golblin and passes
     * in item that the goblin will have
     * @param i Item of the goblin
     */
    public Goblin(Item i) {
        super("Goblin", 2, i); //Default name and hp gotten from original .txt enemy list.
    }
}