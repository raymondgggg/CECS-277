/**Warrior enemy type that would be used to decorate one of the four base enemy types */
public class Warrior extends EnemyDecorator {

    /**
     * Constructor that will decorate the passed in enemy with
     * the features that will turn enemy to warrior enemy type
     * @param enemy to be decorated
     */
    public Warrior(Enemy enemy) {
        super(enemy, enemy.getName() + " Warrior ", enemy.getHP() + 2, enemy.getItem()); // add warrior title to name and increase hp by 2
    }
}