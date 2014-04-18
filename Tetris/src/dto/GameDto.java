package dto;

import java.util.List;

import entity.GameAct;

/**
 * 
 * @author Yukun
 * 
 */
public class GameDto {

    private List<Player> databaseRecord;

    private List<Player> localRecord;

    private boolean[][] gameMap;

    private GameAct gameAct;

    private int next;

    private int level;

    private int currentScore;

    private int lineRemoved;

    public List<Player> getDatabaseRecord() {
        return databaseRecord;
    }

    public void setDatabaseRecord(List<Player> databaseRecord) {
        this.databaseRecord = databaseRecord;
    }

    public List<Player> getLocalRecord() {
        return localRecord;
    }


    public void setLocalRecord(List<Player> localRecord) {
        this.localRecord = localRecord;
    }

    public boolean[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(boolean[][] gameMap) {
        this.gameMap = gameMap;
    }

    public GameAct getGameAct() {
        return gameAct;
    }

    public void setGameAct(GameAct gameAct) {
        this.gameAct = gameAct;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getLineRemoved() {
        return lineRemoved;
    }

    public void setLineRemoved(int lineRemoved) {
        this.lineRemoved = lineRemoved;
    }

}
