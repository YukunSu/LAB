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

    private Image ImageLocalRecord = new ImageIcon("Graphics/Words/level.png")
            .getImage();

    public WindowLevel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        g.drawImage(ImageLocalRecord, this.x + DistanceTitle, this.y + DistanceTitle, null);
    }
}
