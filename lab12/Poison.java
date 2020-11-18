/**Poison ability that would be added to the monster*/
public class Poison extends MonsterDecorator{
    /**
     * Constructor that calls super constructor basd on the given params
     * 
     * @param monster- the monster object to be updated
     * @param name     - the new name of the monster
     * @param hp       - the new healthpoints of the monster
     */
    public Poison(Monster monster,String name, int hp) {
        super(monster, name, hp);
    }

    /**
     * method that uses call stack for attack method of Monster object to find the damage the monster
     * gives
     * 
     * @return int the attack damage the monster gives
     */
    public int attack() {
        return 3 + super.attack();
    }
    
}
