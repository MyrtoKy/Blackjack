
import java.util.ArrayList;

public class Hand{
    private ArrayList <Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public int getTotalValue() {
        int total = 0;
        int aceCount = 0;

        for (Card card : hand) {
            total += card.getValue();

            if (card.getRank().equals("A")) {
            aceCount++;
            }
        }

        // Adjust Aces from 11 → 1 if needed
        while (total > 21 && aceCount > 0) {
            total -= 10; // convert one Ace from 11 → 1
            aceCount--;
        }

        return total;
    }

     public boolean hasBlackjack() {
        return hand.size() == 2 && getTotalValue() == 21; // must be exactly 2 cards
    }

    public String toString(){
        return "    " + hand.get(hand.size() - 1);
    }
}