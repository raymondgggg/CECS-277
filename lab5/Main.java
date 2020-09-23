public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        System.out.println(player.toString());
        player.sort();
        System.out.println(player.toString());
        System.out.println(player.getPoints());

        System.out.println(player.twoOfKind());
        System.out.println(player.threeOfKind());
        System.out.println(player.getPoints());

        player.setDice(1);
        System.out.println(player.threeOfKind());
        System.out.println(player.getPoints());
        
        player.setDice();
        System.out.println(player.series());
        System.out.println(player.getPoints());
    }
}
