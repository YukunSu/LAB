package display;

import java.util.ArrayList;

import component.Team;

/**
 * Output error or information messages
 * @author YK
 *
 */
public class Display {

    public static void printWelcomeMessage() {
        System.out.println(">>> Welcome to Football Scoring Dashboard!");
        System.out.println(">>> The available game commands are listed as following:");
    }

    public static void printHelpMessage() {
        System.out.println("- \"Start: 'Name of Home Team' vs. 'Name of Away Team'\"\t\tStart game.");
        System.out.println("- \"minute \'Team Name' Player Name\"\t\t\t\tRecord score.");
        System.out.println("- Print\t\t\t\t\t\t\t\tDisplay game details.");
        System.out.println("- End\t\t\t\t\t\t\t\tEnd Game.");
        System.out.println("- Quit\t\t\t\t\t\t\t\tQuit dashboard.");
        System.out.println("- Help\t\t\t\t\t\t\t\tList help manual.");
        System.out.println("Notes:");
        System.out.println("- Team name should be different when start;");
        System.out.println("- Team name and player name should be all letters;");
        System.out.println("- Minute should be all integer digits and within the range 0 to 999 inclusive.");
        System.out.println("- Team name should correspond to previous entered team name;");
        System.out.println("- Cannot start another game when current game is not ended.");
    }

    public static void printQuitMessage() {
        System.out.println(">>> Thank you for using Football Scoring Dashboard! Bye!");
    }
    
    public static void printGameStartMessage(){
        System.out.println(">>> Game in progress.");
    }
    
    public static void printGameEndMessage(){
        System.out.println(">>> Game ended. You can start another game or enter \"Quit\" to exit the program.");
    }

    public static void printCannotStartAnotherGameWhenCurrentGameIsInProgressMessage() {
        System.out.println(">>> Cannot start another game when current game is still in progress.");
    }

    public static void printNoGameCurrentlyInProgessMessage() {
        System.out.println(">>> No game currently in progress.");
    }

    public static void printIllegalInputMessage(boolean isInProgress) {
        if(isInProgress) {
            System.out.println(">>> 'Input error - please type 'print' for game details'");
        } else {
            System.out.println(">>> 'Input error - please start a game through typing 'Start: 'Name of Home Team' vs. 'Name of Away Team''");
        }
        System.out.println(">>> Type 'Help' for listing all available game commands.");
    }

    public static void printWrongTeamMessage(ArrayList<String> teamNames) {
        System.out.println(">>> The game is between " + teamNames.get(0) + " and " + teamNames.get(1) + ". Please give correct team names.");
    }

    public static void printUnreasonableTimeAmountMessage() {
        System.out.println(">>> Time amount should not exceed 999. Please enter a reasonable time amount.");
    }

    public static void printBeginningSymbols(){
        System.out.print(">>> ");
    }

    public static void printDetailedGameInformation(Team a, Team b) {
        System.out.print(">>> \"");
        printSingleTeamInformation(a);
        System.out.print(" vs. ");
        printSingleTeamInformation(b);
        System.out.println("\"");
    }

    private static void printSingleTeamInformation(Team a) {
        boolean needSpace = false;
        System.out.print(a.getName()+" " + a.getScore());
        if(!a.getPlayerScores().isEmpty()){
            System.out.print(" (");
            for(String player: a.getPlayerScores().keySet()){
                if(needSpace) System.out.print(" ");
                System.out.print(player);
                System.out.print(" ");
                System.out.print(a.getPlayerScores().get(player));
                needSpace = true;
            }
            System.out.print(")");
        }
    }
}
