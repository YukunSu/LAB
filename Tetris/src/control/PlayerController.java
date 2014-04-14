package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author Yukun
 *
 */
public class PlayerController implements KeyListener{

	private GameController gameCtrl;
	
	public PlayerController(GameController gameCtrl){
		this.gameCtrl = gameCtrl;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar()+", ");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// not used
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// not used
	}
}
