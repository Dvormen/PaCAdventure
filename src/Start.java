public class Start {
    ActionSolver as = new ActionSolver(this);
    public ScreenSwaper ss = new ScreenSwaper(this);
    public Player p = new Player(this);
    Gui gui = new Gui(this);
    public Start() {
        p.setBasePlayer();
    }
    public static void startGame(){
        new Start();
    }
}