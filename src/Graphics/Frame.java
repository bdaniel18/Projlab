package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class Frame extends JFrame {

    protected View view;
    protected static Object syncObject = new Object();
    protected boolean running = true;
    protected Thread waitingThread;
    protected JPanel panel;

    public Frame(View v) {
        view = v;

        waitingThread = new Thread() {
            public void run() {
                synchronized (syncObject) {
                    while (running)
                        try {
                            syncObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        };

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                synchronized (syncObject) {
                    running = false;
                    syncObject.notifyAll();
                }
            }
        });

        setPreferredSize(new Dimension(400, 500));
        panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(400, 500));

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(view.getGameIcon().getImage());
    }

    public abstract void run();


}
