package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Játék végéről értesítő párbeszédablak
 */
public class GameEndDialog extends JDialog {

    /**
     * futtatja a párbeszédablakot
     *
     * @param parent  ős ablak
     * @param gamewon nyertes játék volt-e
     * @param results a játék eredménye( orángutánok pontjai)
     */
    public GameEndDialog(JFrame parent, boolean gamewon, Vector<String> results) {
        super(parent, "Game End.", true);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel pResult = new JPanel(new BorderLayout());
        JPanel pButtons = new JPanel();

        JLabel label = new JLabel();
        if (gamewon) label.setText("Orangutans Won!");
        else label.setText("Orangutans Lost!");
        pResult.add(label, BorderLayout.NORTH);

        JList<String> list = new JList<>();
        list.setListData(results);
        pResult.add(list, BorderLayout.SOUTH);

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
