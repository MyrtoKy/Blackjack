public class Card {
  
    private static final String[] SUITS = {"Hearts", "Spades", "Clubs", "Diamonds"};
    private static final String[] RANKS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private String suit;
    private String rank;

    public Card(String suit, String rank){
        this.suit = suit;
        this.rank =  rank;
    }

    public String getSuit(){
        //return the rank of the suit
        return suit;
    }

    public String getRank(){
        //return the rank of the card
        return rank;
    }

    //return the value of each card 
    //J,Q,K are 10 points
    //A is 10 or 11 (implemented in Deck class)
    //everything else is as is
    public int getValue() {
        return switch (rank) {
            case "J", "Q", "K" -> 10;
            case "A" -> 11;
            default -> Integer.parseInt(rank);
        };
    }   

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
