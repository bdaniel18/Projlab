package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Menu egy gombjára való kattintást figyeli
 */
public class ButtonListener implements ActionListener {
    Options opt;
    Frame frame;

    public ButtonListener(Options o, Frame f) {
        opt = o;
        frame = f;
    }

    public void actionPerformed(ActionEvent e) {
        frame.view.setNextFrame(opt);
        synchronized (frame.syncObject) {
            frame.running = false;
            frame.syncObject.notifyAll();
            frame.dispose();
        }
    }
}