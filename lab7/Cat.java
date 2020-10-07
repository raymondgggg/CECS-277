/**Abstract class for object of type Cat that will be used to extend other subclasses of Cat */
public abstract class Cat {
    /** The name of the cat */
    private String name;
    /**The hunger level for the cat range (1-10)*/
    private int hunger;

    /**Constructor - instantiates Cat object and sets the name to 
     * parameter and hunger level to default level of 5
     * @param n the name of the cat
     */
    public Cat(String n){
        this.name = n;
        this.hunger = 5;
    }

    /** Method for returning the name of the cat 
     *  in question
     * @return String the name of the cat
     */
    public String getName(){
        return this.name;
    }

    /** Method for returning the hunger level of the cat in question
     * @return int the hunger level over the cat (range 1-10)
     */
    public int getHunger(){
        return this.hunger;
    }

    /** Method for modifying the hunger value of the cat based off 
     *  value entered.
     * @param val the vaule that will be added or subtracted to the cat's hunger
     * @return int the hunger of the cat
     */
    protected int incrementHunger(int val){
        this.hunger += val;
        if (this.hunger <= 0){
            this.hunger = 1;
        }
        if (this.hunger >= 10){
            this.hunger = 10;
        }
        return this.hunger;
    }

    /** Returns String value representation of cats hunger level
     * @return String the cat's hunger level
     */
    @Override
    public String toString(){
        if (this.hunger >= 1 && this.hunger <= 4){
            return this.name + " is hungry";
        }
        else if (this.hunger >= 5 && this.hunger <=7){
            return this.name + " is statisfied";
        }
        return this.name + " is full";
    }

    /**Method prototype that takes in Player 
     * and does feeding interaction with cat
     * @param p the player 
     */
    public abstract String feed(Player p);

    /**Method prototype that takes in Player and 
     * does play interaction with cat
     * @param p the player
     */
    public abstract String play(Player p);

    /**Method prototype that takes in Player 
     * and does petting interaction with cat
     * @param p the player
     */
    public abstract String pet(Player p);

}

