package Graphics;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends Frame {

    MainMenuFrame(View v) {
        super(v);
        setTitle("Main menu");
    }

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
            view.setNextFrame(opt);
            synchronized (syncObject) {
                running = false;
                syncObject.notifyAll();
                frame.dispose();
            }
        }
    }


    public void run() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton bStart = new JButton();
        bStart.setText("Start New game");
        bStart.addActionListener(new ButtonListener(Options.NEWGAME, this));
        bStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bStart);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton bLoad = new JButton();
        bLoad.setText("Load Map");
        bLoad.addActionListener(new ButtonListener(Options.LOAD, this));
        bLoad.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bLoad);

        pack();

        waitingThread.start();

        try {
            waitingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
