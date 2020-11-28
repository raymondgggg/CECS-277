/**Item class to represent the items that will be used in the game */
public class Item {
    /**ame of item */
    private String name;

    /**Constructor to set the name of the item
     * @param n the name 
     */
    public Item (String n){
        this.name = n;
    }

    /** Method to return the name of the item
     * @return the name of the item
     */
    public String getName(){
        return this.name;
    }
}