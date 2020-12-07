import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**Hero that will be controled by the player in the game*/
public class Hero extends Entity implements Magical{
    /**Items the hero carries */
    private ArrayList<Item> items;
    /**Map that the hero will explore */
    private Map map;
    /**Location of the hero */
    private Point location;
    /**Variable to keep track of the gold the hero currently has */
    private int gold;

    /**Constructor - instantiates hero object by calling super constructor, and initializing map
     * and location fields
     */
    public Hero(String n, Map m){
        super(n, 25);
        this.items = new ArrayList<Item>();
        this.map = m;
        this.location = this.map.findStart();
        this.gold = 0;
    }

    /** Method that combines toString of entity as well as inventory of hero
     * @return String representation of hero object
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + itemsToString();
    }

    /** Method to go through itemList and appends all items to string
     * @return String represetnation of Item objects
     */
    public String itemsToString(){
        String inventory = "Inventory:";
        for (int i = 0; i < getNumItems();i++){
            inventory += "\n" + (i+1) + ". " + this.items.get(i).getName() ;
        }
        return inventory;
    }
    
    /** Method to get the number of items the hero has
     * @return int number of items
     */
    public int getNumItems(){
        return this.items.size();
    }

    /** Method to determine if hero wants to pick up item
     * @param i the item in question
     * @return boolean value if hero wants to pick up item
     */
    public boolean pickUpItems(Item i){
        if (this.items.size() < 5){
            System.out.println("You received a " + i.getName());
            this.items.add(i);
            return true;
        }
        System.out.println("You found " + i.getName()+ ", take Item (y/n)? ");
        boolean takeItem = CheckInput.getYesNo();
        if (takeItem){
            System.out.println(itemsToString());
            System.out.println("Choose item to remove: ");
            int item = CheckInput.getIntRange(1, 5);
            this.items.remove(item - 1);
            this.items.add(i);
            return true;
        }
        return false;
    }

    /**Method to heal the hero */
    public void drinkPotion(){
        heal(this.getMaxHP());
        for (int i = 0; i < this.items.size();i++){
            if (this.items.get(i).getName().equals("Health Potion")) {
                this.items.remove(i);
            }
        }
    }

    /** Method for hero to drop item from inventory 
     * @param index of item to be dropped
     */
    public Item dropItem(int index){
        Item i = this.items.get(index);
        this.items.remove(index);
        return i;
    }

    /** Method to see if hero has potion in their inventory
     * @return boolean value t/f if there hero has potion
     */
    public boolean hasPotion(){
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals("Health Potion")){
                return true;
            }
        }
        return false; 
    }

    /** Method to know the location of the hero
     * @return Point representation of location
     */
    public Point getLocation(){
       return this.location;
    }

    /** Method that updates the hero's location based on them wanting to go north
     * @return char of location on map
     */
    public char goNorth(){
        if (this.location.x == 0){
            return this.map.getCharAtLoc(this.location);
        }
        this.map.reveal(this.location);
        this.location.x--;
        return this.map.getCharAtLoc(this.location);
    }

    /** Method that updates the hero's location based on them wanting to go south
     * @return char of location on map
     */
    public char goSouth(){
        if (this.location.x == 4){
            return this.map.getCharAtLoc(this.location);
        }
        this.map.reveal(this.location);
        this.location.x++;
        return this.map.getCharAtLoc(this.location);
    }

    /** Method that updates the hero's location based on them watning to go east
     * @return char of location on map
     */
    public char goEast(){
        if(this.location.y == 4){
            return this.map.getCharAtLoc(this.location);
        }
        this.map.reveal(this.location);
        this.location.y++;
        return this.map.getCharAtLoc(this.location);
    }

    /** Method that updates the hero's location based on them wanting to go west
     * @return char of location on map
     */
    public char goWest(){
        if(this.location.y == 0){
            return this.map.getCharAtLoc(this.location);
        }
        this.map.reveal(this.location);
        this.location.y--;
        return this.map.getCharAtLoc(this.location);
    }

    /**
     * Method to return the current gold of the hero
     * @return int gold of the hero
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * method that simulates the hero adding more gold to the gold 
     * instance variable
     * @param g the gold that shall be added to the current gold of the hero
     */
    public void collectGold(int g){
        this.gold += g;
    }

    /**
     * Method that simulates the hero spending gold
     * @param g the amount of gold that shall be taken away from the current amount of gold the hero has
     */
    public void spendGold(int g){
        this.gold -= g;
    }

    /**
     * Method to the find the first index of first armor item in inventory
     * @return the index of the first armor item in 
     * the inventory, -1 if not found.
     */
    public int hasArmorItem(){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getType() == 'a'){
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to get boolean 
     * @return boolean value of if key is in items or not
     */
    public boolean hasKey(){
        for (int i = 0; i < this.items.size(); i++){
            if (this.items.get(i).getType() == 'k'){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to remove the first occurance of the key in the hero's item inventory.
     */
    public void useKey(){
        for (int i = 0; i < this.items.size(); i++){
            if (this.items.get(i).getType() == 'k'){
                this.items.remove(i);
            }
        }
    }

    /** Method that handles magic missle attack, entity passed in hit with random number of damage
     * @param e the entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String magicMissile(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,6);
        e.takeDamage(randDamage);
        return getName() + " shoots a heatseaking missle at " + e.getName() + " for " + randDamage + " damage.";
    }

    /** Method that handles the fireball attack, entity passed in hit with random number of damage
     * @param e the entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String fireball(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,6);
        e.takeDamage(randDamage);
        return getName() + " emits a scorching fireball at " + e.getName() + " for " + randDamage + " damage.";
    }

    /** Method that handles the thunderclap attack, entity passed in hit with random number of damage 
     * @param e the entity to be attacked
     * @return String representation of what happens
     */
    @Override
    public String thunderclap(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,6);
        e.takeDamage(randDamage);
        return getName() + " zaps " + e.getName() + " with a thunder clap for " + randDamage + " damage.";
    }

    /** Method that handles non-magical attack, entity passed in hit with random number of damage
     * @param e the entity to be attacked 
     * @return String representation of what happens
     */
    @Override
    public String attack(Entity e) {
        int randDamage = ThreadLocalRandom.current().nextInt(1,6);
        e.takeDamage(randDamage);
        return getName() + " attacks " + e.getName() + " for " + randDamage + " damage";
    }
}