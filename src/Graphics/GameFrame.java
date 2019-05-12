package Graphics;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends Frame {

    private GameCanvas canvas;
    private JLabel lOrang, lPanda, lRound;

    public void refreshLabels() {
        lOrang.setText("Orangutans: " + view.getGame().getFloor().getOrangutanNumber());
        lPanda.setText("Pandas: " + view.getGame().getFloor().getPandaNumber());
        if (view.getGame().getGameRunning())
            lRound.setText("Orangutan " + view.getGame().getActiveOrangutan().getId());
    }


    public GameFrame(View v) {
        super(v);
        setResizable(true);
        setTitle("Game - " + view.getGame().getMapName());
    }

    public void run() {
        setPreferredSize(new Dimension(1050, 1050));
        canvas = new GameCanvas(view);
        panel.setPreferredSize(new Dimension(1050, 1050));
        canvas.addMouseListener(new MouseEventHandler(view));

        JPanel canvasPanel = new JPanel();
        canvasPanel.setPreferredSize(new Dimension(1000, 880));
        canvasPanel.add(canvas);

        JPanel pGadgets = new JPanel();
        pGadgets.setLayout(new BoxLayout(pGadgets, BoxLayout.PAGE_AXIS));
        pGadgets.setPreferredSize(new Dimension(1000, 150));
        pGadgets.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        JPanel p1 = new JPanel(new BorderLayout());
        p1.setPreferredSize(new Dimension(900, 20));
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();

        JLabel l2 = new JLabel();
        l2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        l2.setForeground(new Color(0, 120, 0));
        l2.setText(view.getGame().getMapName());
        p11.add(l2, FlowLayout.LEFT);

        JLabel l1 = new JLabel();
        l1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        l1.setText("Loaded map:");
        p11.add(l1, FlowLayout.LEFT);


        lPanda = new JLabel();
        lPanda.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        lPanda.setText("Pandas: " + view.getGame().getFloor().getPandaNumber());
        p12.add(lPanda);

        p1.add(p11, BorderLayout.WEST);
        p1.add(p12, BorderLayout.EAST);


        JPanel p2 = new JPanel(new BorderLayout());
        p2.setPreferredSize(new Dimension(900, 20));
        JPanel p21 = new JPanel();
        JPanel p22 = new JPanel();

        lRound = new JLabel();
        lRound.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        lRound.setForeground(new Color(130, 0, 0));
        p21.add(lRound, FlowLayout.LEFT);

        JLabel l22 = new JLabel();
        l22.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        l22.setText("Round of:");
        p21.add(l22, FlowLayout.LEFT);

        lOrang = new JLabel();
        lOrang.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        lOrang.setText("Orangutans: " + view.getGame().getFloor().getOrangutanNumber());
        p22.add(lOrang);

        p2.add(p21, BorderLayout.WEST);
        p2.add(p22, BorderLayout.EAST);


        JPanel p3 = new JPanel(new BorderLayout());
        p3.setPreferredSize(new Dimension(900, 40));
        JPanel p31 = new JPanel();
        JPanel p32 = new JPanel();

        JLabel logo = new JLabel();
        Image img = view.getGameLogo().getImage();
        double ratio = (double) img.getHeight(null) / (double) img.getWidth(null);
        int w = 200;
        int h = (int) ((double) w * ratio);
        img = view.getScaledImage(img, w, h);
        logo.setIcon(new ImageIcon(img));
        p31.add(logo, FlowLayout.LEFT);

        JButton exit = new JButton("Back to Main menu");
        exit.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        exit.setPreferredSize(new Dimension(250, 30));
        exit.addActionListener(new ButtonListener(Options.MAINMENU, this));
        p32.add(exit);

        p3.add(p31, BorderLayout.WEST);
        p3.add(p32, BorderLayout.EAST);

        pGadgets.add(p1);
        pGadgets.add(p2);
        pGadgets.add(p3);
        panel.add(canvasPanel, BorderLayout.PAGE_START);
        panel.add(pGadgets, BorderLayout.PAGE_END);

        pack();
        view.getGame().startGame();

        waitingThread.start();

        try {
            waitingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (canvas != null) canvas.repaint();
    }

}
