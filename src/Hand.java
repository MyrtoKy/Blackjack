
import java.util.ArrayList;

public class Hand{
    private ArrayList <Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public int getTotalValue(){
        int value = 0;
        for(int i = 0; i<hand.size(); i++){
            value = value + hand.get(i).getValue();
        }
        return value;
    }

    public boolean hasBlackjack(){
        return getTotalValue() == 21;
    }

    public String toString(){
        return "The card dealt is a " + hand.get(hand.size() - 1);
    }
}