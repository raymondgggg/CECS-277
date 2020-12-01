/**Fire ability class that would be added to the monster */
public class Fire extends MonsterDecorator{
    /**Constructor - calls super constructor based of the 
     * given params
     * @param monster - the monster object
     * @param name - the new name of the monster
     * @param hp - the new hp of the monster
     */
    public Fire(Monster monster) {
        super(monster, "Firey " + monster.getName(), monster.getHP() + 2); //update monster with new values
    }
    /** 
     * Method that uses call stack for attack method for Monster object to find the damage the monster gives
     * @return int the attack damage the monster gives
     */
    public int attack(){
        return 4 + super.attack();
    }
}
