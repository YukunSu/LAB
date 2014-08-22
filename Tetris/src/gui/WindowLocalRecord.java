package gui;

import java.awt.Graphics;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowLocalRecord extends Window {

    public WindowLocalRecord(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        g.drawImage(Images.LOCAL_RECORD, this.x + DistanceTitle, this.y + DistanceTitle, null);
    }
}
