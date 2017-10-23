// add your own banner here
package PokerTest;

import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){
		cards = new Card[52];
		int count =0;
		for (int i=1;i<5;i++){
			for (int j =1; j<14;j++){
				cards[count] = new Card(i,j);
				++count;
			}
		}

		// make a 52 card deck here
	}
	
	public void shuffle(){
		int index;
		Card temp;
		Random rnd = new Random();
		for (int i= cards.length-1;i>0;i--){
			index = rnd.nextInt(i+1);
			temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
		top=0;
		// shuffle the deck here
	}
	
	public Card deal(){
		Card topDeck = cards[top];
		top++;
		if (top==52) this.shuffle();
		return topDeck;
		// deal the top card in the deck
	}
	
	// add more methods here if needed

}
