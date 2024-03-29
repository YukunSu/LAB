package control;

import gui.JPanelMain;
import service.GameService;
import dao.DataLocal;
import dao.DataRecords;
import dao.DataTest;

/**
 * Receive actions triggered by users 
 * Control game interface and algorithm
 * Refresh game
 * @author Yukun
 * 
 */
public class GameController {

    private DataRecords dataInDatabase;
    private DataRecords dataInLocalRecords;
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

        // When database is applicable, use the following line
        // this.dataInDatabase = new Database();
        this.dataInDatabase = new DataTest();
        this.gameService.setDatabaseRecord(dataInDatabase.loadData());

        this.dataInLocalRecords = new DataLocal();
        this.gameService.setLocalRecord(dataInLocalRecords.loadData());
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

    // TODO TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void test() {
        this.gameService.testLevelUP();
        this.panelMain.repaint();
    }
}
