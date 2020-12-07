import java.util.concurrent.ThreadLocalRandom;
/**Warlock Enemy type that will be used to decorate one of the base enemies */
public class Warlock extends EnemyDecorator implements Magical {

    /**
     * Constructor that will decorate the passed in enemy type 
     * and turn them into warlock type
     * @param enemy
     */
    public Warlock(Enemy enemy) {
        super(enemy, enemy.getName() + " Warlock ", enemy.getHP() + 1, enemy.getItem()); 
    }

    /**
     * Randomly choose a magical attack of either missle, fireball, or thunder clap,
     * and uses chosen attack on Entity passed through
     * 
     * @param e the Entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String attack(Entity e) {
        
        int randAttack = ThreadLocalRandom.current().nextInt(1, 4); // randomly determine the three types of possible
                                                                    // attacks
        String attack;
        if (randAttack == 1) {
            attack = magicMissile(e);
            return attack;
        } else if (randAttack == 2) {
            attack = fireball(e);
            return attack;
        }
        attack = thunderclap(e);
        return attack;
    }

    /**
     * Magic missle attack method where Entity passed through is hit with random
     * number of damage
     * 
     * @param e the Entity to be attacked
     * @return String represetation of what happens
     */
    @Override
    public String magicMissile(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1, 6);
        e.takeDamage(randDamage);
        return getName() + " shoots a blazing magic missle at " + e.getName() + " for " + randDamage + " damage";
    }

    /**
     * Fireball attack method where Entity passed through is hit with a random
     * number of damage
     * 
     * @param e the Entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String fireball(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1, 6);
        e.takeDamage(randDamage);
        return getName() + " shoots a heat seaking fireball at " + e.getName() + " for " + randDamage + " damage";
    }

    /**
     * Thunder clap attack method where Entity passed through is hit with a random
     * number of damaged
     * 
     * @param e the Entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String thunderclap(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1, 6);
        e.takeDamage(randDamage);
        return getName() + " strikes with a thunder clap taking away " + randDamage + " health from " + e.getName();
    }
    
}
