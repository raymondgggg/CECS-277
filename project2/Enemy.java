import java.util.concurrent.ThreadLocalRandom;

/**Enemy class for the enemies in the game */
public abstract class Enemy extends Entity{
    /**Enemy Item */
    private Item item;

    /**Constructor for the enemy
     * @param n type of enemy
     * @param mHp health for the enemy
     * @param i enemy item
     */
    public Enemy(String n, int mHp, Item i){
        super(n, mHp);
        this.item = i;
    }
 
    /** Method for returning the value of 
     * @return Enemy Item
     */
    public Item getItem(){
        return this.item;
    }

    /**Method of handling the attack interaction between and Enemy object
     * and another Entity
     * @param e the Entity to be attacked
     * @return String representation of the attack interaction
     */
    @Override
    public String attack(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,6);
        e.takeDamage(randDamage);
        return getName() + " attacks " + e.getName() +" for " + randDamage + " damage.";
    }
}