/**Item class to represent the items that will be used in the game */
public class Item implements ItemPrototype{
    /**name of item */
    private String name;
    /**The amount that the item is worth at the store */
    private int value;
    /**Type of the item - potion, key, money, armor */
    private char type;

    /**Constructor to set the name of the item
     * @param name of item
     * @param value of item
     * @param type of item
     */
    public Item (String name, int value, char type){
        this.name = name;
        this.value = value;
        this.type = type;
    }

    /**
     * Constructor for Item object that takes in item object and creates a 
     * new item object with the same values as the object that was passed in.
     * @param i Item object
     */
    public Item(Item i){
        if (i != null){
            this.name = i.name;
            this.value = i.value;
            this.type = i.type;
        }
    }

    /** Method to return the name of the item
     * @return the name of the item
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method to get the type of item
     * @return char type
     */
    public char getType() {
        return this.type;
    }
    /**
     * Method to get the value of the item at the store
     * @return int value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Method to that returns a clone of the current object
     * @return new object with same fields
     */
    @Override
    public ItemPrototype clone(){
        return new Item(this);
    }
}