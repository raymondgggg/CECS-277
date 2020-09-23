/** Player Class - representation of player for dice game */
public class Player {
    /** Array of dice the player will use in game */
    private Die[] dice;
    /** points for the player that will be updated as game is played */
    private int points;

    /** Constructor - creates dice array and initializes points at
     *  start of game to zero
     */
    public Player(){
        this.dice = new Die[3];
        Die d;
        for (int i =0; i < dice.length; i++){
            d = new Die();
            this.dice[i] = d;
        }
        this.points = 0;
    }

    /** String representation of the dice array
     * @return String representation of the dice values for the game
     */
    public String toString(){
        String values = "";
        for (int d = 0; d < this.dice.length; d++){
            values += "D" + (d+1) + "=" + this.dice[d] + ",";
        }
        return values;
    }

    /**Method to sort the die objects in dice array in non-decreasing order
     * based of the die values
     */
    public Die[] sort(){
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
        return this.dice;
    }

    /** Return the number of points the Player currently has in the game
     * @return points the player currently has
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
     *  updates player points by 1 if true
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

    /** Method for checking if the dice values are in a consecutive sequence with 
     *  one another updates player points by 2 if true
     * @return boolean value true if values are in sequence, false otherwise
     */
    public boolean series(){
        sort(); //sorting dice by values then comparing differences
        int die2To1Difference = this.dice[1].getDieValue() - this.dice[0].getDieValue();
        int die3To2Difference = this.dice[2].getDieValue() - this.dice[0].getDieValue();
        if ((die2To1Difference == 1) && (die3To2Difference == 2)){
            this.points += 2;
            return true;
        }
        return false;
    }

    /**method for rolling the dice, prints the values
     * using toString() and determines whether player 
     * met any of the win conditions
     */
    public void takeTurn(){
        for (int i = 0; i < this.dice.length; i++) {
            this.dice[i].roll();
        }
        sort();
        System.out.println("Rolling Dice..." + this.toString());
        if (threeOfKind()) {
            System.out.println("You got three of a kind!");
            System.out.println("Score = " + this.points + " point(s)");
        }
        else if (twoOfKind()){
            System.out.println("You got a pair!");
            System.out.println("Score = " + this.points + " point(s)");
        }
        else if(series()){
            System.out.println("You got a series of 3!");
            System.out.println("Score = " + this.points + " point(s)");
        }
        else{
            System.out.println("Awww. Too Bad.");
            System.out.println("Score = " + this.points + " point(s)");
        }
    }
}