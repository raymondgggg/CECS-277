import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readFile();
    }

    public static LinkedList<String> readFile(){
        File inputFile = new File("words.txt");
        LinkedList<String> lList = new LinkedList<String>();
        ListIterator<String> iter;
        try{
            Scanner input = new Scanner(inputFile);
            lList.add(input.nextLine());
            iter = (ListIterator<String>) lList.iterator();
            while (input.hasNextLine()){
                
            }
            return lList;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void moveIter(ListIterator<String> iter, String word){
        boolean foundSpot = false;
        while (foundSpot == false){
            if(iter.next().compareTo(word) < 0);
            else{
                iter.previous();
            }
            if(iter.n)
            
        }
    }

    public static void addWord(List<String> lList){

    }

    public static void removeWord(List<String> lList){

    }

    public static void printReversed(List<String> lList){

    }

    public static int menu(){
        System.out.println("1.Display Words\n2.Display Reversed Words\n3.Add Word\n4.Remove word\n5.Quit");
        int usrInput = CheckInput.getIntRange(1, 5);
        return usrInput;
    }
}