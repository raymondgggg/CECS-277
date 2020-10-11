import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class EnemyGenerator {
    private ArrayList<Enemy> enemyList;
    private ItemGenerator ig;

    public EnemyGenerator(ItemGenerator ig){
        this.ig = new ItemGenerator();
        this.enemyList = new ArrayList<Enemy>();
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
                    MagicalEnemy me = new MagicalEnemy(name, health, ig.generateItem());
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

    public Enemy generateEnemy(){
       int randIndex = ThreadLocalRandom.current().nextInt(this.enemyList.size());
       Enemy e = new Enemy(this.enemyList.get(randIndex).getName(), this.enemyList.get(randIndex).getMaxHP(),
               this.enemyList.get(randIndex).getItem());
        return e;
    }
    
}