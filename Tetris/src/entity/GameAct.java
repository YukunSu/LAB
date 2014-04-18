package entity;

import java.awt.Point;

/**
 * 
 * @author Yukun
 *
 */
public class GameAct {

    private Point[] actPoints;

    public GameAct() {
        // TODO config.xml
        actPoints = new Point[]{
                new Point(3,0),
                new Point(4,0),
                new Point(5,0),
                new Point(5,1),
        };
    }

    public Point[] getActPoints() {
        return actPoints;
    }
    
    
}
