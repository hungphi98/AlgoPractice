package PokerTest;// add your own banner here

import java.util.*;

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank

	public Card(int s, int r){
		this.suit=s;
		this.rank =r;
		//make a card with suit s and value v
	}
	@Override
	public int compareTo(Card c){
		if (this.getRank() > c.getRank())
			return 1;
		else if (this.getRank() < c.getRank())
			return -1;
		else
			return 0;

		// use this method to compare cards so they 
		// may be easily sorted

	}
	
	public String toString(){
		String str = this.getSuit()+String.valueOf(rank);
		return str;
		// use this method to easily print a Card object
	}
	public Character getSuit(){
		switch (this.suit){
			case 1:
				return 'c';
			case 2:
				return 'd';
			case 3:
				return 'h';
			case 4:
				return 's';
		}
		return null;
	}
	public int getRank(){
		return this.rank;
	}

	// add some more methods here if needed

}
