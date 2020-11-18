// Raymond Guevara Lozano 
// Juan Anaya
// Group 2 - Lab 12
public class Main{
    /** Main method where the user is prompted to create one of three base monsters and then allowed to 
     *  decorate the monster with one of three abilities ranging from fire, poison, or lasers, program ends
     *  if user inputs 4 when asked to add abilities
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Monster Creator!");
        System.out.println("Choose a Base Monster:\n1. Alien\n2. Beast\n3. Vampire");
        int choice = CheckInput.getIntRange(1, 3);
        Monster monster;
        //instantiate proper monster based off user input
        if (choice == 1){
            monster = new AlienMonster();
        }
        else if (choice == 2){
            monster = new BeastMonster();
        }
        else{
            monster = new VampireMonster();
        }
        System.out.println(monster.getName() + " has " + monster.getHP() + " hp, and attacks for " + monster.attack() + " damage.");

        choice = 0;
        while (choice != 4){
            System.out.println("Add an abilitiy:");
            System.out.println("1. Fire\n2. Lasers\n3. Poison\n4. Quit");
            choice = CheckInput.getIntRange(1, 4);
            if (choice == 4){
                System.out.println("Exiting");
                break;
            }
                
            if (choice == 1) {
                Fire f = new Fire(monster, monster.getName(), monster.getHP());
                monster = f; // update the monster object to include the new abilities
                System.out.println(monster.getName() + " has " + monster.getHP() + " hp, and attacks for " + monster.attack() + " damage.");

            } else if (choice == 2) {
                Lasers l = new Lasers(monster, monster.getName(), monster.getHP());
                monster = l; //update the monster object to include the new abilities
                System.out.println(monster.getName() + " has " + monster.getHP() + " hp, and attacks for " + monster.attack() + " damage.");

            } else {
                Poison p = new Poison(monster, monster.getName(), monster.getHP());
                monster = p; //update the monster object to include the new abilities
                System.out.println(monster.getName() + " has " + monster.getHP() + " hp, and attacks for " + monster.attack() + " damage.");
            }
        }
    }
}