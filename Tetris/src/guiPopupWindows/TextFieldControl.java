package guiPopupWindows;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class TextFieldControl extends JTextField{

    private int keyCode;
    private final String methodName;

    public TextFieldControl(int x, int y, int w, int h, String method) {
        this.setBounds(x, y, w, h);
        this.methodName = method;
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                setKeyCode(e.getKeyCode());
            }
        });
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
        this.setText(KeyEvent.getKeyText(this.keyCode));
    }

    public String getMethodName() {
        return methodName;
    }
}
