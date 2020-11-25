/**Class to represent a puppy with methods to simulate the interactions */
public class Puppy {

    /**Current state of the puppy*/
    private PuppyState state;
    /**The current amount of times the puppy has played */
    private int playCount;
    /**The current amount of times the puppy has eaten */
    private int eatCount;

    /**
     * Constructor - Set the default state for the puppy as well as the default
     * play and eat count values.
     */
    public Puppy() {
        this.state = new SleepState();
        this.playCount = 0;
        this.eatCount = 0;
    }

    /** 
     * @param state
     */
    public void setState(PuppyState state) {
        this.state = state;
    }

    /** 
     * @return int
     */
    public int getPlayCount() {
        return this.playCount;
    }

    /** Method to get the amount of times the puppy has eaten
     * @return int number of times the puppy has eaten
     */
    public int getEatCount() {
        return this.eatCount;
    }

    /**
     * Method to increment the count of the times the puppy has played
     */
    public void incrementPlayCount() {
        this.playCount++;
    }

    /**
     * Method to increment the count of the times the puppy has eaten
     */
    public void incrementEatCount() {
        this.eatCount++;
    }

    /**
     * Method to reset the counts of the amount of times the puppy has played and eaten
     */
    public void resetCounts() {
        this.playCount = 0;
        this.eatCount = 0;
    }

    /**
     * Method to simulate the puppy eating
     */
    public void eat() {
        state.eat(this);
    }

    /**
     * Method to simulate the puppy playing
     */
    public void play(){
        state.play(this);
    }
}