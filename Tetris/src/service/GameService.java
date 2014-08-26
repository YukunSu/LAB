package service;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import dto.GameDto;
import dto.Player;
import entity.GameAct;

/**
 * 
 * @author Yukun
 * 
 */
public class GameService {

    private GameDto dto;

    /**
     * Random type code
     */
    private Random randomTypeCode;

    /**
     * Quantity of different tetris type
     */
    private static final int MAX_TYPE = 7;

    public GameService(GameDto dto) {
        this.dto = dto;
        randomTypeCode = new Random();
        GameAct act = new GameAct(randomTypeCode.nextInt(MAX_TYPE));
        dto.setGameAct(act);
    }

    public void keyUp() {
        // TODO rotation
        this.dto.getGameAct().rotate(this.dto.getGameMap());
        
//        if(borderDetection(0, -1))
//            this.dto.getGameAct().move(0, -1);
    }

    public void keyDown() {
        //If cannot move down
        if(this.dto.getGameAct().move(0, 1, this.dto.getGameMap())){
            return;
        }
        //Get game map
        boolean[][] gameMap = this.dto.getGameMap();
        //Get tetris
        Point[] act = this.dto.getGameAct().getActPoints();
        //Set game map according to tetris position
        for (int i = 0; i < act.length; i++) {
            gameMap[act[i].x][act[i].y] = true;
        }

        //TODO remove line
        //TODO calculate score
        //TODO level
        //TODO new tetris
        //Paint next Tetris
        this.dto.getGameAct().init(this.dto.getNext());
        //Create next random Tetris
        this.dto.setNext(randomTypeCode.nextInt(MAX_TYPE));
    }

    public void keyLeft() {
            this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
    }

    public void keyRight() {
            this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
    }

    //TODO TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void testLevelUP() {
        int point = this.dto.getCurrentScore();
        int rmlines = this.dto.getLineRemoved();
        int lvl = this.dto.getLevel();
        point += 10;
        rmlines++;
        if (rmlines % 100 == 0) {
            lvl ++;
        }
        this.dto.setCurrentScore(point);
        this.dto.setLineRemoved(rmlines);
        this.dto.setLevel(lvl);
    }

    public void setDatabaseRecord(List<Player> players) {
        this.dto.setDatabaseRecord(players);
    }

    public void setLocalRecord(List<Player> players) {
        this.dto.setLocalRecord(players);
    }
}
