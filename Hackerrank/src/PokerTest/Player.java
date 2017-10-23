// add your own banner here
package PokerTest;
import java.util.*;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
        private double bet;

	// you may choose to use more instance variables
		
	public Player(){
        hand = new ArrayList<>();
        this.bankroll=10;
        this.bet=0;
	    // create a player here
	}

	public void addCard(Card c){
        hand.add(c);
	    // add the card c to the player's hand
	}

	public void removeCard(Card c){
        hand.remove(c);
	    // remove the card c from the player's hand
        }
    public void replaceCard(int index, Card c){
        hand.set(index,c);
    }
		
        public void bets(double amt){
            if (amt<bankroll){
                this.bet = amt;
                bankroll-=bet;
            }
            // player makes a bet
        }

        public void winnings(double odds){
            this.bankroll+=odds*bet;
            //	adjust bankroll if player wins
        }

        public double getBankroll(){
            return this.bankroll;
            // return current balance of bankroll
        }
    public void sortCards(){
        for (int i =0;i<5;i++){
            for (int j = 0; j<4; j++) {
                int result = hand.get(j).compareTo(hand.get(j+1));
                if (result>0){
                    Card temp=hand.get(j);
                    hand.set(j,hand.get(j+1));
                    hand.set(j+1, temp);
                }
            }
        }
    }
    public String[] toArrayString(){
        String display[] = new String[hand.size()];
        for (int i =0;i<hand.size();i++){
            String str = hand.get(i).toString();
            display[i] = str;
        }
        return display;
    }


        // you may wish to use more methods here
}


