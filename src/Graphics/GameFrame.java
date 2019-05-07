package Graphics;

import java.awt.*;

public class GameFrame extends Frame {

    private GameCanvas canvas;

    public GameFrame(View v) {
        super(v);
    }

    public void run() {
        setSize(new Dimension(1100, 1100));
        canvas = new GameCanvas(view);
        panel.add(canvas);
    }
}
