import java.util.concurrent.ThreadLocalRandom;
/**Extension of Enemy ---> MagicalEnemy implements magical interface */
public class MagicalEnemy extends Enemy implements Magical{
    /** Constructor - instantiates Magical enemy using the 
     *  super constructor from the Enemy class MagicalEnemy inherits
     *  from
     */
    public MagicalEnemy(String n, int mHp, Item i){
        super(n, mHp, i);
    }

    /** Randomly choose a magical attack of either missle, fireball, or thunder clap, and
     *  uses chosen attack on Entity passed through
     * @param e the Entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String attack(Entity e){
        int randAttack = ThreadLocalRandom.current().nextInt(1,4); //randomly determine the three types of possible attacks
        String attack;
        if (randAttack == 1){
            attack = magicMissile(e);
            return attack;
        }
        else if (randAttack == 2){
            attack = fireball(e);
            return attack;
        }
        attack = thunderclap(e);
        return attack;
    }

    /** Magic missle attack method where Entity passed through is hit with 
     *  random number of damage
     * @param e the Entity to be attacked
     * @return String represetation of what happens
     */
    @Override
    public String magicMissile(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,8);
        e.takeDamage(randDamage);
        return getName() + " shoots a blazing magic missle at " + e.getName() + " for " + randDamage + " damage";
    }

    /** Fireball attack method where Entity passed through is hit with
     *  a random number of damage
     * @param e the Entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String fireball(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,8);
        e.takeDamage(randDamage);
        return getName() + " shoots a heat seaking fireball at " + e.getName() + " for " + randDamage + " damage";
    }

    /** Thunder clap attack method where Entity passed through is hit with a 
     *  random number of damaged
     * @param e the Entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String thunderclap(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,8);
        e.takeDamage(randDamage);
        return getName() + " strikes with a thunder clap taking away " + randDamage + " health from " + e.getName();
    }
}
