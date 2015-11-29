import java.util.ArrayList;
import java.util.Collections;


public class CardPile {
    private final int CARD_NUMBER = 52;
    private ArrayList<Card> cards;
    private int numCards;
    
    public CardPile(){
        cards = new ArrayList<Card>();
        numCards = 0;
    }
    
    public void addToBottom(Card c){
        cards.add(c);
        numCards++;
    }
    
    public boolean isEmpty(){
        return cards.isEmpty();
    }
    
    public Card get(int i){
        if(i>=this.numCards) return null;
        return cards.get(i);
    }
    
    public int getNumCards(){
        return this.numCards;
    }
    
    public Card remove(int i){
        if(i<0 || i>=this.numCards) return null;
        Card result = cards.get(i);
        cards.remove(i);
        numCards--;
        return result;
    }
    
    public int find(Suit s, Value v){
        for(int j=0; j<cards.size(); j++){
            if(cards.get(j).getSuit().equals(s) && cards.get(j).getValue().equals(v)){
                return j;
            }
        }
        return -1;
    }
    
    public String toString(){
        String result = "";
        for(int i=0; i<numCards; i++){
            result += "" + i + "." + cards.get(i).toString() + " ";
        }
        
        return result;
    }
    
    public static ArrayList<Card> makeFullDeck(){
        ArrayList<Card> cards = new ArrayList<Card>(52);
        for(Suit s : Suit.values()){
            for(Value v : Value.values()){
                Card c = new Card(s, v);
                cards.add(c);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }
    
    public static ArrayList<Card> makeFullDeck(int n){
        ArrayList<Card> cards = new ArrayList<Card>(52*n);
        ArrayList<Card> temp = new ArrayList<Card>(52);
        for(int i=0; i<n; i++){
            temp = makeFullDeck();
            cards.addAll(temp);
            temp = new ArrayList<Card>(52);
        }
        return cards;
    }
}
