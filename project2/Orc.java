/**Base Orc enemy class that is to be decorated */
public class Orc extends Enemy{
    /**
     * Constructor - initilizes default values and passes in item that the orc 
     * enemy will have
     */
	public Orc() {
		super("Orc", 4, ItemGenerator.getInstance().generateItem());// default name and hp gotten from original .txt enemy list
	} 
}