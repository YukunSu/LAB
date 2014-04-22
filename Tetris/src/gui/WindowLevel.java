package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowLevel extends Window {

    private static final Image IMAGE_LOCAL_RECORD = new ImageIcon("Graphics/Words/level.png").getImage();

    private static final int LOCAL_RECORD_WIDTH = IMAGE_LOCAL_RECORD.getWidth(null);

    private static final int OFFSET = LOCAL_RECORD_WIDTH >> 1;

    public WindowLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        int centerX = this.width - LOCAL_RECORD_WIDTH >> 1;
        //Draw window title
        g.drawImage(IMAGE_LOCAL_RECORD, this.x + centerX, this.y + DistanceTitle, null);
        //Draw level
        this.drawNumberLeftPad(OFFSET + centerX, 60, this.dto.getLevel(), 2, g);
    }
}
