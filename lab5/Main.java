public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        System.out.println(player.toString());
        player.sort();
        System.out.println(player.toString());
        System.out.println(player.getPoints());
    }
}
