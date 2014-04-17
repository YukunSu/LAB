package gui;

import java.awt.Graphics;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowGame extends Window {
    public WindowGame(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
    }
}
