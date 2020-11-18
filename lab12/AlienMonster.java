/**Base class for Alien Monster */
public class AlienMonster extends Monster{
    /**Attack damage instance variable for the alien */
    private int attackDamage;
    
    /** Constructor - Set the name and hp of the monster
     *  as well as the attack damage.
     */
    public AlienMonster(){
        super("Alien", 6);
        this.attackDamage = 1;
    }

    /** Method to get the attack damage for the alien
     * @return int the base attack damage for the Alien
     */
    @Override
    public int attack() {
        return this.attackDamage;
    }
}
