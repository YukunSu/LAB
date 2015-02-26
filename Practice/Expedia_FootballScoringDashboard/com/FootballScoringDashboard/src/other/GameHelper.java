package other;

import java.util.ArrayList;

/**
 * Helper methods to find team name, player name and scored time
 * @author YK
 *
 */
public class GameHelper {
    public static ArrayList<String> findTeamName(String userInput){
        String copy = userInput.replace("\"", "");
        ArrayList<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < copy.length(); i++) {
            if(copy.charAt(i)=='\''){
                index.add(i);
            }
        }
        ArrayList<String> teamNames = new ArrayList<String>();
        teamNames.add(copy.substring(index.get(0)+1, index.get(1)));
        if(index.size()>2){
            teamNames.add(copy.substring(index.get(2)+1, index.get(3)));
        }

        return teamNames;
    }

    public static String findScoringTime(String userInput) {
        String[] names = userInput.split("\\s+");
        //Time should always be the first element
        return names[0].replace("\"", "");
    }

    public static String findPlayerName(String userInput) {
        String[] names = userInput.split("'");
        //The last element should always be the player name
        return names[2].replaceAll("\\s+", "").replace("\"", "");
    }
}
