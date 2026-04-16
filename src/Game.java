import java.util.Scanner;

public class Game {
    Player player;
    Dealer dealer;
    Deck deck;
    boolean playing; 
    int decision;

    public Game(int bet){
        player = new Player(bet);
        deck = new Deck();
        dealer = new Dealer();
        playing = true;
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        // first card is dealt to the player
        player.getHand().addCard(deck.dealCard());

        // next card goes to the dealer and is revealed
        dealer.getHand().addCard(deck.dealCard());

        // player gets second card
        player.getHand().addCard(deck.dealCard());

        // dealer gets hidden second card
        dealer.getHand().addCard(deck.dealCard());

        // print hands
        System.out.println("Your hand: " + player.getHand());
        System.out.println("Dealer has: " + dealer.getHand());

        System.out.println(checkForNatural());

        // if blackjack happened, stop
        if (!playing) return;

        // continue game loop
        while (playing){
            System.out.println("Enter 1 for hit and 2 for stand");
            decision = scanner.nextInt();
            continueGame(decision);

            // check if player busts
            if (player.getHand().getTotalValue() > 21){
                System.out.println("Bust! You lose.");
                return;
            }
        }

        // dealer plays
        dealer.playTurn(deck);
        System.out.println("Dealer final hand: " + dealer.getHand());

        // determine winner
        int playerValue = player.getHand().getTotalValue();
        int dealerValue = dealer.getHand().getTotalValue();

        if (dealerValue > 21 || playerValue > dealerValue){
            System.out.println("You win!");
        } else if (playerValue < dealerValue){
            System.out.println("You lose!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public String checkForNatural(){
        if (player.getHand().hasBlackjack() && !dealer.getHand().hasBlackjack()){
            playing = false;
            return "You won with Blackjack!";
        } 
        else if(player.getHand().hasBlackjack() && dealer.getHand().hasBlackjack()){
            playing = false;
            return "It's a tie!";
        } 
        else if(dealer.getHand().hasBlackjack()){
            playing = false;
            return "You lost! The dealer had blackjack";
        }
        else{
            return "You have a total of " + player.getHand().getTotalValue() + ". Hit or stand?";
        }
    }

    public void continueGame(int decision){
        if (decision == 1){
            player.hit(deck);
        } else {
            System.out.println(player.stand());
            playing = false;
        }
    }
}