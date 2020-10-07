/**Subclass of Cat, Tabby */
public class Tabby extends Cat{
    /**Constructor - for creating type of Cat Tabby
     * @param n the name of Tabby
    */
    public Tabby(String n){
        super(n);
    }

    /** Method for handling feeding interaction between Player and Tabby
     * @param p the player that will feed Tabby
     * @return String representation of what happened
     */
    @Override
    public String feed(Player p) {
        String catStatus;
        if (getHunger() >= 1 && getHunger() <= 4){ 
            catStatus = toString() + " and starts eating the food";
            incrementHunger(2);
            return catStatus;
        }
        else if(getHunger() >= 5 && getHunger() <= 7){ 
            catStatus = toString() + ", but still eats the food";
            incrementHunger(2);
            return catStatus;
        }
        int damage = 2;
        catStatus = toString() + ", and attacks you. You take " + damage + " damage";
        p.takeDamage(damage);
        incrementHunger(-2);
        return catStatus; 
    }

    /** Method for handling playing interaction between Player and Tabby
     * @param p the player that will play with Tabby
     * @return String representation of what happens
     */
    @Override
    public String play(Player p) {
        String catStatus;
        int damage = 2;
        if (getHunger() >= 8 && getHunger() <= 10){
            catStatus = toString() + ", and just rolls over to entertain you for your wishes";
            incrementHunger(-2);
            return catStatus;
        }
        else if (getHunger() >= 5 && getHunger() <= 7){
            catStatus = getName() + " jumps and knocks over a lamp that hits you in the head, you take " + damage + " damage";
            incrementHunger(-2);
            p.takeDamage(damage);
            return catStatus;
        }
        catStatus = toString() + " and attacks you for being a horrible owner, you take " + damage + " damage";
        p.takeDamage(damage);
        incrementHunger(-2);
        return catStatus;
    }

    /** Method for handling the pet interaction between Player and Tabby
     * @param p the player that will pet Tabby
     * @return String representation of what happens
     */
    @Override
    public String pet(Player p) {
        String catStatus;
        int damage = 2;
        if (getHunger() >= 1 && getHunger() <= 4){
            catStatus = toString() + ", and attacks you, you take " + damage + " damage";
            p.takeDamage(damage);
            incrementHunger(-2);
            return catStatus;
        }
        else if (getHunger() >= 5 && getHunger() <= 7){
            catStatus = toString() + ", and lets you pet them.";
            incrementHunger(-2);
            return catStatus;
        }
        catStatus = toString() + ", and has fallen asleep.";
        incrementHunger(-2);
        return catStatus;
    } 
}
