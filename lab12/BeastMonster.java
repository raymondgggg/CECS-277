/**Base class for Beast Monster */
public class BeastMonster extends Monster{
    /**Attack Damage for the Beast Monster */
    private int attackDamage;
    /** Constructor - initilizes name and health as well as attack damage
     * 
     */
    public BeastMonster(){
        super("Beast", 7);
        this.attackDamage = 3; // base attack damage
    }

    /** Method to get the attack damage for the monster
     * @return int the damage the monster gives
     */
    @Override
    public int attack() {
        return this.attackDamage;
    }
}
