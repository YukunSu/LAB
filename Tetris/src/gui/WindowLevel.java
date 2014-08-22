package gui;

import java.awt.Graphics;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowLevel extends Window {

    private static final int LOCAL_RECORD_WIDTH = Images.LEVEL.getWidth(null);

    private static final int OFFSET = LOCAL_RECORD_WIDTH >> 1;

    public WindowLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        int centerX = this.width - LOCAL_RECORD_WIDTH >> 1;
        //Draw window title
        g.drawImage(Images.LEVEL, this.x + centerX, this.y + DistanceTitle, null);
        //Draw level
        this.drawNumberLeftPad(OFFSET + centerX, 60, this.dto.getLevel(), 2, g);
    }
}
