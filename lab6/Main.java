public class Main{
    public static void main(String[] args) {
        System.out.println("Secret Decoder Ring:\n1.Encrypt\n2.Decrypt");
        int encryptOrDecrypt = CheckInput.getIntRange(1, 2);
        System.out.println("Enter Decryption Type:\n1.Atbash\nCaesar");
        int encryptionType = CheckInput.getIntRange(1, 2);
        if (encryptOrDecrypt == 1 && encryptionType == 1){
            System.out.print("Enter message: ");
        }

    }
}