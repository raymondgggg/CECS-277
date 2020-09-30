// Catherine Bui
// Quoc Ngo
// Raymond Guevara Lozano
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**Main class where the Cipher class and CaesarCipher class are all glued together
 * to make functioning program with input validation for Lab 6
 */
public class Main {
    /** Main method where the user is prompted with the choice of
     *  encrypting or decrypting and based off choices is allowed to input 
     *  that will be encrypted to file using either Atbash or Caesar Cipher, Or will
     *  decrypt using either Atbash or Caesar Cipher the text that is present in 
     *  "message.txt"
     * @param args No command line arguments take for this program
     */
    public static void main(String[] args) {
        System.out.println("Secret Decoder Ring:\n1.Encrypt\n2.Decrypt");
        int encryptOrDecrypt = CheckInput.getIntRange(1, 2);
        if (encryptOrDecrypt == 2){
            System.out.println("Enter Decryption Type:\n1.Atbash\n2.Caesar");
        }
        else{
            System.out.println("Enter Encryption Type:\n1.Atbash\n2.Caesar");
        }
        
        int encryptOrDecryptType = CheckInput.getIntRange(1, 2);

        if (encryptOrDecrypt == 1 && encryptOrDecryptType == 1) {
            System.out.print("Enter message: ");
            String message = CheckInput.getString();
            Cipher c = new Cipher();
            String encryptedMsg = c.encrypt(message);
            printToFile(encryptedMsg);
        }
        else if (encryptOrDecrypt == 1 && encryptOrDecryptType == 2){
            System.out.print("Enter message: ");
            String message = CheckInput.getString();
            System.out.print("Enter shift value: ");
            int shift = CheckInput.getIntRange(1,25);
            CaesarCipher cc = new CaesarCipher(shift);
            String encryptedMsg = cc.encrypt(message);
            printToFile(encryptedMsg);
        }
        else if (encryptOrDecrypt == 2 && encryptOrDecryptType == 1){
            String message = readFile();
            System.out.println("Reading encrypted message from \"message.txt\".");
            Cipher c = new Cipher();
            System.out.println("Decrypted Message: " + c.decrypt(message));
        }
        else if (encryptOrDecrypt == 2 && encryptOrDecryptType == 2){
            String message = readFile();
            System.out.println("Reading encrypted message from \"message.txt\"");
            System.out.print("Enter shift value: ");
            int shift = CheckInput.getIntRange(1,25);
            CaesarCipher cc = new CaesarCipher(shift);
            System.out.println("Decrypted Message: " + cc.decrypt(message));
        }

    }
    
    /** Method for printing the encrypted string to the file
     *  message.txt
     * @param encryptedMsg string that has been encrypted
     */
    public static void printToFile(String encryptedMsg){
        try {
            PrintWriter out = new PrintWriter("message.txt");
            out.println(encryptedMsg);
            System.out.println("Encrypted message saved to \"message.txt\".");
            System.out.println("Encrypted message written to file: " + encryptedMsg);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    /** Method for reading from the file "message.txt" and returning
     *  the encrypted text from the file so that it can be used in 
     *  the main method.
     * @return String that is in the file
     */
    public static String readFile(){
        File inputFile = new File("message.txt");
        try{
            Scanner input = new Scanner(inputFile);
            String message = input.nextLine();
            input.close();
            return message;
        } catch(FileNotFoundException e){
            e.printStackTrace();
            return null;// return value if there is no file
        }
     
    }
}