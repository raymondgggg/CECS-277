public class Cipher {
    protected char [] alphabet;
    
    public Cipher(){
        alphabet = new char[26];
        for (char c = 'a'; c <= 'z'; ++c){
            alphabet[c - 'a'] = c;
        }
    }

    public String encrypt(String msg){
        String encryptedMsg = "";
        for (int i = 0; i < msg.length(); ++i){
            encryptedMsg += encryptLetter(msg.charAt(i));
        }
        return encryptedMsg;
    }

    public String decrypt(String msg){
        String decryptedMsg = "";
        for (int i = 0; i < msg.length(); ++i){
            decryptedMsg += decryptLetter(msg.charAt(i));
        }
        return decryptedMsg;
    }

    protected char encryptLetter(char c){
        char [] reverseAlpha = new char[26];
        int location = 0;
        for (int i = 0; i < this.alphabet.length; ++i){
            reverseAlpha[i] = this.alphabet[alphabet.length - (i+1)];
            if (this.alphabet[i] == c){
                location = i;
            }
        }
        return reverseAlpha[location];
    }

    protected char decryptLetter(char c){
        char [] reverseAlpha = new char[26];
        int location = 0;
        for (int i = 0; i < this.alphabet.length; ++i) {
            reverseAlpha[i] = this.alphabet[alphabet.length - (i + 1)];
        }
        for (int i =0; i < reverseAlpha.length; ++i){
            if (reverseAlpha[i] == c){
                location = i;
            }
        }
        return this.alphabet[location];
    }
    
}
