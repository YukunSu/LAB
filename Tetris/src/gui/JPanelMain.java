package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 * @author Yukun
 * 
 */
public class JPanelMain extends JPanel {

	private Window[] windows = null;

	public JPanelMain() {
		windows = new Window[] {
				//TODO hard coded, change after (config.xml)
				new WindowBackground(0, 0, 0, 0), //always be first
				new WindowAuthor(40*3+338*2, 32*4+148+124+113, 320 + 18, 113),
				new WindowButtons(40*3+338*2, 32, 320 + 18, 124),
				new WindowDatabase(40, 32, 320 + 18, 281),
				new WindowGame(418, 32, 320 + 18, 576 + 18),
				new WindowLevel(40*3+338*2+176+4, 32*2+124, 158, 148),
				new WindowLocalRecord(40, 32 + 281 + 32, 320 + 18, 281),
				new WindowNext(40*3+338*2, 32*2+124, 176, 148),
				new WindowScore(40*3+338*2, 32*3+148+124, 320 + 18, 113)
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
