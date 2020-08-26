import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String zipCode = getZip();
        System.out.println();
        printBarCode(zipCode);
    }

    public static void printBarCode(String zip){
        int sum = getSum(zip);
        int checkDigit = calcCheckDigit(sum);
        int digit;
        System.out.print("|");
        for (int i = 0; i < zip.length(); i++){
            digit = Integer.parseInt(String.valueOf(zip.charAt(i))); // get the individial int value of the zipcode string 
            printDigit(digit);
        }
        printDigit(checkDigit);
        System.out.println("|");
    }

    public static int calcCheckDigit(int sum){ // method to calculate the check digit
        int roundUp = ((sum / 10) * 10) + 10;
        int checkDigit = roundUp - sum;
        return checkDigit;
    }

    public static int getSum(String zipCode){// method to get the sum of the zipcode digits
        int digit;
        int sum = 0;
        for(int i = 0; i < zipCode.length(); i++){
            digit = Integer.parseInt(String.valueOf(zipCode.charAt(i))); // gets individual digit as int value
            sum += digit;
        }
        return sum;
    }

    public static String getZip(){ // method to prompt user for zip code and return code as string
        Scanner usrInput = new Scanner(System.in);
        System.out.print("Please enter your five digit zip code: ");
        String usrZip = usrInput.nextLine();
        usrInput.close();
        return usrZip;
    }

    public static void printDigit(int d){ // method to print the barcode for corresponding digit 
        if(d == 0){
            System.out.print("||...");
        }
        else if (d == 1){
            System.out.print("...||");
        }
        else if (d == 2){
            System.out.print("..|.|");
        }
        else if (d == 3){
            System.out.print("..||.");
        }
        else if (d == 4){
            System.out.print(".|..|");
        }
        else if (d == 5){
            System.out.print(".|.|.");
        }
        else if (d == 6){
            System.out.print(".||..");
        }
        else if (d == 7){
            System.out.print("|...|");
        }
        else if (d == 8){
            System.out.print("|..|.");
        }
        else if (d ==9){
            System.out.print("|.|..");
        }
    }
}