/**Magical interface to be implemented by any Entity that uses anything magic related */
public interface Magical {
    /** Menu representing the different options for magical attacks */
    public static final String MAGIC_MENU = "1. Magic Missile\n2. Fire ball\n3. Thunderclap";

    /**
     * Method for magic missle, takes in Entity and does random damage to Entity 
     * passed in 
     * @param e the Entity that will take damage
     * @return String representation of what happens
     */
    public String magicMissile(Entity e);
    /**
     * Method for fireball, takes in Entity and does random damage to Entity
     * passsed in
     * @param e the Entity that will take damage
     * @return String represntation of what happens
     */
    public String fireball(Entity e);
    /**
     * Method for thunderclap, takes in Entity and does random damage to Entity
     * passed in 
     * @param e the Entity that will take damage
     * @return String representation of what happens
     */
    public String thunderclap(Entity e);
}