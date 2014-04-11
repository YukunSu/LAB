package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Yukun
 *
 */
public class WindowLocalRecord extends Window {
	
	private Image ImageLocalRecord = new ImageIcon("Graphics/Words/disk.png").getImage();
	
	public WindowLocalRecord(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		this.printWindowBorder(g);
		g.drawImage(ImageLocalRecord, this.x + DistanceTitle, this.y + DistanceTitle, null);
	}
}
