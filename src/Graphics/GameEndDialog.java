package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GameEndDialog extends JDialog {

    public GameEndDialog(JFrame parent, boolean gamewon, Vector<String> results) {
        super(parent, "Game End.", true);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel pResult = new JPanel();
        JPanel pButtons = new JPanel();

        JLabel label = new JLabel();
        if (gamewon) label.setText("Orangutans Won!");
        else label.setText("Orangutans Lost!");
        pResult.add(label);

        JList<String> list = new JList<>();
        list.setListData(results);
        pResult.add(list);

        JDialog dialog = this;
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        pButtons.add(button);

        panel.add(pResult, BorderLayout.CENTER);
        panel.add(pButtons, BorderLayout.PAGE_END);
        add(panel);

        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
