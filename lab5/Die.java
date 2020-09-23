/**Die Class - representation of a single die
 */
public class Die{
    /** The number of sides of this die */
    private int sides;
    /** The value of this die */
    private int dieValue;

    /** Default Constructor - creates a six-sided die.
     */
    public Die(){
        this.sides = 6;
        roll();
    }

    /** Constructor - rolls to give the die an initial value
     *  @param s Sets the nubmer of sides of this die
     */
    public Die(int s){
        if(s > 1){
            this.sides = s;
        }
        else{
            this.sides = 6;
        }
        roll();
    }

    /** Rolls the die
     * @return int
     */
    public int roll(){
        this.dieValue = (int) (Math.random() * sides) + 1;
        return this.dieValue;
    }

    /** Retrieve the die's value
     * @return int
     */
    public int getDieValue(){
        return this.dieValue;
    }

    /** Allows the value of the die to be set to a particular 
     *  value as long as it is within the number of sides.
     * @param value The value the die will be set to
     * @return boolean True if the value could be set, false otherwise.
     */
    public boolean setDieValue(int value){
        if(value > 0 && value <= this.sides){
            this.dieValue = value;
            return true;
        }
        return false;
    }

    /** String representation of a Die object 
     * @return String representation of this Die
     */
    public String toString(){
        return "" + this.dieValue;
    }

    /** Equals method to check if dieValue is equal to value 
     * @param value Parameter to check equality
     * @return boolean return value true if dieValue == value, false otherwise.
     */
    public boolean equals(int value){
        if (this.dieValue == value){
            return true;
        }
        return false;
    }

    /** Method to test if value parameter is less that the dieValue
     * @param value Parameter to check if Die value less than value
     * @return boolean return value true if dieValue < value, false otherwise
     */
    public boolean lessThan(int value){
        if (this.dieValue < value){
            return true;
        }
        return false;
    }
}