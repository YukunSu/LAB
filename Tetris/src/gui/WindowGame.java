package gui;

import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowGame extends Window {

    // TODO config
    private static final int SIZE_ROL = 5;
    private static final int LEFT_LIMIT = 0;
    private static final int RIGHT_LIMIT = 9;

    public WindowGame(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        Point[] points = this.dto.getGameAct().getActPoints();
        // Paint shadow
        // TODO shadow on / off
        this.drawShadow(points, true, g);
        //Get tetris type code
        int typeCode = this.dto.getGameAct().getTypeCode();
        //Print tetris
        for (int i = 0; i<points.length;i++){
            drawTetris(points[i].x, points[i].y, typeCode+1, g);
        }

        //Print map
        boolean[][] gameMap = this.dto.getGameMap();
        int imageIndex = 0;
        int lvl = this.dto.getLevel();
        imageIndex = lvl == 0 ? 0 : (lvl - 1) % 7 + 1;
        // TODO lost imageIndex = 8
        for (int x = 0; x < gameMap.length; x++) {
            for (int y = 0; y < gameMap[x].length; y++) {
                if(gameMap[x][y]){
                    drawTetris(x, y, imageIndex, g);
                }
            }
        }
    }

    /**
     * Draw shadow for each tetris
     * @param points
     * @param isShadowDisplayed
     * @param g
     */
    private void drawShadow(Point[] points, boolean isShadowDisplayed, Graphics g) {
        if (!isShadowDisplayed) {
            return;
        }
        // TODO hard code
        int leftMostX = RIGHT_LIMIT;
        int rightMostX = LEFT_LIMIT;
        for (Point point : points) {
            leftMostX = point.x < leftMostX ? point.x : leftMostX;
            rightMostX = point.x > rightMostX ? point.x : rightMostX;
        }
        g.drawImage(Images.SHADOW, 
                this.x + BORDER + (leftMostX << SIZE_ROL) - 7,
                this.y + BORDER - 7,
                (rightMostX - leftMostX +1) << SIZE_ROL,
                this.height - (BORDER << 1) + 14, null);
    }

    /**
     * Draw tetris according to their points
     * @param x
     * @param y
     * @param imgIndex
     * @param g
     */
    private void drawTetris(int x, int y, int imgIndex, Graphics g){
        g.drawImage(Images.ACT, 
                9+this.x+(x << SIZE_ROL), 
                9+this.y+(y << SIZE_ROL),
                9+this.x+(x + 1 << SIZE_ROL), 
                9+this.y+(y + 1 << SIZE_ROL), 
                imgIndex << SIZE_ROL, 0, imgIndex + 1 << SIZE_ROL, 1 << SIZE_ROL, null);
    }
}
