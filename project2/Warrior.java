import java.util.concurrent.ThreadLocalRandom;
/**
 * Warrior enemy type that would be used to decorate one of the four base enemy
 * types
 */
public class Warrior extends EnemyDecorator {
    /**
     * Constructor that will decorate the passed in enemy with
     * the features that will turn enemy to warrior enemy type
     * @param enemy to be decorated
     */
    public Warrior(Enemy enemy) {
        super(enemy, enemy.getName() + " Warrior", enemy.getHP() + 2, enemy.getItem()); // add warrior title to name and increase hp by 2
    }

    /** 
     * Overridden attack method that will cause enemy to do extra attack for each level 
     * the hero progresses to.
     * @param e entity to be attacked
     */
    @Override
    public String attack(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1, 6);
        e.takeDamage(randDamage);
        return this.getName() + " attacks " + e.getName() + " for " + randDamage + " damage." + "\n" + super.attack(e);
    }
}