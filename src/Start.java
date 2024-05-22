public class Start {
    ActionSolver as = new ActionSolver(this);
    public ScreenSwaper ss = new ScreenSwaper(this);
    Gui gui = new Gui(this);
    public static void startGame(){
        new Start();
    }
}