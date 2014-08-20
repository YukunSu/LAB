package gui;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Yukun
 *
 */
public class Images {
    /**
     * Cannot instantiate this object
     */
    private Images() {}

    /**
     * Tetris picture
     */
    public static Image ACT = new ImageIcon("Graphics/Images/tetrisRectangles.png") .getImage();

    /**
     * Database title picture
     */
    public static Image DATABASE = new ImageIcon("Graphics/Words/db.png").getImage();

    /**
     * Level title picture
     */
    public static Image LEVEL = new ImageIcon("Graphics/Words/level.png").getImage();

    /**
     *  Local record title picture
     */
    public static Image LOCAL_RECORD = new ImageIcon("Graphics/Words/disk.png").getImage();

    /**
     * Number picture
     */
    public static Image NUMBER = new ImageIcon("Graphics/Words/num02.png").getImage();

    /**
     * Experience rectangle picture
     */
    public static Image RECTANGLE = new ImageIcon("Graphics/Windows/rectangle.png").getImage();

    /**
     * Removed lines title picture
     */
    public static Image REMOVED_LINES = new ImageIcon("Graphics/Words/rmline.png").getImage();

    /**
     * Score title picture
     */
    public static Image SCORES = new ImageIcon("Graphics/Words/point.png").getImage();

    /**
     * Signature picture
     */
    public static Image SIGNATUR = new ImageIcon("Graphics/Words/signature.png").getImage();

    /**
     * Window picture. There are 8 windows in the frame
     */
    public static Image WINDOW = new ImageIcon("Graphics/Windows/window02.png").getImage();

    /**
     * Pictures for each type of tetris
     */
    public static Image[] NEXT_ACT;

    static{
        NEXT_ACT = new Image[7];
        for (int i = 0; i < NEXT_ACT.length; i++) {
            NEXT_ACT[i] = new ImageIcon("Graphics/Images/" + i + ".png") .getImage();
        }
    }
}
