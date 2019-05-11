package Graphics;

import javax.swing.JButton;
import javax.swing.JList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

public class LoadMapFrame extends Frame {

    public LoadMapFrame(View v) {
        super(v);
        setTitle("Load map");
    }

    public void run() {
        JList<String> list = new JList<>();

        File folder = new File(System.getProperty("user.dir"));
        File[] files = folder.listFiles();
        Vector<String> maps = new Vector<>();


        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            int l = name.length();
            if (l > 5) {
                if (name.substring(l - 4, l).equals(".map"))
                    maps.add(name.substring(0, l - 4));
            }
        }
        list.setListData(maps);

        JButton b = new JButton();
        Frame f = this;
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!list.isSelectionEmpty()) {
                    view.setNextFrame(Options.MAINMENU);
                    try {
                        view.getGame().newGame(list.getSelectedValue() + ".map");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    synchronized (syncObject) {
                        running = false;
                        syncObject.notifyAll();
                        f.dispose();
                    }

                }
            }
        });
        b.setText("Load map");
        b.setPreferredSize(new Dimension(100, 40));
        panel.add(list, BorderLayout.CENTER);
        panel.add(b, BorderLayout.SOUTH);
        pack();

        waitingThread.start();

        try {
            waitingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
