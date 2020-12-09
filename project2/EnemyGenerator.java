import java.util.concurrent.ThreadLocalRandom;
/**class to generate enemies read from files */
public class EnemyGenerator {
    /**items read from item file */
    private ItemGenerator ig = ItemGenerator.getInstance();

    private static EnemyGenerator egInstance = null;
    /**Constructor - No longer reads from file, will initlize the 
     * ItemGenerator so that we can use it when we randomly generate one
     * of the four base enemies and decorate as needed in the generate 
     * enemy method
     */
    private EnemyGenerator(){
    }

    /** Method to randomly choose from enemyList and create new enemy based off the randomly chosen enemy
     *  return the new enemy
     * @return Enemy randomly chosen from template
     */
    public Enemy generateEnemy(int lvl){
       Enemy[] baseEnemies = {new Troll(), new Froglok(),
                                new Orc(), new Goblin()};
        
       int randEnemyIndex = ThreadLocalRandom.current().nextInt(baseEnemies.length);
    
       Enemy enemy = baseEnemies[randEnemyIndex];
       if(lvl == 1)
           return enemy;
       int decorateChoice = ThreadLocalRandom.current().nextInt(2); // 0 for Warrior, 1 for Warlock
       // decorate with either warrior or warlock for each level greater than one
       for (int i = 1; i < lvl; i++){
           if (decorateChoice == 0){
               Warrior warrior = new Warrior(enemy);
               enemy = warrior;
           }
           else{
               Warlock warlock = new Warlock(enemy);
               enemy = warlock;
           }
       }
       return enemy;
    }

    /**
     * Singleton method to return instance of the enemyGene
     * @param ig item generator needed for the item of the enemey
     * @return instance of enemy generator
     */
    public static EnemyGenerator getInstance(){
        if (egInstance == null)
            egInstance = new EnemyGenerator();
        return egInstance;
    }
}