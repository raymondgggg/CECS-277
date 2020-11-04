import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
/** Main class where all the methods are stored to make program run */
public class Main {
    /** 
     * @param args takes no command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Mind Reader!");
        String input = getInput();
        HashMap<String, Integer> prevEntries = new HashMap<>();
        String patternString = "";
        do{
            if (patternString.length() == 4) {
                storePattern(prevEntries, patternString);
                patternString = patternString.substring(1);
            }
            String prediction = makePrediction(prevEntries, patternString);
            System.out.println("Comp: " + prediction);
            patternString += input;
        }while(input.equals("Q") == false);
    }

    /** Method to make a prediction of what the user will input by looking at hashmap and checking to see
     *  if there are any familiar patterns
     * @param prevEntries Hashmap that will be used to try and predict user input
     * @param patternString past 4 entries of the user
     * @return String literal that the computer predicted
     */
    public static String makePrediction(HashMap<String,Integer> prevEntries, String patternString){
        String [] randomChoice = {"X", "O"};
        if (patternString.length() < 4)
            return randomChoice[ThreadLocalRandom.current().nextInt(2)];

        String lastThreeValues = patternString.substring(1);
        String xPrediction = lastThreeValues + "X";
        String oPrediction = lastThreeValues + "O";
        String returnedString;
        if ((prevEntries.containsKey(xPrediction) == false) && (prevEntries.containsKey(oPrediction) == false))
            return randomChoice[ThreadLocalRandom.current().nextInt(2)];

        if (prevEntries.containsKey(xPrediction) && prevEntries.containsKey(oPrediction)){
            if (prevEntries.get(xPrediction) > prevEntries.get(oPrediction))
                returnedString = xPrediction.substring(3);
            else
                returnedString = oPrediction.substring(3);
        }
        else if(prevEntries.containsKey(xPrediction) && prevEntries.containsKey(oPrediction) == false){
            returnedString = xPrediction.substring(3);
        }
        else {
            returnedString = oPrediction.substring(3);
        }
        return returnedString;
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
            prevEntries.put(patternString, ++prevCount);
            return;
        }
        prevEntries.put(patternString, 1);
    }
}