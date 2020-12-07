/**Prototype interface that will be used to clone object */
public interface ItemPrototype {
    /**
     * Method to get a new instance of same object
     * @return new object with same fields 
     */
    public ItemPrototype clone();
}
