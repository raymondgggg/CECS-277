/**Base Orc enemy class that is to be decorated */
public class Orc extends Enemy{

    /**
     * Constructor - initilizes default values and passes in item that the orc 
     * enemy will have
     * @param i Item of the enemy
     */
	public Orc(Item i) {
		super("Orc", 4, i);// default name and hp gotten from original .txt enemy list
	}
    
}
