import java.util.Scanner;

public class Game {
    Player player;
    Dealer dealer;
    Deck deck;
    boolean playing; 
    int decision;
    int playAgain;

    public Game(Player player){
        this.player = player;
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.playing = true;
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        this.deck = new Deck();
        this.dealer = new Dealer();
        player.resetHand();

        System.out.println("You have " + player.getMoney());
        System.out.println("Enter your bet:");
        int bet = scanner.nextInt();

        player.setBet(bet);
        player.setMoney(player.getMoney() - bet);

        // first card is dealt to the player
        player.getHand().addCard(deck.dealCard());
        System.out.println("Your first card: " + player.getHand());

        // next card goes to the dealer and is revealed
        dealer.getHand().addCard(deck.dealCard());
        System.out.println("Dealer's card: " + dealer.getHand());

        // player gets second card
        player.getHand().addCard(deck.dealCard());
        System.out.println("Your second card: " + player.getHand());

        // dealer gets hidden second card
        dealer.getHand().addCard(deck.dealCard());

        // print hands
        System.out.println("You have a total of: " + player.getHand().getTotalValue());

        System.out.println(checkForNatural());
        if (!playing) {
            return;
        }

        // continue game loop
        while (playing){
            System.out.println("Enter 1 for hit and 2 for stand");
            decision = scanner.nextInt();
            continueGame(decision);

            // check if player busts
            if (player.getHand().getTotalValue() > 21){
                System.out.println("Bust! You lose. You now have " + player.getMoney() + " left.");
                playing = false;
                return;
            }
        }

        // dealer plays
        dealer.playTurn(deck);
        System.out.println("Dealer final hand: " + dealer.getHand().getTotalValue());
        
        // determine winner
        int playerValue = player.getHand().getTotalValue();
        int dealerValue = dealer.getHand().getTotalValue();
        checkValues(playerValue, dealerValue);
    }

    public String checkForNatural(){
        if (player.getHand().hasBlackjack() && !dealer.getHand().hasBlackjack()){
            playing = false;
            player.addMoney(player.getBet() * 2.5);
            return "You won with Blackjack! You have " + player.getMoney() + " left.";
        } 
        else if(player.getHand().hasBlackjack() && dealer.getHand().hasBlackjack()){
            playing = false;
            player.addMoney(player.getBet());
            return "It's a tie! You have " + player.getMoney() + " left.";
        } 
        else if(dealer.getHand().hasBlackjack()){
            playing = false;
            return "You lost! The dealer had blackjack. You have " + player.getMoney() + " left.";
        }else if(player.getHand().getTotalValue() > 21){
            playing = false;
            return "Bust! You lose. You now have " + player.getMoney() + " left.";
        }
        else{
            return "Hit or stand?";
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

    public void checkValues(int playerValue, int dealerValue){
        if(playerValue > 21){
            System.out.println("Bust! You lose. You now have " + player.getMoney() + " left.");
            playing = false;
            return;
        }
        if (dealerValue > 21 || playerValue > dealerValue){
            player.addMoney(player.getBet()*2);
            System.out.println("You win! You now have " + player.getMoney() + " left.");
            playing = false;
        } else if (playerValue < dealerValue){
            System.out.println("You lose! You now have " + player.getMoney() + " left.");
            playing = false;
        } else {
            player.addMoney(player.getBet());
            System.out.println("It's a tie! You have " + player.getMoney() + " left.");
            playing = false;
        }
    }
}