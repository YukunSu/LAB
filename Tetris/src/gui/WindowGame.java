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

    public WindowGame(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        Point[] points = this.dto.getGameAct().getActPoints();
        //Get tetris type code
        int typeCode = this.dto.getGameAct().getTypeCode();
        //Print tetris
        for (int i = 0; i<points.length;i++){
            drawTetris(points[i].x, points[i].y, typeCode+1, g);
        }

        //Print map
        boolean[][] gameMap = this.dto.getGameMap();
        for (int x = 0; x < gameMap.length; x++) {
            for (int y = 0; y < gameMap[x].length; y++) {
                if(gameMap[x][y]){
                    drawTetris(x, y, 0, g);
                }
            }
        }
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
