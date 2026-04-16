public class Dealer {
    private Hand hand;

    public Dealer() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public String toString() {
        return "Dealer has " + hand;
    }

    public void playTurn(Deck deck) {
    while (hand.getTotalValue() < 17) {
        hand.getCard(deck.dealCard());
    }
}
}