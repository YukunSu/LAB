package guiPopupWindows;

import javax.swing.JFrame;

import util.FrameUtil;
import config.ConfigFrame;
import config.ConfigGame;

/**
 * 
 * @author Yukun
 * 
 */
public class JFrameMain extends JFrame {
    public JFrameMain(JPanelMain panelMain) {
        ConfigFrame gameConfig = ConfigGame.getConfigFrame();
        this.setTitle(gameConfig.getTitle());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(gameConfig.getWidth(), gameConfig.getHeight());
        this.setResizable(false);
        // put it at center
        FrameUtil.setFrameCenter(this);
        this.setContentPane(panelMain);
        this.setVisible(true);
    }
}
