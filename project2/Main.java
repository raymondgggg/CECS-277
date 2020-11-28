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
        int level = 0; //level++ to move on to next level
        int[] levels = { 1, 2, 3 }; //store level numbers in array

        //load in necessary components needed for the game
        Map map = new Map();
        map.loadMap(levels[level % levels.length]); // use modulus operator to get num from [0-2] for index of levels array
        Hero hero = new Hero(name, map);
        ItemGenerator ig = new ItemGenerator();
        EnemyGenerator eg = new EnemyGenerator(ig);

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
            }
            //Item room
            else if (map.getCharAtLoc(hero.getLocation()) == 'i'){
                itemRoom(hero, map, ig);
            }
            //Monster room
            else if (monsterRoom(hero, map, eg, levels[level % levels.length])){
                Enemy e = eg.generateEnemy();
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
                System.out.println("Next level:\n");
                level++;
                map.loadMap(levels[level % levels.length]);
                hero.heal(hero.getMaxHP());
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
        if (e instanceof Magical){ //check if the Enemy e is a MagicalEnemy, if so downcast to use methods for MagicalEnemy
            e = (MagicalEnemy) e;
        }
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
                    System.out.println(e.attack(h));
                }
            }
            else if (attack == 2){
                System.out.println(Magical.MAGIC_MENU);
                int magicAttack = CheckInput.getIntRange(1, 3);
                if(magicAttack == 1){
                    System.out.println(h.magicMissile(e));
                    if (e.getHP() > 0){
                        System.out.println(e.attack(h));
                    }
                }
                else if (magicAttack == 2){
                    System.out.println(h.fireball(e));
                    if (e.getHP() > 0){
                        System.out.println(e.attack(h));
                    }
                }
                else {
                    System.out.println(h.thunderclap(e));
                    if (e.getHP() > 0){
                        System.out.println(e.attack(h));
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
            if(h.getLocation().x == 0 && h.getLocation().y == 0){
                int runLocation = ThreadLocalRandom.current().nextInt(1,3);
                if (runLocation == 1){
                    h.goSouth();
                }
                else{
                    h.goEast();
                }
            }
            else if(h.getLocation().x == 0 || h.getLocation().y == 4){
                int runLocation = ThreadLocalRandom.current().nextInt(1,3);
                if (runLocation == 1) {
                    h.goWest();
                } else {
                    h.goSouth();
                }
            }
            else if (h.getLocation().x == 4 && h.getLocation().y == 0){
                int runLocation = ThreadLocalRandom.current().nextInt(1, 3);
                if (runLocation == 1) {
                    h.goNorth();
                } else {
                    h.goEast();
                }
            }
            else if (h.getLocation().x == 4 && h.getLocation().y == 4) {
                int runLocation = ThreadLocalRandom.current().nextInt(1, 3);
                if (runLocation == 1) {
                    h.goNorth();
                } else {
                    h.goWest();
                }
            }
            else{
                int runLocation = ThreadLocalRandom.current().nextInt(1,5);
                if (runLocation == 1){
                    h.goNorth();
                }
                else if (runLocation == 2){
                    h.goSouth();
                }
                else if (runLocation == 3){
                    h.goWest();
                }
                else{
                    h.goEast();
                }
            }
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
}