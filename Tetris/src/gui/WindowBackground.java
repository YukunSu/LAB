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

	//TODO temp background
	private Image imageBackground = new ImageIcon("Graphics/Background/01.jpg").getImage();
	
	public WindowBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(imageBackground, ZERO, ZERO, null);
	}

}
