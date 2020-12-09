// Group 2
// Juan Anaya
// Raymond Guevara Lozano 
import java.util.concurrent.ThreadLocalRandom;
//**Main class where all components are glued together to make game */
public class Main {
    /** Main method where all previously made methods and classes are brought together to
     *  make the game run
     * @param args no command line arguments for this program
     */
    public static void main(String[] args) {
        System.out.print("What is your name traveler? ");
        String name = CheckInput.getString();
        int usrChoice = 0;//directional choice for the game
        int level = 1; //level++ to move on to next level
        int[] levels = { 1, 2, 3 }; //store map numbers in array

        //load in necessary components needed for the game
        Map map = Map.getInstance();
        map.loadMap(levels[(level-1) % levels.length]); // use modulus operator to get num from [0-2] for index of levels array
        Hero hero = new Hero(name, map);
        ItemGenerator ig = ItemGenerator.getInstance();
        EnemyGenerator eg = EnemyGenerator.getInstance(ig);

        //loop where the game takes place, prints out hero info and looks through map for 'm', 'i', or 'n'
        //to use appropriate methods for rooms
        do{
            System.out.println(hero.toString());
            map.displayMap(hero.getLocation());
            System.out.println("1. Go North\n2. Go South\n3. Go East\n4. Go West\n5. Quit");

            usrChoice = CheckInput.getIntRange(1, 5);
            if (usrChoice == 1){
                hero.goNorth();
            }
            else if (usrChoice == 2){
                hero.goSouth();
            }
            else if (usrChoice == 3){
                hero.goEast();
            }
            else if (usrChoice == 4){
                hero.goWest();
            }
            else if (usrChoice == 5){
                break;
            }
            //returning to the start
            if (map.getCharAtLoc(hero.getLocation()) == 's'){
                System.out.println("You are back at the start.");
                store(hero);
            }
            //Item room
            else if (map.getCharAtLoc(hero.getLocation()) == 'i'){
                itemRoom(hero, map, ig);
            }
            //Monster room
            else if (monsterRoom(hero, map, eg, levels[(level-1) % levels.length])){
                Enemy e = eg.generateEnemy(level);
                System.out.println("You've encountered a " + e.getName());

                while(fight(hero, e));
                if (e.getHP() == 0) {
                    map.removeCharAtLoc(hero.getLocation());
                }
            }
            //Empty room
            else if(map.getCharAtLoc(hero.getLocation()) == 'n'){
                System.out.println("There was nothing here.");
            }
            //Final spot of map, move onto next map
            else if (map.getCharAtLoc(hero.getLocation()) == 'f') {
                if (hero.hasKey()){
                    level++;
                    System.out.println("Next level: " + level + "\n");
                    map.loadMap(levels[(level - 1) % levels.length]);
                    hero.heal(hero.getMaxHP());
                    hero.useKey();
                }
                else{
                    System.out.println("You need a key to move forward, seek out a key and then return.");
                    moveHero(hero);
                }
            }
        }while(hero.getHP() != 0);
        //display messages for when game is over
        if (hero.getHP() <= 0){
            System.out.println("Game Over. You died");
        }
        else{
            System.out.println("Game Over.");
        }
    }

