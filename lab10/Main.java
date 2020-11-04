import java.util.HashMap;
/** Main class where all the methods are stored to make program run */
public class Main {
    /** 
     * @param args takes no command line arguments
     */
    public static void main(String[] args) {
    
    }

    /** 
     * @param prevEntries
     * @param patternString
     */
    public static void makePrediction(HashMap<String,Integer> prevEntries, String patternString){
        
    }

    /** 
     * Method to prompt the user to enter the input for the prediction game, has input validation 
     * to make sure the input is either X, O, or Q
     * @return String literal of the user input
     */
    public static String getInput(){
        System.out.println("Enter X or O, or Q to quit.");
        System.out.print("?: ");
        String input = CheckInput.getString().toUpperCase();
        boolean validInput = false;
        while(validInput == false){
            if (input.equals("X") || input.equals("O") || input.equals("Q")){
                validInput = true;
                continue;
            }
            System.out.println("Invalid Input, enter either X or O, or Q to quit.");
            System.out.print("?: ");
            input = CheckInput.getString().toUpperCase();
        }
        return input;
    }

    /**
     * Method to store the patter based off the given pattern string, if patternstring already in 
     * map, then the count of associated with the key is updated, otherwise, new entry is created and count is
     * set to 1.
     */
    public static void storePattern(HashMap<String, Integer> prevEntries, String patternString){
        if (prevEntries.containsKey(patternString)){
            int prevCount = prevEntries.get(patternString);
            prevEntries.put(patternString, prevCount++);
            return;
        }
        prevEntries.put(patternString, 1);
    }
}