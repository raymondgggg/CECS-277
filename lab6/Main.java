import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Cipher c = new Cipher();
        System.out.println(c.encrypt("apple"));
        System.out.println(c.decrypt("zkkov"));
    }
}