import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
/**Main class where linked list is made from read file */
public class Main {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<String> lList = readFile();
        printForward(lList);
    }

    
    /** Method to read in the file "words.txt" and create linkedlist sorted
     * @return LinkedList<String> sorted linked list
     */
    public static LinkedList<String> readFile(){
        File inputFile = new File("words.txt");
        LinkedList<String> lList = new LinkedList<String>();
        ListIterator<String> iter;
        try{
            Scanner input = new Scanner(inputFile);
            lList.add(input.nextLine());
            iter = (ListIterator<String>) lList.iterator();
            while (input.hasNextLine()){
                String word = input.nextLine().toLowerCase();
                moveIter(iter, word.toLowerCase());
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
        if(iter.hasPrevious()){
            iter.previous();
        }

        while(iter.hasPrevious() && iter.previous().compareTo(word) >= 0);
        if(iter.hasNext()){
            iter.next();
        }
    }
    

    
    /** 
     * @param lList
     */
    public static void addWord(List<String> lList){
        ListIterator<String> iter =  (ListIterator<String>) lList.iterator();
        System.out.println("Add Word: ");
        String usrWord = CheckInput.getString();
        moveIter(iter, usrWord);
    }

    
    /** 
     * @param lList
     */
    public static void removeWord(List<String> lList){
        ListIterator<String> iter = (ListIterator<String>) lList.iterator();
        System.out.println("Remove Word: ");
        String usrstring = CheckInput.getString();
        while(iter.hasNext()){
            if (iter.next().equals(usrstring)){
                iter.remove();
            }
        }

    }

    
    /** 
     * @param lList
     */
    public static void printForward(LinkedList<String> lList){
        ListIterator<String> iter = (ListIterator<String>) lList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    
    /** 
     * @param lList
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

    
    /** 
     * @return int
     */
    public static int menu(){
        System.out.println("1.Display Words\n2.Display Reversed Words\n3.Add Word\n4.Remove word\n5.Quit");
        int usrInput = CheckInput.getIntRange(1, 5);
        return usrInput;
    }
}