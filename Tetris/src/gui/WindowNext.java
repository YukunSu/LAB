package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WindowNext extends Window {

    private static final Image[] NEXT_ACT;

    static{
        NEXT_ACT = new Image[7];
        for (int i = 0; i < NEXT_ACT.length; i++) {
            NEXT_ACT[i] = new ImageIcon("Graphics/Images/" + i + ".png") .getImage();
        }
    }
    public WindowNext(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        this.drawImageAtCenter(NEXT_ACT[this.dto.getNext()], g);
    }

    private void drawImageAtCenter(Image img, Graphics g){
        int imageWidth = img.getWidth(null);
        int imageHeight = img.getHeight(null);
        int x = this.x + (this.width - imageWidth >> 1);
        int y = this.y + (this.height - imageHeight >> 1);
        g.drawImage(img, x, y, null);
    }
}
