package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 * @author Yukun
 * 
 */
public class PanelMain extends JPanel {

	private Window[] windows = null;

	public PanelMain() {
		windows = new Window[] {
				//TODO hard coded, change after
				new WindowBackground(0, 0, 0, 0),
				new WindowGame(418, 32, 320 + 18, 576 + 18),          // main game window
				new WindowDatabase(40, 32, 320 + 18, 281),                     // database record window
				new WindowLocalRecord(40, 32 + 281 + 32, 320 + 18, 281),  // local record window
				new WindowButtons(40*3+338*2, 32, 320 + 18, 124),  // start exit window
				new WindowNext(40*3+338*2, 32*2+124, 176, 148),  // next window
				new WindowLevel(40*3+338*2+176+4, 32*2+124, 158, 148),  // level window
				new WindowScore(40*3+338*2, 32*3+148+124, 320 + 18, 113),  //  score window
				new WindowAuthor(40*3+338*2, 32*4+148+124+113, 320 + 18, 113)  // author window
		};
	}

	@Override
	public void paintComponent(Graphics g) {
		// Refresh windows
		for (int i = 0; i < windows.length; i++) {
			windows[i].paint(g);
		}
	}
}
