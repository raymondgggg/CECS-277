/**Class that represents a player that will be used in interactive pet game*/
public class Player {
    /**The amount of current health the player has */
    private int hp;

    /**Constructor - sets the amount of health the player has to 10; */
    public Player(){
        this.hp = 10;
    }

    /** Method for returning the current amount of HP 
     *  the player has.
     * @return int the number of HP the player has.
     */
    public int getHp(){
        return this.hp;
    }

    /** Method for taking HP away from the player
     * @param d the amount of HP to take away
     */
    public void takeDamage(int d){
        this.hp -= d;
    }

    /** Method for check if the player is currently dead, returns true if HP
     *  is less than or equal to 0, false otherwise.
     * @return boolean the t/f status of the players' life.
     */
    public boolean isDead(){
        if (this.hp <= 0){
            return true;
        }
        return false;
    }

    /** String representation of the amount of current HP the player has
     * @return String current HP of the player
     */
    public String toString(){
        return "You have " + this.hp + "/" + 10 + "HP";
    }
}
