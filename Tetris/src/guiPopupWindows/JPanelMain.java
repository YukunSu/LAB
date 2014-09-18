package guiPopupWindows;

import gui.Images;
import gui.Window;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.ConfigFrame;
import config.ConfigGame;
import config.ConfigWindow;
import control.GameController;
import control.PlayerController;
import dto.GameDto;

/**
 * 
 * @author Yukun
 * 
 */
public class JPanelMain extends JPanel {

    private static final int BUTTON_SIZE_WIDTH = ConfigGame.getConfigFrame().getButtonConfig().getButtonWidth();

    private static final int BUTTON_SIZE_HEIGHT = ConfigGame.getConfigFrame().getButtonConfig().getButtonHeight();

    private List<Window> windows = null;

    private JButton buttonStart;

    private JButton buttonConfig;

    private GameController gameController = null;

    public JPanelMain(GameController gc, GameDto dto) {
        this.gameController = gc;
        this.setLayout(null);
        this.initializeComponent();
        this.initializeWindow(dto);
        this.addKeyListener(new PlayerController(gameController));
    }

    /**
     * Initialize Component and add key listener
     */
    private void initializeComponent() {
        this.buttonStart = new JButton(Images.BUTTON_START);
        this.buttonStart.setBounds(
                ConfigGame.getConfigFrame().getButtonConfig().getStartX(),
                ConfigGame.getConfigFrame().getButtonConfig().getStartY(),
                BUTTON_SIZE_WIDTH, BUTTON_SIZE_HEIGHT);
        this.buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                gameController.start();
                requestFocus();
            }
        });
        this.add(buttonStart);

        this.buttonConfig = new JButton(Images.BUTTON_CONFIG);
        this.buttonConfig.setBounds(
                ConfigGame.getConfigFrame().getButtonConfig().getUserConfigX(),
                ConfigGame.getConfigFrame().getButtonConfig().getUserConfigY(),
                BUTTON_SIZE_WIDTH, BUTTON_SIZE_HEIGHT);
        this.buttonConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                gameController.displayUserConfig();
            }
        });
        this.add(buttonConfig);
    }

    /**
     *  Initialize Window
     * @param dto 
     */
    private void initializeWindow(GameDto dto){
        try{
            //Get game configuration
            ConfigFrame configGame = ConfigGame.getConfigFrame();
            //Get window configuration
            List<ConfigWindow> configWindow = configGame.getListConfigWindow();
            //Create an array for all the windows in frame
            windows = new ArrayList<Window>(configWindow.size());
            //Create window objects
            for(ConfigWindow singleConfigWindow : configWindow){
                //Reflection
                //Get class object
                Class<?> c = Class.forName(singleConfigWindow.getClassName());
                //Get constructor of Window
                Constructor<?> constructor = c.getConstructor(int.class, int.class, int.class, int.class);
                //Create object using the constructor
                Window window = (Window)constructor.newInstance(
                        singleConfigWindow.getX(), singleConfigWindow.getY(), 
                        singleConfigWindow.getW(), singleConfigWindow.getH());
                //Set game data source to each window
                window.setDto(dto);
                //Collect windows
                windows.add(window);
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

    public void buttonSwitch(boolean onOff) {
        this.buttonConfig.setEnabled(onOff);
        this.buttonStart.setEnabled(onOff);
    }
}
