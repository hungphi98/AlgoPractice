package PokerTest;

public class PokerTest{

    //this class must remain unchanged
    //your code must work with this test class
 
    public static void main(String[] args){
        String[] royalFlush = {"s1","s10","s11","s12","s13"};
        Game g = new Game(royalFlush);
        String[] straightflush = {"s1","s2","s3","s4","s5"};
        Game g1 = new Game(straightflush);
        String[] fourofakind = {"s1","c1","h1","d1","s3"};
        Game g2 = new Game(fourofakind);
        String[] fullhouse = {"s12","h12","d12","d13","s13"};
        Game g3 = new Game(fullhouse);
        String[] flush = {"s1","s3","s6","s7","s10"};
        Game g4 = new Game(flush);
        String[] straight = {"s1","d2","h3","c4","d5"};
        Game g5 = new Game(straight);
        String[] threeofakind = {"s1","d3","s3","h3","c13"};
        Game g6 = new Game(threeofakind);
        String[] twopairs = {"s1","c3","h3","c5","s5"};
        Game g7 = new Game(twopairs);
        String[] onepair = {"s1","c3","h3","c5","s10"};
        Game g8 = new Game(onepair);
        String[] nopair = {"s1","s3","c5","h8","d12"};
        Game g9 = new Game(nopair);
    }


}
