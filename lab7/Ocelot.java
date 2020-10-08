/** Subclass of Cat, Ocelot */
public class Ocelot extends Cat {
    /**
     * Constructor - for creating type of Cat Ocelot
     * 
     * @param n the name of Ocelot
     */
    public Ocelot(String n){
        super(n);
    }

    /** Method for handling feeding interaction between Player and Ocelot
     * @param p the player that will feed the Ocelot
     * @return String representation of what happens
     */
    @Override
    public String feed(Player p) {
        String catStatus;
        if (getHunger() >= 1 && getHunger() <= 4) {
            catStatus = toString() + " and starts eating the food";
            incrementHunger(2);
            return catStatus;
        } else if (getHunger() >= 5 && getHunger() <= 7) {
            catStatus = toString() + ", but still eats the food";
            incrementHunger(2);
            return catStatus;
        }
        int damage = 3;
        catStatus = toString() + ", and attacks you. You take " + damage + " damage";
        p.takeDamage(damage);
        incrementHunger(-3);
        return catStatus;
    }

    /**
     * Method for handling playing interaction between Player and Ocelot
     * @param p the player that will play with Ocelot
     * @return String represetation of what happens
     */
    @Override
    public String play(Player p) {
        String catStatus;
        int damage = 3;
        if (getHunger() >= 8 && getHunger() <= 10) {
            catStatus = toString() + ", and just rolls over to entertain you for your wishes";
            incrementHunger(-3);
            return catStatus;
        } else if (getHunger() >= 5 && getHunger() <= 7) {
            catStatus = getName() + " jumps and knocks over a shelf that hits you in the head, you take " + damage + " damage";
            incrementHunger(-3);
            p.takeDamage(damage);
            return catStatus;
        }
        catStatus = toString() + " and attacks you for being a horrible owner, you take " + damage + " damage";
        p.takeDamage(damage);
        incrementHunger(-3);
        return catStatus;
    }

    /**
     * Method for handling the pet interaction between Player and Ocelot
     * @param p the player that will pet the Ocelot
     * @return String representation of what happens
     */
    @Override
    public String pet(Player p) {
        String catStatus;
        int damage = 3;
        if (getHunger() >= 1 && getHunger() <= 4) {
            catStatus = toString() + ", and attacks you, you take " + damage + " damage";
            p.takeDamage(damage);
            incrementHunger(-3);
            return catStatus;
        } else if (getHunger() >= 5 && getHunger() <= 7) {
            catStatus = toString() + ", and lets you pet them.";
            incrementHunger(-3);
            return catStatus;
        }
        catStatus = toString() + ", and has fallen asleep.";
        incrementHunger(-3);
        return catStatus;
    }
}
