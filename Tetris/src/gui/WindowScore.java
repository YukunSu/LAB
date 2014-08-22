package gui;

import java.awt.Graphics;

public class WindowScore extends Window {

    /**
     * Max bits of the score. Max Score = 99999
     */
    private static final int MAX_BIT = 5;
    private static final int REMOVE_LINE_HEIGHT = Images.REMOVED_LINES.getHeight(null);
    private static final int SCORE_HEIGHT = Images.SCORES.getHeight(null);
    //TODO config file
    private static final int TO_LEVEL_UP = 100;
    private final int rmLinePositionY;
    private final int scorePositionY;
    private final int expPositionY;
    private int scoreAndRmLinesPositionX = 0;

    public WindowScore(int x, int y, int w, int h) {
        super(x, y, w, h);
        // Initialize X coordinate for score and removed lines
        scoreAndRmLinesPositionX = this.width - NUMBER_WIDTH * MAX_BIT - DistanceTitle;
        // Initialize Y coordinate of score
        scorePositionY = DistanceTitle;
        // Initialize Y coordinate of removed lines
        rmLinePositionY = scorePositionY + SCORE_HEIGHT + DistanceTitle;
        // Initialize Y coordinate of experience bar
        expPositionY = rmLinePositionY + REMOVE_LINE_HEIGHT + DistanceTitle;
    }

    public void paint(Graphics g) {
        this.printWindowBorder(g);
        // Display scores
        g.drawImage(Images.SCORES, this.x + scorePositionY, this.y + scorePositionY, null);
        this.drawNumberLeftPad(scoreAndRmLinesPositionX, scorePositionY, this.dto.getCurrentScore(), MAX_BIT, g);

        // Display amount of removed lines
        g.drawImage(Images.REMOVED_LINES, this.x + scorePositionY, this.y + rmLinePositionY, null);
        this.drawNumberLeftPad(scoreAndRmLinesPositionX, rmLinePositionY, this.dto.getLineRemoved(), MAX_BIT, g);

        // Display exp bar
        int currentRmLines = this.dto.getLineRemoved();
        this.drawRectangle("Next Level", null, expPositionY, (double)(currentRmLines % TO_LEVEL_UP) / (double)TO_LEVEL_UP, g);
    }
}
