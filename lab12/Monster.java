/**Abstract Monster class that will be used for decorator design pattern */
public abstract class Monster {
    /**Name instance variable of the monster */
    private String name;
    /**Health instance variable of the monster */
    private int hp;

    /**
     * Constructor that initializes fields
     * @param name of the monster
     * @param hp of the monster
     */
    public Monster(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    /** Abstract attack method that classes that extend from monster will implement
     * @return int attack damage for the base monsters
     */
    public abstract int attack();

    /** Method to get monster name
     * @return String name of the monster
     */
    public String getName(){
        return this.name;
    }
    
    /** Method to get the health of the monster
     * @return int health of the monster
     */
    public int getHP(){
        return this.hp;
    }
}
