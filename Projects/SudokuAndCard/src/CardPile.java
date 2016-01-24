
public class CardPile {
    private final int CARD_NUMBER = 52;
    private Card[] cards;
    private int numCards;
    
    public CardPile(){
        cards = new Card[CARD_NUMBER];
        for(int i=0; i<CARD_NUMBER; i++){
            cards[i] = null;
        }
        numCards = 0;
    }
    
    public void addToBottom(Card c){
        for(int i=0; i<cards.length; i++){
            if(cards[i] == null){
                cards[i]=c;
                numCards++;
                break;
            }
        }
    }
    
    public boolean isEmpty(){
        for(int i=0; i<this.cards.length; i++){
            if(cards[i]!=null){
                return false;
            }
        }
        return true;
    }
    
    public Card get(int i){
        if(i>=this.numCards) return null;
        return cards[i];
    }
    
    public Card remove(int i){
        if(i<0 || cards[i]==null) return null;
        Card result = cards[i];
        for(int j=i; j<numCards; j++){
            cards[i] = cards[i+1];
        }
        cards[numCards-1] = null;
        numCards--;
        return result;
    }
    
    public int find(Suit s, Value v){
        for(int j=0; j<numCards; j++){
            if(cards[j].getSuit().equals(s) && cards[j].getValue().equals(v)){
                return j;
            }
        }
        return -1;
    }
    
    public String toString(){
        String result = "";
        for(int i=0; i<numCards; i++){
            result += "" + i + "." + cards[i].toString() + " ";
        }
        
        return result;
    }
    
    public static Card[] makeFullDeck(){
        Card[] cards = new Card[52];
        int count = 0;
        for(Suit s : Suit.values()){
            for(Value v : Value.values()){
                cards[count] = new Card(s,v);
                count++;
            }
        }
        UtilityCode.shuffle(cards, 52);
        return cards;
    }
}
