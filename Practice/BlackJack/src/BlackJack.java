import java.util.ArrayList;
import java.util.Scanner;


public class BlackJack {
    public static enum Results{
        DEALER_WINS,
        PLAYER_WINS,
        TIE,
        BLACKJACK
    }
    
    public static int getScore(Card c){
        if(c.getValue().equals(Value.ACE)){
            return 11;
        }else if(c.getValue().equals(Value.TWO)){
            return 2;
        }else if(c.getValue().equals(Value.THREE)){
            return 3;
        }else if(c.getValue().equals(Value.FOUR)){
            return 4;
        }else if(c.getValue().equals(Value.FIVE)){
            return 5;
        }else if(c.getValue().equals(Value.SIX)){
            return 6;
        }else if(c.getValue().equals(Value.SEVEN)){
            return 7;
        }else if(c.getValue().equals(Value.EIGHT)){
            return 8;
        }else if(c.getValue().equals(Value.NINE)){
            return 9;
        }else{
            return 10;
        }
    }
    
    public static int countValues(CardPile cp){
        int numCards = cp.getNumCards();
        CardPile rearrangedCardPile = new CardPile();
        ArrayList<Card> rearrangedCards = new ArrayList<Card>();
        ArrayList<Card> ace = new ArrayList<Card>();
        ArrayList<Card> nonAce = new ArrayList<Card>();
        
        //remove all ACE in the original card pile
        for(int i=0; i<numCards; i++){
            if(cp.get(i).getValue().equals(Value.ACE)){
                ace.add(cp.get(i));
            }else{
                nonAce.add(cp.get(i));
            }
        }
        
        rearrangedCards.addAll(nonAce);
        rearrangedCards.addAll(ace);
        //add all ACE back to the original card pile at the end of the array
        for(int i=0; i<rearrangedCards.size(); i++){
            rearrangedCardPile.addToBottom(rearrangedCards.get(i));
        }
        
        //Calculate values!
        //cp = rearrangedCardPile;
        int result = 0;
        for(int i=0; i<rearrangedCardPile.getNumCards(); i++){
            if(rearrangedCardPile.get(i).getValue().equals(Value.ACE)){
                if(result+11>21){
                    result+=1;
                } else {
                    result += getScore(rearrangedCardPile.get(i));
                }
            } else {
                result += getScore(rearrangedCardPile.get(i));
            }
        }
        return result;
    }
    
    public static Results playRound(CardPile cp){
        boolean playerLose = false;
        boolean dealerLose = false;
        Results r = null;
        Scanner input = new Scanner(System.in);

        CardPile dealer = new CardPile();
        CardPile player = new CardPile();
        String s = "";
        write("\n\nGame Start!\n");
        //each start with 2 cards
        dealer.addToBottom(cp.remove(0));
        dealer.addToBottom(cp.remove(0));
        player.addToBottom(cp.remove(0));
        player.addToBottom(cp.remove(0));
        write("Dealer has <<< " + countValues(dealer) + " >>> points. The cards are: " + dealer.toString() + "\n");
        write("You have >>> " + countValues(player) + " <<< points. The cards are: " + player.toString() + "\n");
        if(countValues(player)==21 && countValues(dealer)!=21){
            write("Black Jack! Congrats! You won!\n");
            r = Results.BLACKJACK;
        }else if(countValues(player)==21 && countValues(dealer)==21){
            write("PUSH! Both Black Jack!");
            r = Results.TIE;
        }else{
            write("You want hit(h) or stay(s)?(Default is stay) ");
            s = input.nextLine();
            //player's turn
            while(s.startsWith("h")||s.startsWith("H")){
                player.addToBottom(cp.remove(0));
                write("Dealer has <<< " + countValues(dealer) + " >>> points. The cards are: " + dealer.toString() + "\n");
                write("You have >>> " + countValues(player) + " <<< points. The cards are: " + player.toString() + "\n");
                if(countValues(player)>21){
                    write("Busting! Sorry you lose!\n");
                    playerLose = true;
                    r = Results.DEALER_WINS;
                    break;
                }else{
                    write("You want hit(h) or stay(s)?(Default is stay) ");
                    s = input.nextLine();
                }
            }

            //dealer's turn
            if(playerLose==false){
                while(countValues(dealer)<18){
                    dealer.addToBottom(cp.remove(0));
                    write("Dealer has <<< " + countValues(dealer) + " >>> points. The cards are: " + dealer.toString() + "\n");
                    write("You have >>> " + countValues(player) + " <<< points. The cards are: " + player.toString() + "\n");
                }
                if(countValues(dealer)>21){
                    write("Congrats! You win! \n");
                    dealerLose = true;
                    r = Results.PLAYER_WINS;
                }
            }
            
            if(!dealerLose&&!playerLose){
                if(countValues(dealer)>countValues(player)){
                    write("Sorry you lose! \n");
                    r = Results.DEALER_WINS;
                }else if(countValues(dealer)<countValues(player)){
                    write("Congrats! You win! \n");
                    r = Results.PLAYER_WINS;
                }else{
                    write("It's a tie!\n");
                    r = Results.TIE;
                }
            }
        }

        return r;
    }
    
    private static void write(String s){
        System.out.print(s);
    }
}
