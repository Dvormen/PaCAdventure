import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    public void talkGeneral(){
        s.gui.textBox.setText(text.get(0));
        s.playSound(s.generalHem);
    }
    public void lookGeneral(){
        s.gui.textBox.setText(text.get(1));
        s.playSound(s.generalGrr);
    }
    public void fightGeneral(){
        if(f == 0){
            if(s.p.aqGun){
                s.gui.textBox.setText(text.get(2));
                mission++;
                f++;
                s.playSound(s.generalHem);
            }else if (s.p.currHp ==1){
                s.gui.textBox.setText(text.get(3));
                s.p.currHp--;
                s.ss.gameOver(1);
                s.playSound(s.generalOoh);
            } else {
                s.gui.textBox.setText(text.get(3));
                s.p.currHp--;
                s.playSound(s.generalOoh);
            }
        }else{
            s.gui.textBox.setText(text.get(4));
            s.playSound(s.generalGrr);
        }
        s.p.checkPlayer();
    }
    public void exGeneral(){
        if (mission == 0){
            s.gui.textBox.setText(text.get(5));
        }else if (mission == 1 && s.p.aqKeys)  {
            s.gui.textBox.setText(text.get(6));
        }else if (mission == 1) {
            s.gui.textBox.setText(text.get(7));
        } else if (s.sc4.bossIsSlain) {
            s.gui.textBox.setText(text.get(8));
            s.p.aqMedal = true;
        }
        s.playSound(s.generalHem);
        s.p.checkPlayer();
    }
}
