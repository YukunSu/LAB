package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.ConfigGame;
import dto.GameDto;

/**
 * Draw window
 * 
 * @author Yukun
 * 
 */
public abstract class Window {
    protected final int ZERO = 0;
    ConfigGame gameConfig = ConfigFactory.getConfigGame();
    protected int windowBorderWidth = gameConfig.getWindowBorderSize();
    protected int DistanceTitle = gameConfig.getPadding();
    protected static final int NUMBER_WIDTH = Images.NUMBER.getWidth(null) / 10;
    protected static final int NUMBER_HEIGHT = Images.NUMBER.getHeight(null);
    private static final Font CALIBRI_FONT = new Font("Calibri", Font.BOLD, 20);
    /**
     * Initialize height of experience bar picture
     */
    protected static final int RECTANGLE_HEIGHT = Images.RECTANGLE.getHeight(null);
    /**
     * Initialize width of experience bar picture
     */
    private static final int RECTANGLE_WIDTH = Images.RECTANGLE.getWidth(null);
    /**
     * Initialize width of experience bar
     */
    private final int expWidth;
    /**
     * Window picture width
     */
    protected int windowWidth = Images.WINDOW.getWidth(null);
    /**
     * Window picture height
     */
    protected int windowHeight = Images.WINDOW.getHeight(null);
    /**
     * X coordinate of window's upper left corner
     */
    protected int x;
    /**
     * Y coordinate of window's upper left corner
     */
    protected int y;
    /**
     * Window width
     */
    protected int width;
    /**
     * Window height
     */
    protected int height;
    /**
     * Game data source
     */
    protected GameDto dto = null;

    protected Window(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        expWidth = this.width - (DistanceTitle << 1);
    }

    protected void setWindowBorderWidth(int border) {
        windowBorderWidth = border;
    }

    protected void setwindowImage(String picNameExt) {
        Images.WINDOW = new ImageIcon("Graphics/Windows/" + picNameExt).getImage();
        windowWidth = Images.WINDOW.getWidth(null);
        windowHeight = Images.WINDOW.getHeight(null);
    }

    protected void setDistanceTitle(int distance) {
        this.DistanceTitle = distance;
    }

    /**
     * Draw window
     * 
     * @param g
     */
    protected void printWindowBorder(Graphics g) {
        // Draw upper left
        g.drawImage(Images.WINDOW, x, y, x + windowBorderWidth, y
                + windowBorderWidth, ZERO, ZERO, windowBorderWidth,
                windowBorderWidth, null);
        // Draw upper middle
        g.drawImage(Images.WINDOW, x + windowBorderWidth, y, x + width
                - windowBorderWidth, y + windowBorderWidth, windowBorderWidth,
                ZERO, windowWidth - windowBorderWidth, windowBorderWidth, null);
        // Draw upper right
        g.drawImage(Images.WINDOW, x + width - windowBorderWidth, y, x + width, y
                + windowBorderWidth, windowWidth - windowBorderWidth, ZERO,
                windowWidth, windowBorderWidth, null);

        // Draw middle left
        g.drawImage(Images.WINDOW, x, y + windowBorderWidth, x
                + windowBorderWidth, y + height - windowBorderWidth, ZERO,
                windowBorderWidth, windowBorderWidth, windowHeight
                        - windowBorderWidth, null);
        // Draw middle middle
        g.drawImage(Images.WINDOW, x + windowBorderWidth, y + windowBorderWidth,
                x + width - windowBorderWidth, y + height - windowBorderWidth,
                windowBorderWidth, windowBorderWidth, windowWidth
                        - windowBorderWidth, windowHeight - windowBorderWidth,
                null);
        // Draw middle right
        g.drawImage(Images.WINDOW, x + width - windowBorderWidth, y
                + windowBorderWidth, x + width, y + height - windowBorderWidth,
                windowWidth - windowBorderWidth, windowBorderWidth,
                windowWidth, windowHeight - windowBorderWidth, null);

        // Draw lower left
        g.drawImage(Images.WINDOW, x, y + height - windowBorderWidth, x
                + windowBorderWidth, y + height, ZERO, windowHeight
                - windowBorderWidth, windowBorderWidth, windowHeight, null);
        // Draw lower middle
        g.drawImage(Images.WINDOW, x + windowBorderWidth, y + height
                - windowBorderWidth, x + width - windowBorderWidth, y + height,
                windowBorderWidth, windowHeight - windowBorderWidth,
                windowWidth - windowBorderWidth, windowHeight, null);
        // Draw lower right
        g.drawImage(Images.WINDOW, x + width - windowBorderWidth, y + height
                - windowBorderWidth, x + width, y + height, windowWidth
                - windowBorderWidth, windowHeight - windowBorderWidth,
                windowWidth, windowHeight, null);
    }

