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

    /**
	 * 
	 */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
}
