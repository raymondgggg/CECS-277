import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**Class that generates all Items from "ItemList.txt" and appends to ArrayList */
public class ItemGenerator {
    /**Arraylist of the items gotten from "ItemList.txt" */
    private ArrayList<Item> itemList;
    /**Singleton instance of the item generator */
    private static ItemGenerator igInstance = null; 

    /**Constructor - read the file that contains the list of items and 
     * appends all the items to the itemList
     */
    private ItemGenerator() {
        this.itemList = new ArrayList<Item>();
        File itemList = new File("ItemList.txt");
        try {
            Scanner items = new Scanner(itemList);
            while (items.hasNextLine()) {
                String line = items.nextLine();
                String [] arguments = line.split("[,]", 0);
                String name = arguments[0];
                int value = Integer.parseInt(arguments[1]);
                char type = arguments[2].toCharArray()[0];
                Item item = new Item(name, value, type);
                this.itemList.add(item);
            } //close scanner?
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** Method to randomly choose from the list of items and returns a new item
     * @return the item
     */
    public Item generateItem(){
        int randIndex = ThreadLocalRandom.current().nextInt(this.itemList.size());
        Item i = (Item) this.itemList.get(randIndex).clone();
        return i;
    }

    /**
     * Method to get potion
     * @return a new potion
     */
    public Item getPotion(){
        return new Item("Health Potion", 25, 'p');
    }

    /**
     * Method to get key
     * @return a new key
     */
    public Item getKey(){
        return new Item("Key", 50, 'k');
    }

    /**
     * Singleton method to get the insance of the item generator.
     * @return single item generator instance
     */
    public static ItemGenerator getInstance(){
        if (igInstance == null)
            igInstance = new ItemGenerator();
        return igInstance;
    }
}