    public void setDto(GameDto dto){
        this.dto = dto;
    }

    /**
     * Paint numbers
     * @param x
     * @param y
     * @param number
     * @param maxBit
     * @param g
     */
    protected void drawNumberLeftPad(int x, int y, int number, int maxBit, Graphics g){
        String num = Integer.toString(number);
        for (int i = 0; i < maxBit; i++) {
            if(maxBit - i <= num.length()){
                int index = i - maxBit + num.length();
                int singleNum = num.charAt(index) - '0';
                g.drawImage(Images.NUMBER, 
                        this.x + x + NUMBER_WIDTH * i, this.y + y, 
                        this.x + x + NUMBER_WIDTH * (i + 1), this.y + y + NUMBER_HEIGHT,
                        singleNum * NUMBER_WIDTH, 0, 
                        (singleNum + 1) * NUMBER_WIDTH, NUMBER_HEIGHT, null);
            }
        }
    }

    /**
     * Draw the exp bar based on current score and level
     * @param title Name displayed for the rectangle bar (players' names or title)
     * @param playerScores
     * @param recPositionY Starting Y position of the rectangle
     * @param linesRatio The amount of lines left to level up / The total amount of lines needed to level up
     * @param g The pen
     */
    protected void drawRectangle(String title, String playerScores, int recPositionY, double linesRatio, Graphics g) {
        // Initialization
        int rectX = this.x + DistanceTitle;
        int rectY = this.y + recPositionY;
        // Display background of rectangle bar
        g.setColor(Color.BLACK);
        g.fillRect(rectX, rectY, expWidth, RECTANGLE_HEIGHT + 4);
        g.setColor(Color.WHITE);
        g.fillRect(rectX + 1, rectY + 1, expWidth - 2, RECTANGLE_HEIGHT + 2);
        g.setColor(Color.BLACK);
        g.fillRect(rectX + 2, rectY + 2, expWidth - 4, RECTANGLE_HEIGHT);

        // Calculate width
        int experienceWidth = (int)((linesRatio * (expWidth - 4)));
        // Calculate color
        int picIndex = (int)(linesRatio * RECTANGLE_WIDTH) - 1;
        g.drawImage(Images.RECTANGLE,
                rectX + 2, rectY + 2,
                rectX + 2 + experienceWidth, rectY + 2 + RECTANGLE_HEIGHT,
                picIndex, 0, picIndex + 1, RECTANGLE_HEIGHT, null);

        // Display string
        g.setColor(Color.WHITE);
        g.setFont(CALIBRI_FONT);
        g.drawString(title, rectX + 7, rectY + 22);

        if (playerScores != null) {
            //TODO config
            int maxBit = 5;
            int leftPad = (maxBit - playerScores.length()) * 10;
            g.drawString(playerScores, leftPad + rectX + 240, rectY + 22);
        }
    }

    protected void drawImageAtCenter(Image img, Graphics g){
        int imageWidth = img.getWidth(null);
        int imageHeight = img.getHeight(null);
        int x = this.x + (this.width - imageWidth >> 1);
        int y = this.y + (this.height - imageHeight >> 1);
        g.drawImage(img, x, y, null);
    }

    /**
     * Refresh window
     * 
     * @param g
     */
    abstract public void paint(Graphics g);

}
