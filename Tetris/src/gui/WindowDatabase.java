package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Yukun
 *
 */
public class WindowDatabase extends Window {

    private Image ImageDatabase = new ImageIcon("Graphics/Words/db.png").getImage();

    public WindowDatabase(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        g.drawImage(ImageDatabase, this.x + DistanceTitle, this.y + DistanceTitle, null);
    }
}
