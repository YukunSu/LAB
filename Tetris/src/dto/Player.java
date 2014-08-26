package dto;

import java.io.Serializable;

/**
 * 
 * @author Yukun
 * 
 */
public class Player implements Comparable<Player>, Serializable{

    private String name;
    private int score;

    public Player(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player player) {
        return player.score - this.score;
    }

}
