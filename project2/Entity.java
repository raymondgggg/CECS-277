/**Super class of the various types of Entity objects (e.g. hero, enemy, etc) that will be used in the game */
public abstract class Entity {
    /**Represents the name of the Entity*/
    private String name;
    /**Represents the max possible health of the Entity in question */
    private int maxHp;
    /**Represents the current hp of the Entity in question */
    private int hp;

    /**Constructor - instantiates Entity object based on parametrs*/
    public Entity(String n, int mHp){
        this.name = n;
        this.maxHp = mHp;
        this.hp = mHp;
    }

    /** Method to handle all the logic related to attacks 
     *  between different entities in the game
     * @param e the entity that will be attacked
     * @return String representation of the attack
     */
    public abstract String attack(Entity e);

    /** Retrieves the name of the Entity object
     * @return String the name of the Entity object
     */
    public String getName(){
        return this.name;
    }

    /** Retrieves he health of the Entity object
     * @return int the health of the Entity object
     */
    public int getHP(){
        return this.hp;
    }

    /** Retrieves the max possible health for the Entity object
     * @return int the mx possible health
     */
    public int getMaxHP(){
        return this.maxHp;
    }

    /** Adds health to Entity object up till max health
     * @param h the amount of health to be added
     */
    public void heal(int h){
        if (this.hp == this.maxHp){
            this.hp += 0;
        }
        else if((this.hp + h) >= this.maxHp){
            this.hp = this.maxHp;
        }
        else{
            this.hp += h;
        }
    }

    /** Takes health away from Entity object up till health is zero
     * @param h the amount of health to be taken away
     */
    public void takeDamage(int h){
        if ((this.hp - h) <= 0){
            this.hp = 0;
        }
        else{
            this.hp -= h;
        }
    }
    
    /** String representation of Entity object
     * @return String the 
     */
    @Override
    public String toString(){
        return this.name + "\n" + "HP: " + this.hp + "/" + this.maxHp;
    }
}