import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ActionSolver implements ActionListener{

    Start s;
    boolean iJackpot = false;
    ArrayList<String> text = new ArrayList<>();
    BufferedReader brAs;
    public ActionSolver (Start s) throws IOException {
        brAs = new BufferedReader(new FileReader("textfiles/textAs.txt"));
        String temp;
        while((temp = brAs.readLine())!=null){
            text.add(temp);
        }
    this.s = s;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pAction = ae.getActionCommand();

        switch (pAction) {
            case "resetGame":
                s.ss.backToTheLobby();
                try {
                    s.ss.ScreenM();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                s.sc0.jackpotWon = false;
                s.sc1.mission = 0;
                s.sc1.f = 0;
                s.sc4.bossIsSlain = false;
                s.scm.iCat = 0;
                break;
            case "Screen0":
                s.ss.Screen0();
                if (!iJackpot) {
                    iJackpot = true;
                    s.gui.textBox.setText(text.get(0));
                } else {
                    s.gui.textBox.setText(text.get(1));
                }
                break;
            case "ScreenM":
                s.gui.textBox.setText(text.get(2));
                try {
                    s.ss.ScreenM();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Screen1":
                s.gui.textBox.setText(text.get(3));
                s.ss.Screen1();
                break;
            case "Screen2":
                if(!s.p.aqKeys){
                    s.gui.textBox.setText(text.get(4));
                }else {
                    s.gui.textBox.setText(text.get(5));
                    s.ss.Screen2();
                }
                break;
            case "Screen3":
                s.gui.textBox.setText(text.get(6));
                s.ss.Screen3();
                break;
            case "Screen4":
                s.gui.textBox.setText(text.get(7));
                s.ss.Screen4();
                break;
            case "TalkBed":
                s.scm.talkBed();
                break;
            case "LookBed":
                s.scm.lookBed();
                break;
            case "FightBed":
                s.scm.fightBed();
                break;
            case "ExBed":
                s.scm.exBed();
                break;
            case "TalkCat":
                s.scm.talkCat();
                break;
            case "LookCat":
                s.scm.lookCat();
                break;
            case "FightCat":
                s.scm.fightCat();
                break;
            case "ExCat":
                s.scm.exCat();
                break;
            case "TalkCrate":
                s.scm.talkCrate();
                break;
            case "LookCrate":
                s.scm.lookCrate();
                break;
            case "FightCrate":
                s.scm.fightCrate();
                break;
            case "ExCrate":
                s.scm.exCrate();
                break;
            case "TalkJackpot":
                s.sc0.talkJackpot();
                break;
            case "LookJackpot":
                s.sc0.lookJackpot();
                break;
            case "FightJackpot":
                s.sc0.fightJackpot();
                break;
            case "ExJackpot":
                s.sc0.exJackpot();
                break;
            case "TalkKey":
                s.sc0.talkKeys();
                break;
            case "LookKey":
                s.sc0.lookKeys();
                break;
            case "FightKey":
                s.sc0.fightKeys();
                break;
            case "ExKey":
                s.sc0.exKeys();
                break;
            case "TalkDevice":
                s.sc0.talkDevice();
                break;
            case "LookDevice":
                s.sc0.lookDevice();
                break;
            case "FightDevice":
                s.sc0.fightDevice();
                break;
            case "ExDevice":
                s.sc0.exDevice();
                break;
            case "TalkGeneral":
                s.sc1.talkGeneral();
                break;
            case "LookGeneral":
                s.sc1.lookGeneral();
                break;
            case "FightGeneral":
                s.sc1.fightGeneral();
                break;
            case "ExGeneral":
                s.sc1.exGeneral();
                break;
            case "BossTerminal":
                s.sc2.bossTerminal();
                break;
            case "GeneralTerminal":
                s.sc2.generalTerminal();
                break;
            case "HouseTerminal":
                s.sc2.houseTerminal();
                break;
            case "JackpotTerminal":
                s.sc2.jackpotTerminal();
                break;
            case "TalkEnemy":
                s.sc3.talkEnemy();
                break;
            case "LookEnemy":
                s.sc3.lookEnemy();
                break;
            case "FightEnemy":
                s.sc3.fightEnemy();
                break;
            case "ExEnemy":
                s.sc3.exEnemy();
                break;
            case "TalkBoss":
                s.sc4.talkBoss();
                break;
            case "LookBoss":
                s.sc4.lookBoss();
                break;
            case "FightBoss":
                s.sc4.fightBoss();
                break;
            case "ExBoss":
                s.sc4.exBoss();
                break;
        }
    }
}
