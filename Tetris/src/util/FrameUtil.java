package util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameUtil {

    public static void setFrameCenter(JFrame frame) {
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension screen = tool.getScreenSize();
        int x = (screen.width - frame.getWidth()) >> 1;
        int y = (screen.height - frame.getHeight()) >> 1;
        frame.setLocation(x, y);
    }
}
