import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player(0); // start with full money
        boolean playAgain = true;

        while (playAgain) {
            Game game = new Game(player);
            game.startGame();

            System.out.println("\nPlay again? (1 = yes, 2 = no)");
            int choice = scanner.nextInt();

            if (choice != 1) {
                playAgain = false;
            } 
        }

        System.out.println("You leave with: " + player.getMoney());
    }
}