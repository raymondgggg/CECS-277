// Group 4
// Andressa Murakami
// Raymond Guevara Lozano 

/**Main class where all other classes are brought in to make cat game */
public class Main{
    /** Main method where Player is prompted to choose Cat and give Cat name
     *  instantiates type of Cat based off what Player chooses and does 
     *  repeated Player and Cat interactions until Player dies.
     * @param args no command line arguments given
     */
    public static void main(String[] args) {
      System.out.println("Choose a kitty: ");
      System.out.println("1.Tabby Cat\n2.Ocelot\n3.Tiger");
      int catChoice = CheckInput.getIntRange(1, 3);
      System.out.println("Name your kitty: ");
      String catName = CheckInput.getString();

      Player p = new Player();
      Cat cat; 
      if (catChoice == 1){
          cat = new Tabby(catName);
      }
      else if (catChoice == 2){
          cat = new Ocelot(catName);
      }
      else{
          cat = new Tiger(catName);
      }

      do{
        interactCat(cat, p);
      }
      while(p.isDead() == false);
      System.out.println("You have died :(");    
    }

    /** Method that includes all the logic for repeated interactions between the Player and 
     *  the Cat
     * @param c the Cat that will be used for the game
     * @param p the Player of the game
     */
    public static void interactCat(Cat c, Player p){
        System.out.println(p.toString());
        System.out.println(c.toString());
        System.out.println("1.Feed your cat\n2.Play with your cat\n3.Pet your cat");
        int pChoice = CheckInput.getIntRange(1, 3);
        String result;
        if(pChoice == 1){
            result = c.feed(p);
            System.out.println(result);
        }
        else if (pChoice == 2){
            result = c.play(p);
            System.out.println(result);
        }
        else{
            result = c.pet(p);
            System.out.println(result);
        }
    }
}