package service;

import java.awt.Point;
import java.util.Map;
import java.util.Random;

import config.ConfigGame;
import dto.GameDto;
import entity.GameAct;

/**
 * 
 * @author Yukun
 * 
 */
public class GameTetris implements GameService{

    private GameDto dto;

    /**
     * Random type code
     */
    private Random randomTypeCode;

    /**
     * Quantity of different tetris type
     */
    private static final int MAX_TYPE = ConfigGame.getConfigSystem().getTypeConfig().size();

    private static final int TO_LEVEL_UP = ConfigGame.getConfigSystem().getLevelUp();

    private static final Map<Integer, Integer> SCORE = ConfigGame.getConfigSystem().getAddScore();

    public GameTetris(GameDto dto) {
        this.dto = dto;
    }

    public boolean keyUp() {
        if (this.dto.isPaused()) {
            return true;
        }
        synchronized (this.dto) {
            this.dto.getGameAct().rotate(this.dto.getGameMap());
        }
        return true;

//        if(borderDetection(0, -1))
//            this.dto.getGameAct().move(0, -1);
    }

    public boolean keyDown() {
        if (this.dto.isPaused()) {
            return true;
        }
        synchronized (this.dto) {
            //If cannot move down
            if(this.dto.getGameAct().move(0, 1, this.dto.getGameMap())){
                return false;
            }
            //Get game map
            boolean[][] gameMap = this.dto.getGameMap();
            //Get tetris
            Point[] act = this.dto.getGameAct().getActPoints();
            //Set game map according to tetris position
            for (int i = 0; i < act.length; i++) {
                gameMap[act[i].x][act[i].y] = true;
            }
    
            int exp = this.calculateExp();
            if (exp > 0) {
                this.calculateScore(exp);
            }
            this.dto.getGameAct().init(this.dto.getNext());
            //Create next random Tetris
            this.dto.setNext(randomTypeCode.nextInt(MAX_TYPE));
            if (this.isLost()) {
                // end game
                this.dto.setStart(false);
            }
        }
        return true;
    }

    public boolean keyLeft() {
        if (this.dto.isPaused()) {
            return true;
        }
        synchronized (this.dto) {
            this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
        }
        return true;
    }

    public boolean keyRight() {
        if (this.dto.isPaused()) {
            return true;
        }
        synchronized (this.dto) {
            this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
        }
        return true;
    }

    /**
     * Score Adder!
     */
    @Override
    public boolean keyFunctionUp() {
//        if (this.dto.isStart()) {
//            this.calculateScore(4);
//        }
        return true;
    }

    /**
     * Fast drop key
     */
    @Override
    public boolean keyFunctionDown() {
        if (this.dto.isPaused()) {
            return true;
        }
        while (!this.keyDown());
        return true;
    }

    /**
     * Display shadow key
     */
    @Override
    public boolean keyFunctionLeft() {
        this.dto.changeShadowDisplayed();
        return true;
    }

    /**
     * Pause key
     */
    @Override
    public boolean keyFunctionRight() {
        if (this.dto.isStart()) {
            this.dto.changePausedStatus();
        }
        return true;
    }

    private int calculateExp() {
        // Get game map
        boolean[][] map = this.dto.getGameMap();
        int exp = 0;
        // Scan the map and find which line is removable
        for (int y = 0; y < GameDto.GAMEZONE_HEIGHT; y++) {
            // Verify is it removable
            if (isRemovable(y, map)) {
                // If so, removed it
                this.removeLine(y, map);
                // increase exp
                exp++;
            }
        }
        return exp;
    }

    /**
     * Level up
     * @param exp
     */
    private void calculateScore(int exp) {
        int rmlines = this.dto.getLineRemoved();
        int lvl = this.dto.getLevel();
        int score = this.dto.getCurrentScore();
        if (rmlines % TO_LEVEL_UP + exp >= TO_LEVEL_UP) {
            this.dto.setLevel(++lvl);
        }
        this.dto.setLineRemoved(rmlines + exp);
        this.dto.setCurrentScore(score + SCORE.get(exp));
    }

    /**
     * Remove the line action
     * @param y
     * @param map
     */
    private void removeLine(int rowNumber, boolean[][] map) {
        for (int x = 0; x < GameDto.GAMEZONE_WIDTH; x++) {
            for (int y = rowNumber; y > 0; y--) {
                map[x][y] = map[x][y-1];
            }
            map[x][0] = false;
        }
    }

    /**
     * Verify one row is removable or not
     * @param y
     * @param map
     * @return
     */
    private boolean isRemovable(int y, boolean[][] map) {
        for (int x = 0; x < GameDto.GAMEZONE_WIDTH; x++) {
            if (!map[x][y]) {
                // return false if found one empty square
                return false;
            }
        }
        return true;
    }

    private boolean isLost() {
        // Get current produced Tetris
        Point[] points = this.dto.getGameAct().getActPoints();
        // Get current game map
        boolean[][] gameMap = this.dto.getGameMap();
        for (int i = 0; i < points.length; i++) {
            if (gameMap[points[i].x][points[i].y]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void startGame() {
        randomTypeCode = new Random();
        this.dto.setNext(randomTypeCode.nextInt(MAX_TYPE));
        this.dto.setGameAct(new GameAct(randomTypeCode.nextInt(MAX_TYPE)));
        this.dto.setStart(true);
        this.dto.init();
    }

    @Override
    public void mainAction() {
        this.keyDown();
    }

    /**
     * Add a lot of points!!!
     */
    @Override
    public void scoreAdder() {
        if (this.dto.isStart()) {
            this.calculateScore(4);
        }
    }

    /**
     * Increase one level! Don't do it too much!
     */
    @Override
    public void addLvl() {
        this.dto.setLevel(this.dto.getLevel()+1);
    }
}
