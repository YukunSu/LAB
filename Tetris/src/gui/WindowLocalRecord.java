package gui;

import java.awt.Graphics;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowLocalRecord extends WindowDisplayRecords {

    public WindowLocalRecord(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        this.displayRecords(Images.LOCAL_RECORD, this.dto.getLocalRecord(), g);
    }
}
