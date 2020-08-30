package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

/**
 * Egy pályát betöltő ablak
 */
public class LoadMapFrame extends Frame {

    public LoadMapFrame(View v) {
        super(v);
        setTitle("Load map");
    }

    /**
     * Az ablak kirajzolódik, és visszatér, ha bezárták
     */
    public void run() {
        // a pályafájlok listájának betöltése
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


        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel pList = new JPanel();
        pList.setPreferredSize(new Dimension(350, 400));
        JScrollPane scrollPane = new JScrollPane(list);
        list.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        list.setForeground(new Color(114, 40, 176));
        scrollPane.setPreferredSize(new Dimension(340, 330));
        pList.add(scrollPane);
        panel.add(pList);

        JPanel pDown = new JPanel();
        JLabel logo = new JLabel();
        Image img = view.getGameLogo().getImage();
        double ratio = (double) img.getHeight(null) / (double) img.getWidth(null);
        int w = 200;
        int h = (int) (ratio * (double) w);
        img = view.getScaledImage(img, w, h);
        logo.setIcon(new ImageIcon(img));
        pDown.add(logo);

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
        b.setPreferredSize(new Dimension(120, 30));
        pDown.add(b);

        pDown.setPreferredSize(new Dimension(360, 70));
        panel.add(pDown);

        pack();

        waitingThread.start();

        try {
            waitingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
