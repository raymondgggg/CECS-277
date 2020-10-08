import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**Class that generates all Items from "ItemList.txt" and appends to ArrayList */
public class ItemGenerator {
    /**Arraylist of the items gotten from "ItemList.txt" */
    private ArrayList<Item> itemList;

    /**Constructor - Generate all the items from "ItemList.txt" and append 
     * them to itemList ArrayList 
     */
    public ItemGenerator() {
        this.itemList = new ArrayList<Item>();
        Item i = generateItem();
        while(i != null){
            this.itemList.add(i);
            i = generateItem();
        }
    }

    /** Method to generate an individual item from "itemsList.txt file"
     * @return the item generated that was read from the file or null if there are
     * no items left
     */
    public Item generateItem(){
        File itemList = new File("ItemList.txt");
        try{
            Scanner items = new Scanner(itemList);
            while (items.hasNextLine()){
                String line = items.nextLine();
                Item item = new Item(line);
                boolean contains = false;
                for (int i = 0; i < this.itemList.size(); i++){
                    if (this.itemList.get(i).getName().equals(item.getName())){
                        contains = true;
                    }
                }
                if (contains){
                    continue;
                }
                return item;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}