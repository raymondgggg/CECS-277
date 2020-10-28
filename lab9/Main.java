import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    }

    public static List<String> readFile(){
        File inputFile = new File("words.txt");
        List<String> lList = new LinkedList<>();
        try{
            Scanner input = new Scanner(inputFile);
            

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void moveIter(ListIterator<String> iter){

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