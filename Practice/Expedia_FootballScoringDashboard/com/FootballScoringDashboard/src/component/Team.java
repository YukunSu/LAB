package component;

import java.util.HashMap;

/**
 * Represent a team with name, player and scored time
 * @author YK
 *
 */
public class Team {
    private String name = new String();
    private int score = 0;
    /**
     * Player name to scoring time map, assume unique player name in each team
     */
    private HashMap<String, String> playerToScoringTime = new HashMap<String, String>();

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public HashMap<String, String> getPlayerScores() {
        return this.playerToScoringTime;
    }

    /**
     * Increment the team score and record the scored player name
     * and correspond scored time.
     * 
     * @param playerName String representation of player name
     * @param time String representation of time
     */
    public void addScore(String playerName, String time) {
        time += "'";
        //First check this player has scored before or not
        if (this.playerToScoringTime.containsKey(playerName)) {
            String tempTime = this.playerToScoringTime.get(playerName);
            tempTime += " " + time;
            this.playerToScoringTime.put(playerName, tempTime);
        } else {
            this.playerToScoringTime.put(playerName, time);
        }
        //Always increment score to the whole team
        this.score++;
    }
}
