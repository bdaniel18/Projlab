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
                    break;
                case LOAD:
                    f = new LoadMapFrame(this);
                    break;
                case LEADERBOARD:
                    f = new LeaderBoardFrame(this);
                    break;
                case NEWGAME:
                    f = new GameFrame(this);
                    break;
                default:
                    break;
            }
            nextFrame = null;
            f.run();
        }
    }
}
