import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Cipher c = new Cipher();
        System.out.println(c.encrypt("RAYMOND guevara"));
        System.out.println(c.decrypt("IZBNLMW TFVEZIZ"));

        CaesarCipher cc = new CaesarCipher(1);
        System.out.println(cc.encrypt("aabbcc"));
        System.out.println(cc.decrypt("bbccdd"));
       
    }
}