/**Abstract MonsterDecorator class that will add to the Monster object as needed */
public abstract class MonsterDecorator extends Monster{
    /**Instance variable to the monster object */
    private Monster monster;
    /**Constructor that calls super constructor 
     * and initilizes the Instance variable
     * @param monster - the monster object
     * @param name - the new name of the monster
     * @param hp - the new hp of the monster
     * */
    public MonsterDecorator(Monster monster,String name, int hp) {
        super(name, hp);
        this.monster = monster;
    }

    /**
     * @return int attack value of the monster
     */
    @Override
    public int attack(){
        return this.monster.attack();
    }
}
