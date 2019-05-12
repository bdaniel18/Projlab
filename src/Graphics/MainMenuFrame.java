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
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel logo = new JLabel();
        ImageIcon img = view.getGameLogo();
        double ratio = (double) img.getIconWidth() / (double) img.getIconHeight(); //szélesség-magasság aránya
        int w = 330;
        int h = (int) ((double) w / ratio);
        img = new ImageIcon(view.getScaledImage(img.getImage(), w, h));
        logo.setIcon(img);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logo);

        JPanel labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(330, 40));
        JLabel l1 = new JLabel();
        l1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        l1.setText("Loaded map:");
        labelPanel.add(l1);

        JLabel lMap = new JLabel();
        String mapname = view.getGame().getMapName();
        lMap.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        if (mapname != null) {
            lMap.setText(mapname);
            lMap.setForeground(new Color(0, 140, 0));
        } else {
            lMap.setText("No map loaded.");
            lMap.setForeground(Color.RED);
        }
        labelPanel.add(lMap);
        panel.add(labelPanel);

        JPanel pStart = new JPanel();
        pStart.setPreferredSize(new Dimension(330, 60));
        JButton bStart = new JButton();
        bStart.setText("Start new game");
        bStart.setPreferredSize(new Dimension(330, 50));
        bStart.addActionListener(new ButtonListener(Options.NEWGAME, this));
        pStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        pStart.add(bStart);
        panel.add(pStart);

        JPanel pLeaderb = new JPanel();
        pLeaderb.setPreferredSize(new Dimension(330, 60));
        JButton bLeaderb = new JButton();
        bLeaderb.setText("Leaderboard");
        bLeaderb.setPreferredSize(new Dimension(330, 50));
        bLeaderb.addActionListener(new ButtonListener(Options.LEADERBOARD, this));
        pLeaderb.setAlignmentX(Component.CENTER_ALIGNMENT);
        pLeaderb.add(bLeaderb);
        panel.add(pLeaderb);

        JPanel pLoad = new JPanel();
        pLoad.setPreferredSize(new Dimension(330, 60));
        JButton bLoad = new JButton();
        bLoad.setText("Load map");
        bLoad.setPreferredSize(new Dimension(330, 50));
        bLoad.addActionListener(new ButtonListener(Options.LOAD, this));
        pLoad.setAlignmentX(Component.CENTER_ALIGNMENT);
        pLoad.add(bLoad);
        panel.add(pLoad);


        JPanel pExit = new JPanel();
        pExit.setPreferredSize(new Dimension(330, 60));
        JButton bExit = new JButton();
        bExit.setText("Exit the game");
        bExit.setPreferredSize(new Dimension(330, 50));
        bExit.addActionListener(new ButtonListener(null, this));
        pExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        pExit.add(bExit);
        panel.add(pExit);

        pack();

        waitingThread.start();

        try {
            waitingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
