/**Class implementation of playing puppy */
public class PlayState implements PuppyState{
    /**
     * Method to represent playing state puppy going to eating state
     * @param puppy object
     */
    @Override
    public void eat(Puppy puppy) {
        System.out.println("The puppy stops playing and goes to the food that you have put out");
        puppy.setState(new EatState());
        puppy.incrementEatCount();
    }

    /**
     * Method to represent playing state puppy staying in playing state
     * @param puppy object
     */
    @Override
    public void play(Puppy puppy) {
        System.out.println("You throw the ball again and the puppy excitedly chases after it.");
        puppy.incrementPlayCount();

        if (puppy.getPlayCount() == 3) {
            System.out.println("The puppy has played so much that it has fallen asleep!");
            puppy.resetCounts();
            puppy.setState(new SleepState());
            return;
        }
    } 
}