public class Start {
    ActionSolver as = new ActionSolver(this);
    public ScreenSwaper ss = new ScreenSwaper(this);
    public Player p = new Player(this);
    Gui gui = new Gui(this);
    public scMActions scm = new scMActions(this);
    public sc0Actions sc0 = new sc0Actions(this);
    public sc1Actions sc1 = new sc1Actions(this);
    public sc2Actions sc2 = new sc2Actions(this);
    public sc3Actions sc3 = new sc3Actions(this);
    public sc4Actions sc4 = new sc4Actions(this);
    public Start() {
        ss.ScreenM();
        p.setBasePlayer();
    }
    public static void startGame(){
        new Start();
    }
}