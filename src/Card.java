public class Card {
  
    private final String[] SUITS = {"Hearts", "Spades", "Clubs", "Diamonds"};
    private final String[] RANKS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String suit;
    private String rank;

    public Card(){
        suit = SUITS[(int) Math.random() * 4];
        rank = RANKS[(int) Math.random() * 14];
    }

    public String getSuit(){
        //return the rank of the suit
        return suit;
    }

    public String getRank(){
        //return the rank of the card
        return rank;
    }

    public int returnValue() {
        if (rank == "J" || rank == "Q" || rank == "K"){
            return 10;
        }else if(rank == "A"){
            return 11;
        }else{
            return Integer.parseInt(rank);
        }
    }
    
    public String toString() {
        return rank + " of " + suit;
    }
}