/** Player Class - representation of player for dice game */
public class Player {
    /** Array of dice the player will use in game */
    private Die[] dice;
    /** points for the player that will be updated as game is played */
    private int points;

    /** Constructor - creates dice array and initializes points at
     *  start of game to zero
     * 
     */
    public Player(){
        dice = new Die[3];
        Die d;
        for (int i =0; i < dice.length; i++){
            d = new Die();
            dice[i] = d;
        }
        this.points = 0;
    }

    
    /** String representation of the dice array
     * @return String string of the die values for the game
     */
    public String toString(){
        String values = "";
        for (int d = 0; d < this.dice.length; d++){
            values += "D" + (d+1) + ": " + this.dice[d] + " ";
        }
        return values;
    }
    /**
     * Method to sort the die objects in dice array in non-decreasing order
     */
    public void sort(){
        for (int i = 0; i < this.dice.length; i++){
            int minIndex = i;
            for (int j = i + 1; j < this.dice.length; j++){
                if(this.dice[j].lessThan(this.dice[minIndex].getDieValue())){
                    minIndex = j;
                }
            }
            Die temp = this.dice[minIndex];
            this.dice[minIndex] = this.dice[i];
            this.dice[i] = temp;
        }
    }


}
