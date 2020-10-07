public class Tabby extends Cat{

    public Tabby(String n){
        super(n);
    }

    @Override
    public String feed(Player p) {
        String catStatus;
        if (getHunger() >= 1 && getHunger() <= 4){ 
            catStatus = toString() + " and starts eating the food";
            incrementHunger(2);
            return catStatus;
        }
        else if(getHunger() >= 5 && getHunger() <= 7){ 
            catStatus = toString() + ", but still eats the food";
            incrementHunger(2);
            return catStatus;
        }
        int damage = 2;
        catStatus = toString() + ", and attacks you. You take " + damage + " damage";
        p.takeDamage(damage);
        incrementHunger(-2);
        return catStatus; 
    }

    @Override
    public String play(Player p) {
        String catStatus;
        int damage = 2;
        if (getHunger() >= 8 && getHunger() <= 10){
            catStatus = toString() + ", and just rolls over to entertain you for your wishes";
            incrementHunger(-2);
            return catStatus;
        }
        else if (getHunger() >= 5 && getHunger() <= 7){
            catStatus = getName() + " jumps and knocks over a lamp that hits you in the head, you take " + damage + " damage";
            incrementHunger(-2);
            p.takeDamage(damage);
            return catStatus;
        }
        catStatus = toString() + " and attacks you for being a horrible owner, you take " + damage + " damage";
        p.takeDamage(damage);
        incrementHunger(-2);
        return catStatus;
    }

    @Override
    public String pet(Player p) {
        String catStatus;
        int damage = 2;
        if (getHunger() >= 1 && getHunger() <= 4){
            catStatus = toString() + ", and attacks you, you take " + damage + " damage";
            p.takeDamage(damage);
            incrementHunger(-2);
            return catStatus;
        }
        else if (getHunger() >= 5 && getHunger() <= 7){
            catStatus = toString() + ", and lets you pet them.";
            incrementHunger(-2);
            return catStatus;
        }
        catStatus = toString() + ", and has fallen asleep.";
        incrementHunger(-2);
        return catStatus;
    }
    
}
