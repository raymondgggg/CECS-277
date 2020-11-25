/**State interface to represent the differnt actions that can be done with puppy */
public interface PuppyState {
    /**
     * Method to represent what it's like to feed puppy
     * @param puppy object
     */
    public void eat(Puppy puppy);

    /**
     * Method to represent what it's like to play with puppy
     * @param puppy object
     */
    public void play(Puppy puppy);
}