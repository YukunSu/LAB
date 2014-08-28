package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Yukun
 * 
 */
public class WindowBackground extends Window {

    public WindowBackground(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        int backgroundIndex = this.dto.getLevel() % Images.NEXT_BACKGROUND_LIST.size();
        g.drawImage(Images.NEXT_BACKGROUND_LIST.get(backgroundIndex), ZERO, ZERO, null);
    }

}
