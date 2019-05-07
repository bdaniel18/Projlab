package Graphics;

import java.awt.*;

public class GameCanvas extends Canvas {

    private View view;

    public GameCanvas(View v) {
        view = v;
        setSize(new Dimension(1000, 1000));
    }

    public void paint(java.awt.Graphics g) {

    }
}
