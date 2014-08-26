package gui;

import java.awt.Graphics;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowDatabase extends WindowDisplayRecords {

    public WindowDatabase(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        this.displayRecords(Images.DATABASE, this.dto.getDatabaseRecord(), g);
    }
}
