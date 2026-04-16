import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your bet:");
        int bet = scanner.nextInt();

        Game game = new Game(bet);
        game.startGame();
    }
}