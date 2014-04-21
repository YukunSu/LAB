package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yukun
 * 
 */
public class GameAct {

    private Point[] actPoints = null;

    /**
     * Tetris type code 0~6
     */
    private int typeCode;

    private static int  MIN_X = 0;
    private static int  MAX_X = 9;
    private static int  MIN_Y = 0;
    private static int  MAX_Y = 17;

    private static List<Point[]> TYPE_CONFIG;

    static{
        //TODO config.xml
        TYPE_CONFIG = new ArrayList<Point[]>(7);
        //The first point should be the center of rotation
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(6, 0)});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(4, 1)});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(3, 1)});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(5, 0), new Point(3, 1), new Point(4, 1)});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(5, 0), new Point(4, 1), new Point(5, 1)});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(5, 1)});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(4, 1), new Point(5, 1)});
    }

    public GameAct(int typeCode) {
        this.init(typeCode);
    }

    public void init(int typeCode){
        this.typeCode = typeCode;
        Point[] points = TYPE_CONFIG.get(this.typeCode);
        actPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            actPoints[i] = new Point(points[i].x, points[i].y);
        }
    }

    public Point[] getActPoints() {
        return actPoints;
    }

    /**
     * Move tetris
     * @param moveX
     * @param moveY
     */
    public boolean move(int moveX, int moveY, boolean[][] gameMap) {
        // move tetris
        for (int i = 0; i < actPoints.length; i++) {
            int newX = actPoints[i].x + moveX;
            int newY = actPoints[i].y + moveY;
            if (isOutOfBorder(newX, newY, gameMap))
                return false;
        }

        for (int i = 0; i < actPoints.length; i++) {
            actPoints[i].x += moveX;
            actPoints[i].y += moveY;
        }

        return true;
    }

    /**
     * Rotate tetris
     * Clockwise equation:
     * A.x = O.y + O.x - B.y
     * A.y = O.y - O.x + B.x
     */
    public  void rotate(boolean[][] gameMap){
        // TODO config.xml
        if(this.typeCode == 4) {
            return;
        }
        
        for (int i = 1; i < actPoints.length; i++) {
            int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
            int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
            if (isOutOfBorder(newX, newY, gameMap))
                return;
        }
        
        for (int i = 1; i < actPoints.length; i++) {
            int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
            int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
            actPoints[i].x = newX;
            actPoints[i].y = newY;
        }
    }

    /**
     * Out of game frame detection
     * @param x
     * @param y
     * @param gameMap
     * @return
     */
    private boolean isOutOfBorder(int x, int y, boolean[][] gameMap){
        return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y || gameMap[x][y];
    }

    /**
     * Get Tetris type code
     * @return
     */
    public int getTypeCode(){
        return this.typeCode;
    }
}
