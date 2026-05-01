public class Player{
    private Hand hand;
    private double money;
    private double bet;

    public Player(double bet){
        hand = new Hand();
        money = 100; //all players have a standard buy-in of 100
        this.bet = bet;
        money -= bet; 
    }

    public Hand getHand() {
        return hand;
    }

    public void resetHand() {
        this.hand = new Hand();
    }

    public double getMoney(){
        return money;
    }

    public void setMoney(double m){
        money = m;
    }

    public void addMoney(double m){
        money += m;
    }

     public double getBet(){
        return bet;
    }

    public void setBet (double newBet){
        bet = newBet;
    }

    public void hit(Deck deck){
        hand.addCard(deck.dealCard());
        System.out.println(hand);
        hand.toString();
        int total = hand.getTotalValue();
        System.out.println("You now have a total of " + total);
    }

    public String stand(){
        return "You stand with " + hand.getTotalValue();
    }
}