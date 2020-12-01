/**Abstract enemy decorator class that will add to the enemy object as needed */
public abstract class EnemyDecorator extends Enemy{
    /**Instance variable to the enemy object */
    private Enemy enemy;

    /**
     * Constructor that calls super constructor 
     * and initilizes enemy instance variable
     * @param enemy object
     * @param n name of enemy
     * @param mHp max hp
     * @param i item
     */
    public EnemyDecorator(Enemy enemy,String n, int mHp, Item i) {
        super(n, mHp, i);
        this.enemy = enemy;
    }
}