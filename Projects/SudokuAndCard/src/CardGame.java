
public class CardGame {
    public static void main(String[] args){
        CardPile[] cp = new CardPile[Integer.parseInt(args[0])];
        Card[] c1 = CardPile.makeFullDeck();
        int count = 0;
        for(int i=0; i<cp.length; i++){
            cp[i]=new CardPile();
            for(int j=count;j<52;j++){
                cp[i].addToBottom(c1[j]);
                count++;
                if(j!=0 && ((j%(52/cp.length))==0)) break;
            }
        }
        
        for(int i=0; i<cp.length;i++){
            System.out.println(cp[i].toString());
        }
        
        for(int i=0; i<cp.length;i++){
            if(!cp[i].isEmpty()){
                if(cp[i].find(Suit.SPADES, Value.ACE)!=-1){
                    System.out.println("Winner number is " + (i+1));
                }
            }
        }
    }
}
