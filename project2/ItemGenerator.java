import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**Class that generates all Items from "ItemList.txt" and appends to ArrayList */
public class ItemGenerator {
    /**Arraylist of the items gotten from "ItemList.txt" */
    private ArrayList<Item> itemList;

    /**Constructor - read the file that contains the list of items and 
     * appends all the items to the itemList
     */
    public ItemGenerator() {
        this.itemList = new ArrayList<Item>();
        File itemList = new File("ItemList.txt");
        try {
            Scanner items = new Scanner(itemList);
            while (items.hasNextLine()) {
                String line = items.nextLine();
                Item item = new Item(line);
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
        Item i = new Item(this.itemList.get(randIndex).getName());
        return i;
    }
}