package gui;

import java.awt.Graphics;

public class WindowNext extends Window {
    public WindowNext(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
    }
}
