package guiPopupWindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import util.FrameUtil;
import control.GameController;
/**
 * 
 * @author Yukun
 *
 */
public class JFrameUserConfig extends JFrame{
    private JButton buttonSubmit = new JButton("Submit");
    private JButton buttonCancel = new JButton("Cancel");
    private JButton buttonApply = new JButton("Apply");
    private JLabel errorMessage = new JLabel();
    private TextFieldControl[] textFields = new TextFieldControl[8];
    private JList skinList = null;
    private JPanel skinPreview = null;
    private DefaultListModel skinData = new DefaultListModel();
    private final static Image IMAGE_PSP = new ImageIcon("Data/psp.jpg").getImage();
    private final static String PATH = "Data/control.dat";
    private GameController gameController; 
    private final static String[] METHOD_NAMES = {
        "keyRight", "keyUp", "keyLeft", "keyDown",
        "keyFunctionLeft", "keyFunctionUp", "keyFunctionRight", "keyFunctionDown"
    };
    public JFrameUserConfig(GameController gameController) {
        this.gameController = gameController;
        this.setLayout(new BorderLayout());
        this.setTitle("User Configuration");
        this.initTextFields();
        this.add(this.createMainPanel(), BorderLayout.CENTER);
        this.add(this.createButtonPanel(), BorderLayout.SOUTH);
        this.setResizable(false);
        this.setSize(600, 355);
        // put it at center
        FrameUtil.setFrameCenter(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setOver();
            }

            @Override
            public void windowClosed(WindowEvent arg0) {
                setOver();
            }
        });
    }

    private void initTextFields() {
        int x = 3;
        int y = 48;
        int w = 64;
        int h = 20;
        for (int i = 0; i < textFields.length/2; i++) {
            textFields[i] = new TextFieldControl(x, y, w, h, METHOD_NAMES[i]);
            y += 30;
        }
        x = 525;
        y = 54;
        for (int i = textFields.length/2; i < textFields.length; i++) {
            textFields[i] = new TextFieldControl(x, y, w, h, METHOD_NAMES[i]);
            y += 28;
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH));
            @SuppressWarnings("unchecked")
            HashMap<Integer, String> configSet = (HashMap<Integer, String>) ois.readObject();
            ois.close();
            Set<Entry<Integer, String>> entrySet = configSet.entrySet();
            for (Entry<Integer, String> entry : entrySet) {
                for (TextFieldControl tfc: textFields) {
                    if(tfc.getMethodName().equals(entry.getValue())) {
                        tfc.setKeyCode(entry.getKey());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (applyButtonEvent()) {
                    setVisible(false);
                    gameController.setOver();
                }
            }
        });
        this.errorMessage.setForeground(Color.RED);
        panel.add(this.errorMessage);
        panel.add(this.buttonSubmit);

        this.buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameController.setOver();
            }
        });
        panel.add(this.buttonCancel);

        this.buttonApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                applyButtonEvent();
            }
        });
        panel.add(this.buttonApply);
        return panel;
    }
    private JTabbedPane createMainPanel() {
        JTabbedPane tabbedPanel = new JTabbedPane();
        tabbedPanel.addTab("Control Setting", this.createControlPanel());
        //tabbedPanel.addTab("Theme Setting", this.createSkinPanel());
        return tabbedPanel;
    }
    
    private Component createSkinPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        // TODO add content
        this.skinData.addElement("asdf");
        this.skinData.addElement("yer5tw");
        this.skinData.addElement("gcx");
        this.skinData.addElement("fd");
        this.skinList = new JList(this.skinData);
        this.skinPreview = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(IMAGE_PSP, 0, 0, null);
            }
        };
        panel.add(new JScrollPane(this.skinList), BorderLayout.WEST);
        panel.add(new JScrollPane(this.skinPreview), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(IMAGE_PSP, 0, 0, null);
            }
        };
        panel.setLayout(null);
        for (int i = 0; i < textFields.length; i++) {
            panel.add(textFields[i]);
        }
        return panel;
    }

    /**
     * Write game config
     */
    private boolean applyButtonEvent() {
        HashMap<Integer, String> keySet = new HashMap<Integer, String>();
        for (int i = 0; i < textFields.length; i++) {
            int keyCode = this.textFields[i].getKeyCode();
            if (keyCode == 0) {
                this.errorMessage.setText("Control Setting Error!");
                return false;
            }
            keySet.put(keyCode, this.textFields[i].getMethodName());
        }
        if (keySet.size() != 8) {
            this.errorMessage.setText("Error: Same Control Key!");
            return false;
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(keySet);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.errorMessage.setText(e.getMessage());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            this.errorMessage.setText(e.getMessage());
            return false;
        }
        this.errorMessage.setText(null);
        return true;
    }

    private void setOver() {
        gameController.setOver();
    }
}
