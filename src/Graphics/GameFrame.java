package Graphics;

import java.awt.*;

public class GameFrame extends Frame {

    private GameCanvas canvas;

    public GameFrame(View v) {
        super(v);
        setResizable(true);
        setTitle("Game - " + view.getGame().getMapName());
    }

    public void run() {
        setSize(new Dimension(1100, 1100));
        canvas = new GameCanvas(view);
        panel.setSize(new Dimension(1000, 1000));
        canvas.addMouseListener(new MouseEventHandler(view));
        panel.add(canvas);

        view.getGame().startGame();

        waitingThread.start();

        try {
            waitingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        if (canvas != null) canvas.repaint();
    }

}
