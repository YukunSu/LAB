package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import dto.Player;

public abstract class WindowDisplayRecords extends Window{

    // TODO config file
    protected static final int MAX_ROW_AMOUNT = 5;
    protected static int START_Y = 0;
    protected static int DISTANCE_ROW = 0;

    protected WindowDisplayRecords(int x, int y, int w, int h) {
        super(x, y, w, h);
        DISTANCE_ROW = (this.height - (RECTANGLE_HEIGHT + 4) * 5
                - (DistanceTitle << 1) - Images.DATABASE.getHeight(null))
                / MAX_ROW_AMOUNT;
        START_Y = DistanceTitle + Images.DATABASE.getHeight(null)
                + DISTANCE_ROW;
    }

    @Override
    abstract public void paint(Graphics g);

    /**
     * Display all record bars
     * @param imageTitle
     * @param players
     * @param g
     */
    public void displayRecords(Image imageTitle, List<Player> players, Graphics g) {
        this.printWindowBorder(g);
        g.drawImage(imageTitle, this.x + DistanceTitle, this.y
                + DistanceTitle, null);
        int currentScores = this.dto.getCurrentScore();
        for (int i = 0; i < MAX_ROW_AMOUNT; i++) {
            Player singlePlayer = players.get(i);
            int playerCurrentScores = singlePlayer.getScore();
            double percentage = (double)currentScores / (double)playerCurrentScores;
            percentage = percentage > 1 ? 1 : percentage;
            String playerCurrentScoresString = playerCurrentScores == 0 ? null : Integer.toString(playerCurrentScores);
            this.drawRectangle(singlePlayer.getName(), playerCurrentScoresString, START_Y + i
                    * (RECTANGLE_HEIGHT + 4 + DISTANCE_ROW), percentage, g);
        }
    }

}
