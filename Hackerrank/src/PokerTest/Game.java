// add your own banner here
package PokerTest;
import java.util.*;
public class Game {
	
	private Player p;
	private Deck cards;
	private ArrayList<Card> playerCard;
	private String[] display = new String[5];
	// you'll probably need some more here
	private boolean pair=false, twoPairs =false, threeOfAKind = false, straight = false, flush =false,fullHouse = false,
					fourOfaKind = false, straightFlush = false, royalFlush = false;
	
	public Game(String[] testHand){
		playerCard = new ArrayList<>();
		p = new Player();
		playerCard=toCardArray(testHand);
		System.out.println(this.checkHand(playerCard));
		// This constructor is to help test your code
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
		
	}
	
	public Game(){
		cards = new Deck();
		p = new Player();
		playerCard= new ArrayList<>();

		// This no-argument constructor is to actually play a normal game
		
	}
	
	public void play(){

		cards.shuffle();

		for (int i=0;i<5;i++){
			Card temp =cards.deal();
			p.addCard(temp);
			String str = temp.toString();
			display[i] = str;
		}
		p.sortCards();
		displayCards();

		Scanner input = new Scanner(System.in);
		System.out.println("\nHow much do you want to bet?");
		int bet = input.nextInt();
		p.bets(bet);
		System.out.println("How many cards do you want to draw? ");
		int numDraw = input.nextInt();
		for (int i =0;i<numDraw;i++){
			System.out.println("Which card do you want to draw? 1-5");
			int d = input.nextInt();
			Card temp = cards.deal();
			String str = temp.toString();
			p.replaceCard(d-1,temp);

			display[d-1] = str;
		}
		p.sortCards();
		displayCards();
		toCardArray(display);
		System.out.println("\n"+this.checkHand(playerCard));
		System.out.printf("You got %.2f in baniroll",p.getBankroll() );
		// this method should play the game	
	}
	
	public String checkHand(ArrayList<Card> hand){
		for (int i = 0; i<4; i++) {
		if (hand.get(i).getRank() == hand.get(i+1).getRank()
				&& (i<1||hand.get(i-1).getRank()!=hand.get(i).getRank())
				&& (i>2||hand.get(i+2).getRank()!=hand.get(i).getRank())) {
			if (pair == true) {
				twoPairs = true;

			}

			pair = true;

		}

		if ((i<2) && hand.get(i).getRank() == hand.get(i+1).getRank() && hand.get(i+1).getRank()
				== hand.get(i+2).getRank() && hand.get(i+2) == hand.get(i+3)) {
			fourOfaKind = true;
		}

		if (!fourOfaKind && (i<3) && hand.get(i).getRank() == hand.get(i+1).getRank()
				&& hand.get(i+1).getRank() == hand.get(i+2).getRank()) {
			threeOfAKind = true;

		}
		if ((i<1) && (hand.get(i+4).getRank()==13 && hand.get(i).getRank()==1||
				hand.get(i).getRank() + 1 == hand.get(i+1).getRank())
				&& hand.get(i+1).getRank() +1 == hand.get(i+2).getRank() &&
				hand.get(i+2).getRank() +1 == hand.get(i+3).getRank() &&
				hand.get(i+3).getRank() +1 == hand.get(i+4).getRank()) {

			straight=true;
		}
		if ((i<1) && hand.get(i).getSuit() == hand.get(i+1).getSuit() &&
				hand.get(i+1).getSuit() == hand.get(i+2).getSuit() &&
				hand.get(i+2).getSuit() == hand.get(i+3).getSuit() &&
				hand.get(i+3).getSuit() == hand.get(i+4).getSuit()) {
			flush = true;
			if (straight == true) {
				straightFlush = true;
				royalFlush = hand.get(0).getRank() == 1 && hand.get(1).getRank() == 10;
			}

		}
	}

	fullHouse= threeOfAKind & pair;


	if (royalFlush){
			p.winnings(250);
			return "Royal Flush!";
		}
		if (straightFlush){
			p.winnings(50);
			return "Straight Flush!";
		}

		if (fourOfaKind){
			p.winnings(25);
			return "Four of a kind!!";
		}
		if (fullHouse){
			p.winnings(6);
			return "Full House!";
		}
		if (flush){
			p.winnings(5);
			return "Flush!";
		}
		if (straight){
			p.winnings(4);
			return "Straight!";
		}
		if (threeOfAKind){
			p.winnings(3);
			return "Three of a kind!";
		}
		if (twoPairs){
			p.winnings(2);
			return "Two Pairs!";
		}
		if (pair){
			p.winnings(1);
			return "One Pair!";
		}
		else
			return "No Pair";
	}

		// this method should taie an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		

	public void displayCards(){
		display = p.toArrayString();
		for (int i=0;i<5;i++){
			System.out.print(display[i]+" ");
		}
	}
	public ArrayList<Card> toCardArray(String[] str){

		ArrayList<Card> card = new ArrayList<>();
		for (int i = 0;i<str.length;i++){
			int suit =0;
			int rani = Integer.parseInt(str[i].substring(1));
			switch (str[i].charAt(0)){
				case 'c':
					suit = 1;
					Card temp = new Card(suit,rani);
					card.add(temp);
					continue;
				case 'd':
					suit = 2;
					temp = new Card(suit,rani);
					card.add(temp);
					continue;
				case 'h':
					suit = 3;
					temp = new Card(suit,rani);
					card.add(temp);
					continue;
				case 's':
					suit = 4;
					temp = new Card(suit,rani);
					card.add(temp);
					continue;
			}



		}
		return card;
	}

	
	
	// you will liiely want many more methods here
	// per discussion in class
}
