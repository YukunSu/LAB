package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowGame extends Window {

    private static Image ACT = new ImageIcon("Graphics/Images/rect.png") .getImage();

    private static int ACTSIZE = 32;
    
    public WindowGame(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        Point[] points = this.dto.getGameAct().getActPoints();
        for (int i = 0; i<points.length;i++){
            g.drawImage(ACT, 
                    (int)(this.x+points[i].getX()*ACTSIZE), 
                    (int)(this.y+points[i].getY()*ACTSIZE),
                    (int)(this.x+points[i].getX()*ACTSIZE + ACTSIZE), 
                    (int)(this.y+points[i].getY()*ACTSIZE + ACTSIZE), 
                    32, 0, 64, 32, null);
        }
    }
}
