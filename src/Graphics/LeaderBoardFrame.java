package Graphics;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

/**
 * Dicsőséglista ablak osztály
 */
public class LeaderBoardFrame extends Frame {

    public LeaderBoardFrame(View v) {
        super(v);
        setTitle("Leaderboard");
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    /**
     * Az ablak fut, ha bezárják visszatér
     */
    public void run() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        JLabel[] labels = new JLabel[5];

        try {
            File leaderBoardFile = new File("leaderboard.txt");
            Scanner sc = new Scanner(leaderBoardFile).useDelimiter("\\D+");

            for (int i = 0; i < 5; i++) {
                labels[i] = new JLabel();
                labels[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
                labels[i].setText("Orangutan " + sc.nextInt() + "  " + sc.nextInt() + " p");
                panel1.add(labels[i]);
            }
            sc.close();
        } catch (Exception e) {

        }
        panel.add(panel1, BorderLayout.PAGE_START);

        JPanel pButton = new JPanel();
        panel.add(pButton, BorderLayout.PAGE_END);

        JButton exit = new JButton("Back to Main menu");
        exit.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        exit.setPreferredSize(new Dimension(250, 30));
        exit.addActionListener(new ButtonListener(Options.MAINMENU, this));
        pButton.add(exit);

        pack();

        waitingThread.start();

        try {
            waitingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
