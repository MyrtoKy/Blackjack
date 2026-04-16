
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
   private ArrayList <Card> deck;

   public Deck() {
        deck = new ArrayList<>(52);
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};
        String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        for(int i =0; i<suits.length; i++){
            for(int j = 0; j<ranks.length; j++){
                deck.add(new Card(suits[i], ranks[j])); //creates a new instance for each card and
            }                                               //adds it to the deck
        }
    }

    //shuffles the deck
    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        return deck.remove(0); // removes top card
    }
}
