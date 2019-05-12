package Graphics;

import javafx.geometry.HorizontalDirection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LeaderBoardFrame extends Frame {

    public LeaderBoardFrame(View v) {
        super(v);
        setTitle("Leaderboard");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel[] labels = new JLabel[5];

        try {
            File leaderBoardFile = new File("leaderboard.txt");
            Scanner sc = new Scanner(leaderBoardFile).useDelimiter("\\s*");

            for(int i = 0; i < 5; i++) {
                labels[i] = new JLabel();
                labels[i].setText("Orangutan " + sc.nextInt() + " " + sc.nextInt());
                panel.add(labels[i]);
            }
            sc.close();
        } catch(Exception e) {

        }
        add(panel);

        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public void run() {

    }
}
