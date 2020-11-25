/**Class implementation of Sleeping state for puppy */
public class SleepState implements PuppyState{
    /**
     * Method to simulate what happens when you try to feed dog when dog is in
     * sleeping state
     * @param puppy object
     */
    @Override
    public void eat(Puppy puppy) {
        System.out.println("The puppy awakens from its slumber and runs to the food ready to eat.");
        puppy.setState(new EatState());
        puppy.incrementEatCount();
    }

    /**
     * Method to simulate what happens when you try to play when dog when it is in
     * sleeping state
     * @param puppy object 
     */
    @Override
    public void play(Puppy puppy) {
        System.out.println("The puppy is asleep enjoying its wonderful dreams, it currently does not have the desire to play with you right now.");
    }
}
