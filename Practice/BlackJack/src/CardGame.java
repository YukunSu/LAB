import java.util.ArrayList;
import java.util.Scanner;


public class CardGame {
    public static void main(String[] args){
        CardPile cp = new CardPile();
        int initialMoney = Integer.parseInt(args[0]);
        ArrayList<Card> c1 = CardPile.makeFullDeck(4);
        for(int i=0; i<c1.size(); i++){
            cp.addToBottom(c1.get(i));
        }
        
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        write("Welcome to play Black Jack!\n");
        String s = "";
        
        do{
            write("\nYou have ==> " + initialMoney + " <== chips. \n");
            write("How much you wanna bet for this round? (Negative bet will quit the game!) >>> ");
            int bet = inputInt.nextInt();
            if(bet<0) break;
            if(bet>0 && bet<=initialMoney){
            BlackJack.Results r = BlackJack.playRound(cp);
                if(r.equals(BlackJack.Results.BLACKJACK)){
                    initialMoney += bet*1.5;
                }else if(r.equals(BlackJack.Results.DEALER_WINS)){
                    initialMoney -= bet;
                }else if(r.equals(BlackJack.Results.PLAYER_WINS)){
                    initialMoney += bet;
                }
            }else{
                write("Please input correct range for your bet!\n");
            }
            
            write("You have ==> " + initialMoney + " <== chips left. \n");
            write("You want continue(c) or quit(q)? ");
            s=input.nextLine();
        }while((cp.getNumCards()>10) && (!s.startsWith("q")&&!s.startsWith("Q") && (initialMoney>0)));
        
        if(cp.getNumCards()<=10){
            write("Cards left less than 10. You can relauch the program if you want to start a new round!\n");
        }
        
        if(initialMoney<=0){
            write("No money left. Sorry.\n");
        }
        
        write("Thanks for playing! See you soon!\n");
        input.close();
        inputInt.close();
    }
    
    private static void write(String s){
        System.out.print(s);
    }
}
