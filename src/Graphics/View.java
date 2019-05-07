package Graphics;


import businesslogic.Game;

public class View {

    public View(Game g) {
        game = g;
    }

    private Game game;
    private Options nextFrame = Options.MAINMENU;
    private Frame f = null;

    public void setNextFrame(Options o) {
        nextFrame = o;
    }

    public Game getGame() {
        return game;
    }

    public void start() {
        while (nextFrame != null) {
            switch (nextFrame) {
                case MAINMENU:
                    f = new MainMenuFrame(this);
                    nextFrame = null;
                    break;
                case LOAD:
                    f = new LoadMapFrame(this);
                    nextFrame = null;
                    break;
                case LEADERBOARD:
                    f = new LeaderBoardFrame(this);
                    nextFrame = null;
                    break;
                case NEWGAME:
                    if (game.getMapid() < 0) nextFrame = Options.MAINMENU;
                    f = new GameFrame(this);
                    break;
                default:
                    break;
            }
            f.run();
        }
    }
}
