package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * 
 * @author Yukun
 *
 */
public class JFrameMain extends JFrame{
	public JFrameMain() {
		this.setTitle("Tetris");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1174, 686);
		this.setResizable(false);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension screen = tool.getScreenSize();
		this.setLocation((screen.width-this.getWidth())/2, (screen.height-this.getHeight())/2);
		this.setContentPane(new JPanelMain());
	}
}
