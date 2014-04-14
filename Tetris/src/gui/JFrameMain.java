package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.ConfigGame;

/**
 * 
 * @author Yukun
 *
 */
public class JFrameMain extends JFrame{
	public JFrameMain() {
		ConfigGame gameConfig = ConfigFactory.getConfigGame();
		this.setTitle(gameConfig.getTitle());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(gameConfig.getWidth(), gameConfig.getHeight());
		this.setResizable(false);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension screen = tool.getScreenSize();
		this.setLocation((screen.width-this.getWidth())>>1, (screen.height-this.getHeight())>>1);
		this.setContentPane(new JPanelMain());
	}
}
