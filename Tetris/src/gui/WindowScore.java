package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WindowScore extends Window {

    private static final Image IMAGE_SCORE = new ImageIcon("Graphics/Words/point.png").getImage();
    private static final Image IMAGE_REMOVE_LINE = new ImageIcon("Graphics/Words/rmline.png").getImage();
    private static final int REMOVE_LINE_HEIGHT = IMAGE_REMOVE_LINE.getHeight(null);
    private static final int MAX_BIT = 5;
    private static int SCORE_POSITION = 0;

    public WindowScore(int x, int y, int w, int h) {
        super(x, y, w, h);
        SCORE_POSITION = this.width - NUMBER_WIDTH * MAX_BIT - DistanceTitle;
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        g.drawImage(IMAGE_SCORE, this.x + DistanceTitle, this.y + DistanceTitle, null);
        this.drawNumberLeftPad(SCORE_POSITION, DistanceTitle, this.dto.getCurrentScore(), MAX_BIT, g);

        g.drawImage(IMAGE_REMOVE_LINE, this.x + DistanceTitle,
                this.y + REMOVE_LINE_HEIGHT + (DistanceTitle << 1), null);
        this.drawNumberLeftPad(SCORE_POSITION, REMOVE_LINE_HEIGHT + (DistanceTitle << 1),
                this.dto.getLineRemoved(), MAX_BIT, g);
    }
}
