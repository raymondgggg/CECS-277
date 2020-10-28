import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> lList = readFile();
        printForward(lList);
        
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
                moveIter(iter, input.nextLine());
            }
            return lList;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void moveIter(ListIterator<String> iter, String word){
        boolean foundspot = false;
        while(foundspot == false){
            if(iter.hasNext() && (iter.hasPrevious() == false)){
                if(iter.next().compareTo(word) < 0){
                    iter.add(word);
                    foundspot = true;
                }
                else{
                    iter.previous();
                    iter.add(word);
                    foundspot = true;
                }
            }
            else if(iter.hasNext() && iter.hasPrevious()){
                if (iter.hasNext() && iter.next().compareTo(word) < 0);
                else {
                    iter.previous();
                }
                if (iter.hasPrevious() && iter.previous().compareTo(word) > 0);
                else {
                    iter.next();
                }
                if (iter.next().compareTo(word) > 0) {
                    iter.previous();
                    if (iter.previous().compareTo(word) < 0) {
                        iter.next();
                        iter.add(word);
                        foundspot = true;
                    } else {
                        iter.next();
                    }
                } else {
                    iter.previous();
                }
            }
            else if (iter.hasPrevious() == true && iter.hasNext() == false){
                if (iter.previous().compareTo(word) > 0){
                    iter.add(word);
                    foundspot = true;
                }else{
                    iter.next();
                    iter.add(word);
                    foundspot = true;
                }
            }
        }
    }

    public static void addWord(List<String> lList){
        ListIterator<String> iter =  (ListIterator<String>) lList.iterator();
        System.out.println("Add Word: ");
        String usrWord = CheckInput.getString();
        moveIter(iter, usrWord);
    }

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

    public static void printForward(LinkedList<String> lList){
        ListIterator<String> iter = (ListIterator<String>) lList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    public static void printReversed(LinkedList<String> lList){
        ListIterator<String> iter = (ListIterator<String>) lList.iterator();
        while(iter.hasNext()){
            iter.next();
        }
        while(iter.hasPrevious()){
            System.out.println(iter.previous());
        }
    }

    public static int menu(){
        System.out.println("1.Display Words\n2.Display Reversed Words\n3.Add Word\n4.Remove word\n5.Quit");
        int usrInput = CheckInput.getIntRange(1, 5);
        return usrInput;
    }
}