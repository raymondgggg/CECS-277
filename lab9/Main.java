// Kevin Garcia Julca
// Prince Angulo
// Raymond Guevara Lozano
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
/**Main class where linked list is made from read file, and 
 * user is given various menu options with respect to linked list
*/
public class Main {
    /** Main method where the user is prompted to choose what they want 
     *  to do with the linked list, repeats until user chooses to leave
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> lList = readFile();
        int input = 0;
        do{
            input = menu();
            if (input == 1){
                printForward(lList);
                System.out.println();
            }
            else if(input == 2){
                printReversed(lList);
                System.out.println();
            }
            else if (input == 3){
                addWord(lList);
                System.out.println();
                
            }
            else if (input == 4){
                removeWord(lList);
                System.out.println();
            }
        } while (input != 5);
    }

    /** Method to read in the file "words.txt" and create linkedlist sorted
     * @return LinkedList<String> sorted linked list
     */
    public static LinkedList<String> readFile(){
        File inputFile = new File("words.txt");
        try{
            LinkedList<String> lList = new LinkedList<String>();
            ListIterator<String> iter;
            Scanner input = new Scanner(inputFile);
            lList.add(input.nextLine());
            iter = (ListIterator<String>) lList.iterator();
            while (input.hasNextLine()){
                String word = input.nextLine();
                moveIter(iter, word);
                iter.add(word);
            }
            return lList;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    /** Method to move the iterator based on the position of the word
     * @param iter iterator
     * @param word word to be compared
     */
    public static void moveIter(ListIterator<String> iter, String word){
        while(iter.hasNext() && iter.next().compareTo(word) <= 0);
        iter.previous();
        while (iter.hasPrevious() && iter.previous().compareTo(word) >= 0);
        iter.next();
    }
    
    /** Method for the user to add in word to linked list
     * @param lList the linked list
     */
    public static void addWord(List<String> lList){
        ListIterator<String> iter =  (ListIterator<String>) lList.iterator();
        System.out.println("Add Word: ");
        String usrWord = CheckInput.getString();
        moveIter(iter, usrWord);
        iter.add(usrWord);
    }

    /** Method for the user to remove word from linkList
     * @param lList
     */
    public static void removeWord(List<String> lList){
        ListIterator<String> iter = (ListIterator<String>) lList.iterator();
        System.out.println("Remove Word: ");
        String usrstring = CheckInput.getString();
        while(iter.hasNext()){
            if (iter.next().equals(usrstring)){
                iter.remove();
                return;
            }
        }
        System.out.println("sorry word not in list");
    }

    /** Method to print the list in sorted order
     * @param lList linked list
     */
    public static void printForward(LinkedList<String> lList){
        ListIterator<String> iter = (ListIterator<String>) lList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    /** Method to print the list in reverse order
     * @param lList linked list
     */
    public static void printReversed(LinkedList<String> lList){
        ListIterator<String> iter = (ListIterator<String>) lList.iterator();
        while(iter.hasNext()){
            iter.next();
        }
        while(iter.hasPrevious()){
            System.out.println(iter.previous());
        }
    }

    /** Method to print out the menu options for the user and get input
     * @return int the choice of the user
     */
    public static int menu(){
        System.out.println("1.Display Words\n2.Display Reversed Words\n3.Add Word\n4.Remove word\n5.Quit");
        int usrInput = CheckInput.getIntRange(1, 5);
        return usrInput;
    }
}