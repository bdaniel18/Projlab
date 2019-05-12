package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Ablak osztály, minden játékbeli ablak őse
 */
public abstract class Frame extends JFrame {

    protected View view;
    protected static Object syncObject = new Object(); // szálak konkurenciáját kezeli, erre lockolunk
    protected boolean running = true; // fut- e az ablak
    protected Thread waitingThread; // a bezárásra várakozó szál
    protected JPanel panel; // a fő panel az ablakon

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

    /**
     * Az ablak futtatásáért felelős függvény
     */
    public abstract void run();


}
