package guiPopupWindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.GameController;
import util.FrameUtil;

public class JFrameSaveScore extends JFrame{

    private JButton buttonOK = null;
    private JLabel labelScore = null;
    private JLabel labelName = null;
    private JLabel errorMessage = null;
    private JTextField textfieldUsername = null;
    private GameController gameController = null;

    public JFrameSaveScore(GameController gc) {
        this.gameController = gc;
        this.setTitle("Save Score");
        this.setSize(256, 128);
        FrameUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.initComponent();
        this.createAction();
    }

    public void display(int score) {
        this.labelScore.setText("Your Score: " + score);
        this.setVisible(true);
    }

    private void createAction() {
        this.buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textfieldUsername.getText();
                errorMessage.setText(null);
                if (name == null || name.isEmpty() || name.length() > 16) {
                    errorMessage.setText("Name Error!");
                } else {
                    setVisible(false);
                    gameController.saveScore(name);
                }
            }
        });
    }

    private void initComponent() {
        JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.labelScore = new JLabel("");
        panelNorth.add(labelScore);

        this.errorMessage = new JLabel();
        this.errorMessage.setForeground(Color.RED);
        panelNorth.add(errorMessage);

        this.add(panelNorth, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.textfieldUsername = new JTextField(7);
        this.labelName = new JLabel("Your Name: ");
        this.textfieldUsername.requestFocus();
        panelCenter.add(labelName);
        panelCenter.add(textfieldUsername);
        this.add(panelCenter, BorderLayout.CENTER);

        this.buttonOK = new JButton("OK");
        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSouth.add(buttonOK);
        this.add(panelSouth, BorderLayout.SOUTH);
    }
}
