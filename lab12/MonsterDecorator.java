public abstract class MonsterDecorator extends Monster{
    private Monster monster;
    
    public MonsterDecorator(Monster monster,String name, int hp) {
        super(name, hp);
        
    }

    
}
