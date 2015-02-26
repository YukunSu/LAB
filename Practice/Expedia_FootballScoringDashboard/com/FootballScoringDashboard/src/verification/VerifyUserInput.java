package verification;

import java.util.ArrayList;
import java.util.HashSet;

import other.GameConstantValues;
import other.GameHelper;
import component.Team;

/**
 * Verify whether user input value is valid or not
 * @author YK
 *
 */
public class VerifyUserInput {
    public static boolean isValidStartInput(String userInput) {
        boolean isValid = false;
        String inputCopy = userInput;
        if (inputCopy.startsWith("\"Start: '") && inputCopy.endsWith("'\"")) {
            inputCopy = inputCopy.replace("\"Start: '", "");
            inputCopy = inputCopy.replace("'\"", "");
            if (inputCopy.contains("' vs. '")) {
                inputCopy = inputCopy.replace("' vs. '", "");
                inputCopy = inputCopy.replaceAll("\\s+", "");
                if (isAllLetters(inputCopy)) {
                    // Cannot start a game with same team
                    ArrayList<String> teams = GameHelper.findTeamName(userInput);
                    if (teams.size() == 2) {
                        if (!teams.get(0).equalsIgnoreCase(teams.get(1))) {
                            isValid = true;
                        }
                    }
                }
            }
        }
        return isValid;
    }

    public static boolean isValidRecordScoreInput(String userInput) {
        boolean isValid = false;
        String inputCopy = userInput;
        if (inputCopy.startsWith("\"") && inputCopy.endsWith("\"")) {
            inputCopy = inputCopy.replace("\"", "");
            String[] input = inputCopy.split("'");
            if (input.length == GameConstantValues.CORRECT_RECORD_SCORE_LENGTH) {
                if (isAllDigits(input[0].replace(" ", ""))
                        && isAllLetters(input[1].replace(" ", ""))
                        && isAllLetters(input[2].replace(" ", ""))) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }

    public static boolean isTeamNameCorrespondsToPreviousNamesEntered(String sTeam,
            Team homeTeam, Team awayTeam) {
        HashSet<String> teams = new HashSet<String>();
        teams.add(homeTeam.getName().toLowerCase());
        teams.add(awayTeam.getName().toLowerCase());
        if (teams.contains(sTeam.toLowerCase()))
            return true;
        return false;
    }

    public static String verifyTimeEntered(String time) {
        int min = Integer.parseInt(time);
        if (min > GameConstantValues.MAXIMUM_TIME_AMOUNT)
            return "";
        time = Integer.toString(min);
        return time;
    }

    private static boolean isAllLetters(String input) {
        boolean isValid = true;
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            if (!Character.isLetter(inputArray[i])) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static boolean isAllDigits(String input) {
        boolean isValid = true;
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            if (!Character.isDigit(inputArray[i])) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
