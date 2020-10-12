import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int level = 0;
        int [] levels = {1,2,3};
        System.out.print("What is your name traveler? ");
        String name = CheckInput.getString();
        Map map = new Map();
        map.loadMap(levels[level % levels.length]);
        Hero hero = new Hero(name, map);
        ItemGenerator ig = new ItemGenerator();
        EnemyGenerator eg = new EnemyGenerator(ig);
        int usrChoice = 0;

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
            else {
                break;
            }
            
            // while(monsterRoom(hero, map, eg, level) && fight(hero, eg.generateEnemy()));

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
        System.out.println("You've encountered a " + e.getName() + "\n" + e.toString());
        System.out.println("1. Fight\n2. Run Away");
        int usrinput = CheckInput.getIntRange(1, 2);
        if(usrinput == 1){
            return true;
        }
        return false;
    }

    public static void itemRoom(Hero h, Map m, ItemGenerator ig){

    }
}