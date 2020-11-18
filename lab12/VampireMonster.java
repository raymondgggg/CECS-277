/**Base vampire monster class */
public class VampireMonster extends Monster {
    /**Attack damage instance variable */
    private int attackDamage;

    /** Constructor - initilizes the name, health, and the attack damage
     */
    public VampireMonster(){
        super("Vampire", 4);
        this.attackDamage = 5; // base attack damage
    }

    /** Method to get the attack damange of vampire
     * @return int attack damage the monster gives
     */
    @Override
    public int attack() {
        return this.attackDamage;
    }
}
