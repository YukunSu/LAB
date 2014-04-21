package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WindowScore extends Window {

    private static final Image IMAGE_SCORE = new ImageIcon("Graphics/Words/point.png").getImage();
    private static final Image IMAGE_REMOVE_LINE = new ImageIcon("Graphics/Words/rmline.png").getImage();

    public WindowScore(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
    }
}
