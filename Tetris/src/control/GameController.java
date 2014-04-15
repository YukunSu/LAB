package control;

import gui.JPanelMain;
import service.GameService;

/**
 * Receive actions triggered by users
 * Control game interface and algorithm
 * @author Yukun
 *
 */
public class GameController {

	/**
	 * Game interface
	 */
	private JPanelMain panelMain;
	
	/**
	 * Game algorithm
	 */
	private GameService gameService;
	
	public GameController(JPanelMain panel, GameService gameService){
		this.panelMain = panel;
		this.gameService = gameService;
	}
}
