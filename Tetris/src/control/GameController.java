package control;

import gui.JPanelMain;
import service.GameService;

/**
 * Receive actions triggered by users 
 * Control game interface and algorithm
 * Refresh game
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

    public GameController(JPanelMain panel, GameService gameService) {
        this.panelMain = panel;
        this.gameService = gameService;
    }

    public void keyUp() {
        this.gameService.keyUp();
        this.panelMain.repaint();
    }

    public void keyDown() {
        this.gameService.keyDown();
        this.panelMain.repaint();
    }

    public void keyLeft() {
        this.gameService.keyLeft();
        this.panelMain.repaint();
    }

    public void keyRight() {
        this.gameService.keyRight();
        this.panelMain.repaint();
    }
}