    /** Method to detect if room hero is currently in is a monster room, returns boolean 
     *  value true if room is monster room, false otherwise.
     * @param h the hero of the game
     * @param m the map the hero is currently in 
     * @param eg object to generate enemies
     * @param level current level 
     * @return boolean value if room is monster room
     */
    public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level){
        if (m.getCharAtLoc(h.getLocation()) == 'm'){
            return true;
        }
        return false;
    }

    /** Method to handle all the logic associated with the hero and monster fighting. Returns 
     *  true if hero chooses to fight, false if hero dies or if hero runs away. 
     * @param h the hero
     * @param e the enemy the hero is fighting
     * @return boolean value if fight is happening
     */
    public static boolean fight(Hero h, Enemy e){
        // if (e instanceof Magical){ 
        //     e = (MagicalEnemy) e;
        // }
        System.out.println(e.toString());
        int usrinput = 0;
        if (h.hasPotion()){
            System.out.println("1. Fight\n2. Run Away\n3. Drink Health Potion");
            usrinput = CheckInput.getIntRange(1, 3);
        }else{
            System.out.println("1. Fight\n2. Run Away");
            usrinput = CheckInput.getIntRange(1, 2);
        }

        if(usrinput == 1){
            System.out.println("1.Physical Attack\n2.Magical Attack");
            int attack = CheckInput.getIntRange(1, 2);
            if (attack == 1){
                System.out.println(h.attack(e));
                if (e.getHP() > 0){
                    if (h.hasArmorItem() != -1){
                        System.out.println("Your armor blocks " + e.getName() + "'s attack.");
                        h.dropItem(h.hasArmorItem());
                    }
                    else{
                        System.out.println(e.attack(h));
                    }
                }
            }
            else if (attack == 2){
                System.out.println(Magical.MAGIC_MENU);
                int magicAttack = CheckInput.getIntRange(1, 3);
                if(magicAttack == 1){
                    System.out.println(h.magicMissile(e));
                    if (e.getHP() > 0){
                        if (h.hasArmorItem() != -1) {
                            System.out.println("Your armor blocks " + e.getName() + "'s attack.");
                            h.dropItem(h.hasArmorItem());
                        } else {
                            System.out.println(e.attack(h));
                        }
                    }
                }
                else if (magicAttack == 2){
                    System.out.println(h.fireball(e));
                    if (e.getHP() > 0){
                        if (h.hasArmorItem() != -1) {
                            System.out.println("Your armor blocks " + e.getName() + "'s attack.");
                            h.dropItem(h.hasArmorItem());
                        } else {
                            System.out.println(e.attack(h));
                        }
                    }
                }
                else {
                    System.out.println(h.thunderclap(e));
                    if (e.getHP() > 0){
                        if (h.hasArmorItem() != -1) {
                            System.out.println("Your armor blocks " + e.getName() + "'s attack.");
                            h.dropItem(h.hasArmorItem());
                        } else {
                            System.out.println(e.attack(h));
                        }
                    }
                }
            }
            if (e.getHP() <= 0) {
                System.out.println("You defeated " + e.getName());
                h.pickUpItems(e.getItem());
                return false;
            }
            if (h.getHP() <= 0){
                return false;//hero dead, fight() = false
            }
            return true;
        }
        else if (usrinput == 2){ //move hero to valid adjacent room randomly
            moveHero(h);
            return false;
        }
        else{
            h.drinkPotion();
            return true;
        }
    }

    /** Method to handle the logic asssociated with going into an item room,
     *  Hero picks up item if inventory has space otherwise is prompted if they want to pick up item
     *  and drop item in inventory of their choice to get new item
     * @param h the hero
     * @param m the map
     * @param ig ItemGenerator to get random item for room
     */
    public static void itemRoom(Hero h, Map m, ItemGenerator ig){
        boolean itemTaken = h.pickUpItems(ig.generateItem());
        if (itemTaken){
            m.removeCharAtLoc(h.getLocation());
        }
    }

    /**
     * Method to handle all the interactions with returning to start and going into
     * the store
     * 
     * @param h hero
     */
    public static void store(Hero h) {
        ItemGenerator ig = ItemGenerator.getInstance();
        System.out.println("You are at now at the store:");
        System.out.println("Your Gold: " + h.getGold());
        System.out.println("1. Buy Items\n2. Sell Items\n3. Exit store");
        int usrChoice = CheckInput.getIntRange(1, 3);
        while (true) {
            if (usrChoice == 1) {
                if (h.getGold() < ig.getPotion().getValue()) {
                    System.out.println("You do not have enough gold to purchase any items, sell items "
                            + "or adventure some more to get more gold.");
                } else {
                    System.out.println("1. Health Potion - 25 gold\n2. Key - 50 gold");
                    usrChoice = CheckInput.getIntRange(1, 2);
                    if (usrChoice == 1) {
                        h.spendGold(ig.getPotion().getValue());
                        h.pickUpItems(ig.getPotion());
                    } else if (usrChoice == 2 && h.getGold() >= 50) {
                        h.spendGold(ig.getKey().getValue());
                        h.pickUpItems(ig.getKey());
                    } else { // case when hero trys to buy key without enough gold
                        System.out.println("You do not have enough gold to buy a key.");
                    }
                }
            } else if (usrChoice == 2) {
                int numItems = h.getNumItems();
                if (numItems == 0) {
                    System.out.println("You have no items.");
                } else {
                    h.itemsToString();
                    System.out.println("Which of your items would you like to sell?");
                    System.out.println(h.itemsToString());
                    usrChoice = CheckInput.getIntRange(1, h.getNumItems());
                    Item soldItem = h.dropItem(usrChoice - 1);
                    System.out.println(
                            "You have sold your " + soldItem.getName() + " for " + soldItem.getValue() + " gold.");
                    h.collectGold(soldItem.getValue());
                }
            } else {
                System.out.println("You are now leaving the store.");
                moveHero(h);
                break;
            }
            System.out.println("Your Gold: " + h.getGold());
            System.out.println("1. Buy Items\n2. Sell Items\n3. Exit store");
            usrChoice = CheckInput.getIntRange(1, 3);
        }
    }

    /**
     * Helper method to move hero to valid adjacent room in the instance when 
     * they run away from enemy or when they choose to leave the store.
     * @param h hero that will be moved to new spot on the map
     */
    public static void moveHero(Hero h){
        if (h.getLocation().x == 0 && h.getLocation().y == 0) {
            int runLocation = ThreadLocalRandom.current().nextInt(1, 3);
            if (runLocation == 1) {
                h.goSouth();
            } else {
                h.goEast();
            }
        } else if (h.getLocation().x == 0 || h.getLocation().y == 4) {
            int runLocation = ThreadLocalRandom.current().nextInt(1, 3);
            if (runLocation == 1) {
                h.goWest();
            } else {
                h.goSouth();
            }
        } else if (h.getLocation().x == 4 && h.getLocation().y == 0) {
            int runLocation = ThreadLocalRandom.current().nextInt(1, 3);
            if (runLocation == 1) {
                h.goNorth();
            } else {
                h.goEast();
            }
        } else if (h.getLocation().x == 4 && h.getLocation().y == 4) {
            int runLocation = ThreadLocalRandom.current().nextInt(1, 3);
            if (runLocation == 1) {
                h.goNorth();
            } else {
                h.goWest();
            }
        } else {
            int runLocation = ThreadLocalRandom.current().nextInt(1, 5);
            if (runLocation == 1) {
                h.goNorth();
            } else if (runLocation == 2) {
                h.goSouth();
            } else if (runLocation == 3) {
                h.goWest();
            } else {
                h.goEast();
            }
        }
    }
}