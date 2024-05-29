import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class takes care of what is on Screen1 - military base
 */
public class sc1Actions {
    Start s;
    int f =0;
    ArrayList<String> text = new ArrayList<>();
    BufferedReader br1;
    int mission=0;
    public sc1Actions(Start s) throws IOException {
        br1 = new BufferedReader(new FileReader("textfiles/text1.txt"));
        String temp;
        while((temp = br1.readLine())!=null){
            text.add(temp);
        }
        this.s = s;
    }

    /**
     * This method is used when player picks the option to talk with the general
     */
    public void talkGeneral(){
        s.gui.textBox.setText(text.get(0)+"\n"+text.get(1));
        s.playSound(s.generalHem);
    }
    /**
     * This method is used when player picks the option to look at the general
     */
    public void lookGeneral(){
        s.gui.textBox.setText(text.get(2)+"\n"+text.get(3));
        s.playSound(s.generalGrr);
    }
    /**
     * This method is used when player picks the option to fight with the general depending on the equipment if fail or succeeds
     */
    public void fightGeneral(){
        if(f == 0){
            if(s.p.aqGun){
                s.gui.textBox.setText(text.get(4));
                mission++;
                f++;
                s.playSound(s.generalHem);
            }else if (s.p.currHp ==1){
                s.gui.textBox.setText(text.get(5));
                s.p.currHp--;
                s.ss.gameOver(1);
                s.playSound(s.generalOoh);
            } else {
                s.gui.textBox.setText(text.get(5));
                s.p.currHp--;
                s.playSound(s.generalOoh);
            }
        }else{
            s.gui.textBox.setText(text.get(6)+"\n"+text.get(7));
            s.playSound(s.generalGrr);
        }
        s.p.checkPlayer();
    }
    /**
     * This method is used when player picks the option to get his current mission from the general, depending on what the player did, the general changes dialogue
     */
    public void exGeneral(){
        if (mission == 0){
            s.gui.textBox.setText(text.get(8)+"\n"+text.get(9));
        }else if (mission == 1 && s.p.aqKeys)  {
            s.gui.textBox.setText(text.get(10)+"\n"+text.get(11));
        }else if (mission == 1) {
            s.gui.textBox.setText(text.get(12)+"\n"+text.get(13));
        } else if (s.sc4.bossIsSlain) {
            s.gui.textBox.setText(text.get(14)+"\n"+text.get(15));
            s.p.aqMedal = true;
        }
        s.playSound(s.generalHem);
        s.p.checkPlayer();
    }
}
