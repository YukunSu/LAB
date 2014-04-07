package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class FrameStartGame extends JFrame{
	public FrameStartGame() {
		this.setTitle("Tetris");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setResizable(false);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension screen = tool.getScreenSize();
		this.setLocation((screen.width-this.getWidth())/2, (screen.height-this.getHeight())/2);
		this.setContentPane(new PanelMain());
	}
}
