package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Yukun
 * 
 */
public class PlayerController extends KeyAdapter {

    private GameController gameCtrl;

    public PlayerController(GameController gameCtrl) {
        this.gameCtrl = gameCtrl;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO change after
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            this.gameCtrl.keyUp();
            break;

        case KeyEvent.VK_DOWN:
            this.gameCtrl.keyDown();
            break;

        case KeyEvent.VK_LEFT:
            this.gameCtrl.keyLeft();
            break;

        case KeyEvent.VK_RIGHT:
            this.gameCtrl.keyRight();
            break;

        case KeyEvent.VK_W:
            this.gameCtrl.keyUp();
            break;

        case KeyEvent.VK_S:
            this.gameCtrl.keyDown();
            break;

        case KeyEvent.VK_A:
            this.gameCtrl.keyLeft();
            break;

        case KeyEvent.VK_D:
            this.gameCtrl.keyRight();
            break;

        case KeyEvent.VK_H:
            this.gameCtrl.test();
            break;

        default:
            break;
        }
    }
}
