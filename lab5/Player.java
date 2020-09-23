public class Player {
    private Die[] dice;
    private int points;

    public Player(){
        dice = new Die[3];
        Die d;
        for (int i =0; i < dice.length; i++){
            d = new Die();
            dice[i] = d;
        }
    }

    public String toString(){
        String values = "";
        for (int d = 0; d < this.dice.length; d++){
            values += "D" + (d+1) + ": " + this.dice[d] + " ";
        }
        return values;
    }

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
