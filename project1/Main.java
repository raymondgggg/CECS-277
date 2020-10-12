import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        System.out.print("What is your name traveler? ");
        String name = CheckInput.getString();
        int usrChoice = 0;
        int level = 0;
        int[] levels = { 1, 2, 3 };
        Map map = new Map();
        map.loadMap(levels[level % levels.length]);
        Hero hero = new Hero(name, map);
        ItemGenerator ig = new ItemGenerator();
        EnemyGenerator eg = new EnemyGenerator(ig);

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

            if (monsterRoom(hero, map, eg, levels[level % levels.length])){
                Enemy e = eg.generateEnemy();
                System.out.println("You've encountered a " + e.getName());
                while(fight(hero, e));
                if (e.getHP() == 0) {
                    map.removeCharAtLoc(hero.getLocation());
                }
            }
        
            if (map.getCharAtLoc(hero.getLocation()) == 'f') {
                System.out.println("Next level:");
                level++;
                map.loadMap(levels[level % levels.length]);
                hero.heal(25);
            }
            
        }while(hero.getHP() != 0);
        System.out.println("Game Over");
    }

    public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level){
        if (m.getCharAtLoc(h.getLocation()) == 'm'){
            return true;
        }
        return false;
    }

    public static boolean fight(Hero h, Enemy e){
        System.out.println(e.toString());
        System.out.println("1. Fight\n2. Run Away");
        int usrinput = CheckInput.getIntRange(1, 2);
        if(usrinput == 1){
            System.out.println("1.Physical Attack\n2.Magical Attack");
            int attack = CheckInput.getIntRange(1, 2);
            if (attack == 1){
                System.out.println(h.attack(e));
                System.out.println(e.attack(h));
            }
            else if (attack == 2){
                System.out.println("1.Magic Missle\n2.Fireball\n3.Thunderclap");
                int magicAttack = CheckInput.getIntRange(1, 3);
                if(magicAttack == 1){
                    System.out.println(h.magicMissile(e));
                    System.out.println(e.attack(h));
                }
                else if (magicAttack == 2){
                    System.out.println(h.fireball(e));
                    System.out.println(e.attack(h));
                }
                else {
                    System.out.println(h.thunderclap(e));
                    System.out.println(e.attack(h));
                }
            }
            if (e.getHP() <= 0) {
                System.out.println("You defeated " + e.getName());
                h.pickUpItems(e.getItem());

                return false;
            }
            return true;
        }
        else{ //move hero to valid adjacent room randomly
            if(h.getLocation().x == 0 || h.getLocation().x == 4){
                int runLocation = ThreadLocalRandom.current().nextInt(1,3);
                if (runLocation == 1){
                    h.goEast();
                }
                else{
                    h.goWest();
                }
            }
            else if(h.getLocation().y == 4 || h.getLocation().y == 0){
                int runLocation = ThreadLocalRandom.current().nextInt(1,3);
                if (runLocation == 1) {
                    h.goNorth();
                } else {
                    h.goSouth();
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
    }

    public static void itemRoom(Hero h, Map m, ItemGenerator ig){

    }
}