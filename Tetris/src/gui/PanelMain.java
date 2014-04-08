package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * @author: Yukun Su
 */
public class PanelMain extends JPanel {

	private WindowBorder[] windows = null;

	public PanelMain() {
		windows = new WindowBorder[] {
				new WindowBorder(418, 32, 320 + 18, 576 + 18),          // main game window
				new WindowBorder(40, 32, 320 + 18, 281),                     // database record window
				new WindowBorder(40, 32 + 281 + 32, 320 + 18, 281),  // local record window
				new WindowBorder(40*3+338*2, 32, 320 + 18, 124),  // start exit window
				new WindowBorder(40*3+338*2, 32*2+124, 176, 148),  // next window
				new WindowBorder(40*3+338*2+176+4, 32*2+124, 158, 148),  // level window
				new WindowBorder(40*3+338*2, 32*3+148+124, 320 + 18, 113),  //  window
				new WindowBorder(40*3+338*2, 32*4+148+124+113, 320 + 18, 113)  // author window
		};
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < windows.length; i++) {
			windows[i].printWindowBorder(g);
		}
	}
}
