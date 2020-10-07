public abstract class Cat {
    private String name;
    private int hunger;

    public Cat(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public int getHunger(){
        return this.hunger;
    }

    protected int incrementHunger(int val){

    }

    @Override
    public String toString(){
        return name + 
    }