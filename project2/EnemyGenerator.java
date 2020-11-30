import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**class to generate enemies read from files */
public class EnemyGenerator {
    /**list of enemies read from the file */
    private ArrayList<Enemy> enemyList;
    /**items read from item file */
    private ItemGenerator ig;

    private static EnemyGenerator egInstance = null;
    /**Constructor - read the file and creat new enemy based off whether 
     * or not they are magical, add random health bump to enemy.
     */
    private EnemyGenerator(ItemGenerator ig){
        this.ig = ig;
        this.enemyList = new ArrayList<>();
        File enemyList = new File("EnemyList.txt");
        try{
            Scanner enemy = new Scanner(enemyList);
            while(enemy.hasNextLine()){
                int randHealthBump = ThreadLocalRandom.current().nextInt(5);
                String line = enemy.nextLine();
                String[] values = line.split(",");
                String name = values[0];
                int health = Integer.parseInt(values[1]) + randHealthBump;
                String type = values[2];
                if (type.equals("m")){
                    Enemy me = new MagicalEnemy(name, health, ig.generateItem());
                    this.enemyList.add(me);
                }
                else{
                    Enemy e = new Enemy(name, health, ig.generateItem());
                    this.enemyList.add(e);
                }
            }
        }   
        catch(FileNotFoundException e){
            e.printStackTrace();
        }     
    }

    
    /** Method to randomly choose from enemyList and create new enemy based off the randomly chosen enemy
     *  return the new enemy
     * @return Enemy randomly chosen from template
     */
    public Enemy generateEnemy(){
       int randIndex = ThreadLocalRandom.current().nextInt(this.enemyList.size());
       if (this.enemyList.get(randIndex) instanceof MagicalEnemy){
           Enemy e = new MagicalEnemy(this.enemyList.get(randIndex).getName(), this.enemyList.get(randIndex).getMaxHP(),
                   this.enemyList.get(randIndex).getItem());
            return e;
       }
       Enemy e = new Enemy(this.enemyList.get(randIndex).getName(), this.enemyList.get(randIndex).getMaxHP(),
               this.enemyList.get(randIndex).getItem());
        return e;
    }

    /**
     * Singleton method to return instance of the enemyGene
     * @param ig item generator needed for the item of the enemey
     * @return instance of enemy generator
     */
    public static EnemyGenerator getInstance(ItemGenerator ig){
        if (egInstance == null)
            egInstance = new EnemyGenerator(ig);
        return egInstance;
    }
    
}