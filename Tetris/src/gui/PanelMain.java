package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelMain extends JPanel {
	
	private WindowBorder mainWindow = new WindowBorder(60, 60, 320+18, 576+18);
	
	public PanelMain() {

	}

	@Override
	public void paintComponent(Graphics g) {
		mainWindow.printWindowBorder(g);
	}

}
