public class CaesarCipher extends Cipher{
    private int shift;

    public CaesarCipher(int s){
        super();
        this.shift = s;
    }

    protected char encryptLetter(char c){
        char encryptedChar = (char) (((int) c + this.shift - 65) % 26 + 65);
        return encryptedChar;
    }

    protected char decryptLetter(char c){
        char encryptedChar = (char) (((int) c - this.shift - 65) % 26 + 65);
        return encryptedChar;
    }
        
}
