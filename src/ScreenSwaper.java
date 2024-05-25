
public class ScreenSwaper {
    Start s;
    public ScreenSwaper(Start s){
        this.s = s;
    }

    public void ScreenM(){
        s.gui.bg[0].setVisible(true);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
    }
    public void Screen0(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(true);
    }
    public void Screen1(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(true);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
    }
    public void Screen2(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(true);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
    }
    public void Screen3(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(true);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
    }
    public void Screen4(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(true);
        s.gui.bg[5].setVisible(false);
    }
}
