package gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Draw window
 * @author Yukun
 *
 */
public abstract class Window {
	protected final int ZERO = 0;
	protected int windowBorderWidth = 9;
	protected int DistanceTitle = 16;
	protected Image windowImage = new ImageIcon("Graphics/Windows/window01.png").getImage();
	//window picture width
	protected int windowWidth = windowImage.getWidth(null);
	//window picture height
	protected int window_height  = windowImage.getHeight(null);
	//x coordinate of window's upper left corner
	protected int x;
	//y coordinate of window's upper left corner
	protected int y;
	//window width
	protected int width;
	//window height
	protected int height;
	
	protected Window(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	
	protected void setWindowBorderWidth(int border){
		windowBorderWidth = border;
	}
	
	protected void setWindowImage(String picNameExt){
		windowImage  = new ImageIcon("Graphics/Windows/"+ picNameExt).getImage();
		windowWidth = windowImage.getWidth(null);
		window_height = windowImage.getHeight(null);
	}
	
	protected void setDistanceTitle(int distance){
		this.DistanceTitle = distance;
	}
	
	/**
	 * Draw window
	 * @param g
	 */
	protected void printWindowBorder(Graphics g){
		// Draw upper left
		g.drawImage(windowImage, x, y, x + windowBorderWidth, y + windowBorderWidth, ZERO, ZERO,
				windowBorderWidth, windowBorderWidth, null);
		// Draw upper middle
		g.drawImage(windowImage, x + windowBorderWidth, y, x + width - windowBorderWidth, y
				+ windowBorderWidth, windowBorderWidth, ZERO, windowWidth - windowBorderWidth,
				windowBorderWidth, null);
		// Draw upper right
		g.drawImage(windowImage, x + width - windowBorderWidth, y, x + width, y + windowBorderWidth,
				windowWidth - windowBorderWidth, ZERO, windowWidth, windowBorderWidth,
				null);

		// Draw middle left
		g.drawImage(windowImage, x, y + windowBorderWidth, x + windowBorderWidth, y + height
				- windowBorderWidth, ZERO, windowBorderWidth, windowBorderWidth, window_height
				- windowBorderWidth, null);
		// Draw middle middle
		g.drawImage(windowImage, x + windowBorderWidth, y + windowBorderWidth, x + width
				- windowBorderWidth, y + height - windowBorderWidth, windowBorderWidth, windowBorderWidth,
				windowWidth - windowBorderWidth, window_height - windowBorderWidth,
				null);
		// Draw middle right
		g.drawImage(windowImage, x + width - windowBorderWidth, y + windowBorderWidth, x + width, y
				+ height - windowBorderWidth, windowWidth - windowBorderWidth, windowBorderWidth,
				windowWidth, window_height - windowBorderWidth, null);

		// Draw lower left
		g.drawImage(windowImage, x, y + height - windowBorderWidth, x + windowBorderWidth, y + height,
				ZERO, window_height - windowBorderWidth, windowBorderWidth, window_height,
				null);
		// Draw lower middle
		g.drawImage(windowImage, x + windowBorderWidth, y + height - windowBorderWidth, x + width
				- windowBorderWidth, y + height, windowBorderWidth, window_height
				- windowBorderWidth, windowWidth - windowBorderWidth, window_height,
				null);
		// Draw lower right
		g.drawImage(windowImage, x + width - windowBorderWidth, y + height - windowBorderWidth, x + width,
				y + height, windowWidth - windowBorderWidth, window_height
						- windowBorderWidth, windowWidth, window_height, null);
	}

	/**
	 * Refresh window
	 * @param g
	 */
	abstract public void paint(Graphics g);

}