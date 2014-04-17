package gui;

import java.awt.Graphics;

/**
 * 
 * @author Yukun
 *
 */
public class WindowButtons extends Window {
    public WindowButtons(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
    }
}
