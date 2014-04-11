package gui;

import java.awt.Graphics;

public class WindowScore extends Window {
	public WindowScore(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		this.printWindowBorder(g);
	}
}
