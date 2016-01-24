package start;

import java.util.ArrayList;
import java.util.Scanner;

import other.GameCommand;
import other.GameConstantValues;
import other.GameHelper;
import verification.VerifyUserInput;
import component.Team;
import display.Display;

/**
 * Two main loops (in progress or not) to control game flow
 * @author YK
 *
 */
public class GameFlow {
    public static void DashboardFlow(Scanner input) {
        Display.printBeginningSymbols();
        String userInput = input.nextLine();
        while (!userInput.equalsIgnoreCase(GameCommand.QUIT)) {
            boolean isValidStart = VerifyUserInput.isValidStartInput(userInput);
            if (!isValidStart) {
                if (VerifyUserInput.isValidRecordScoreInput(userInput)
                        || userInput.equalsIgnoreCase(GameCommand.PRINT)
                        || userInput.equalsIgnoreCase(GameCommand.END)) {
                    Display.printNoGameCurrentlyInProgessMessage();
                } else if (userInput.equalsIgnoreCase(GameCommand.HELP)) {
                    Display.printHelpMessage();
                } else {
                    //Print game not in progress error message
                    Display.printIllegalInputMessage(false);
                }
            } else {
                userInput = GameSuccessfullyStartedFlow(input, userInput);
            }
            //User can start another game until enter "quit" command
            if(!userInput.equalsIgnoreCase(GameCommand.QUIT)) {
                Display.printBeginningSymbols();
                userInput = input.nextLine();
            }
        }
    }

    private static String GameSuccessfullyStartedFlow(Scanner input,
            String userInput) {
        // Game successfully start
        Display.printGameStartMessage();
        // Record Team Names
        String copyUserInput = userInput;
        // Find team names
        ArrayList<String> teamNames = GameHelper.findTeamName(copyUserInput);
        Team homeTeam, awayTeam;
        // Initialize teams with name and score 0
        homeTeam = new Team(teamNames.get(0), GameConstantValues.INITIAL_SCORE_VALUE);
        awayTeam = new Team(teamNames.get(1), GameConstantValues.INITIAL_SCORE_VALUE);

        while (!userInput.equalsIgnoreCase(GameCommand.END)
                && !userInput.equalsIgnoreCase(GameCommand.QUIT)) {
            Display.printBeginningSymbols();
            userInput = input.nextLine();
            if (VerifyUserInput.isValidStartInput(userInput)) {
                Display.printCannotStartAnotherGameWhenCurrentGameIsInProgressMessage();
            } else if (VerifyUserInput.isValidRecordScoreInput(userInput)) {
                // Record score, player name
                ArrayList<String> scoredTeam = GameHelper.findTeamName(userInput);
                String sTeam = scoredTeam.get(0);
                // Team name entered should correspond to the teams entered before
                if (VerifyUserInput.isTeamNameCorrespondsToPreviousNamesEntered(sTeam,
                        homeTeam, awayTeam)) {
                    String playerName = GameHelper.findPlayerName(userInput);
                    String time = GameHelper.findScoringTime(userInput);
                    time = VerifyUserInput.verifyTimeEntered(time);
                    if(!time.isEmpty()){
                        if (sTeam.equalsIgnoreCase(homeTeam.getName())) {
                            homeTeam.addScore(playerName, time);
                        } else {
                            awayTeam.addScore(playerName, time);
                        }
                    } else {
                        //Incorrect time value
                        Display.printUnreasonableTimeAmountMessage();
                    }
                } else {
                    //Incorrect team name
                    Display.printWrongTeamMessage(teamNames);
                }
            } else if (userInput.equalsIgnoreCase(GameCommand.PRINT)) {
                Display.printDetailedGameInformation(homeTeam, awayTeam);
            } else if (userInput.equalsIgnoreCase(GameCommand.HELP)) {
                Display.printHelpMessage();
            } else if (!userInput.equalsIgnoreCase(GameCommand.END)
                    && !userInput.equalsIgnoreCase(GameCommand.QUIT)) {
                // Print error message, true indicates game is in progress
                Display.printIllegalInputMessage(true);
            }
        }

        if (userInput.equalsIgnoreCase(GameCommand.END)) {
            // If user ends the game, print end message, else user quits the dashboard
            Display.printGameEndMessage();
        }

        return userInput;
    }
}
