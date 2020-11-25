/**Class implementation of puppy that is eating */
public class EatState implements PuppyState{

    /**Method to represent eating state puppy that will eat again 
     * @param puppy object
    */
    @Override
    public void eat(Puppy puppy) {
        System.out.println("The puppy continues to eat as you add another scoop of kibble to its bowl.");
        puppy.incrementEatCount();

        if (puppy.getEatCount() == 3) {
            System.out.println("The goof ball has eaten so much that it has fallen asleep.");
            puppy.resetCounts();
            puppy.setState(new SleepState());
            return;
        }
    }

    /**
     * Method to represent eating state puppy going to playing state
     * @param puppy object
     */
    @Override
    public void play(Puppy puppy) {
        System.out.println("The puppy looks up from its food and chases the ball you threw.");
        puppy.setState(new PlayState());
        puppy.incrementPlayCount();
    }
}