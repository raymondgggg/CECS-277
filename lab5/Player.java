import java.util.Arrays;

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

    
    /** Return the number of points the Player currently has in the game
     * @return int number of points the player currently has
     */
    public int getPoints(){
        return this.points;
    }

    
    /** Method for checking if all three dice values are the same, adds + 3 to points
     *  if all dice are the same
     * @return boolean value of true returned if all values are the same, false otherwise
     */
    public boolean threeOfKind(){
        boolean die1ToDie2 = this.dice[0].equals(this.dice[1].getDieValue());
        boolean die2ToDie3 = this.dice[1].equals(this.dice[2].getDieValue());
        if (die1ToDie2 && die2ToDie3){
            this.points += 3;
            return true;
        }
        return false;
    }

    
    /** Method for comparing if two of the dice in the array are the same
     *  updates player score by 1
     * @return boolean returns true of two values are the same, false otherwise
     */
    public boolean twoOfKind(){
        boolean die1ToDie2 = this.dice[0].equals(this.dice[1].getDieValue());
        boolean die2ToDie3 = this.dice[1].equals(this.dice[2].getDieValue());
        boolean die1ToDie3 = this.dice[0].equals(this.dice[2].getDieValue());
        if (die1ToDie2 || die2ToDie3 || die1ToDie3){
            this.points += 1;
            return true;
        }
        return false;
    }

    public boolean series(){
        int diceValues[] = {this.dice[0].getDieValue(), this.dice[1].getDieValue(), this.dice[2].getDieValue()};
        Arrays.sort(diceValues);
        if ((diceValues[1] - diceValues[0] == 1) && (diceValues[2] - diceValues[0] == 2)){
            this.points += 2;
            return true;
        }
        return false;
    }

    /** 
     * @param i
     */
    public void setDice(int i){
        for (int j = 0; j < this.dice.length; j++){
            this.dice[j].setDieValue(i);
        }

    }

    public void setDice() {
        for (int j = 0; j < this.dice.length; j++) {
            this.dice[j].setDieValue(j+1);
        }

    }











}
