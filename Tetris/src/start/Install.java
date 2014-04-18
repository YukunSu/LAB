package start;

import gui.JFrameMain;
import gui.JPanelMain;
import service.GameService;
import control.GameController;
import control.PlayerController;
import dto.GameDto;

public class Install {
    public void run() {
        // Create data transfer object
        GameDto dto = new GameDto();
        // Create panel in frame
        JPanelMain panelMain = new JPanelMain(dto);
        // Create game logic by passing data source
        GameService service = new GameService(dto);
        // Create game controller
        GameController gameController = new GameController(panelMain, service);
        // Create player controller
        PlayerController playerController = new PlayerController(gameController);
        panelMain.setPlayerController(playerController);
        // Create game main window, install panel
        new JFrameMain(panelMain);
    }
}
