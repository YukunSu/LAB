package gui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.ConfigGame;
import config.ConfigWindow;
import control.GameController;
import control.PlayerController;

/**
 * 
 * @author Yukun
 * 
 */
public class JPanelMain extends JPanel {

	private List<Window> windows = null;

	public JPanelMain() {
		initializeComponent();
		initializeWindow();
	}
	
	/**
	 * Initialize Component and add key listener
	 */
	private void initializeComponent() {
		GameController gameCtrl = new GameController(this);
		this.addKeyListener(new PlayerController(gameCtrl));
	}

	/**
	 *  Initialize Window
	 */
	private void initializeWindow(){
		try{
			//Get game configuration
			ConfigGame configGame = ConfigFactory.getConfigGame();
			//Get window configuration
			List<ConfigWindow> configWindow = configGame.getListConfigWindow();
			//Create an array for all the windows in frame
			windows = new ArrayList<Window>(configWindow.size());
			//Create window objects
			for(ConfigWindow singleConfigWindow : configWindow){
				//Injection
				//Get class object
				Class<?> c = Class.forName(singleConfigWindow.getClassName());
				//Get constructor of Window
				Constructor<?> constructor = c.getConstructor(int.class, int.class, int.class, int.class);
				//Create object using the constructor
				Window w = (Window)constructor.newInstance(
						singleConfigWindow.getX(), singleConfigWindow.getY(), 
						singleConfigWindow.getW(), singleConfigWindow.getH());
				windows.add(w);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		//May have issues without the line below
		super.paintComponent(g);
		// Paint windows
		for (int i = 0; i < windows.size(); windows.get(i++).paint(g));
		this.requestFocus();
	}
}
