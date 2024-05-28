import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class sc4Actions {
    Start s;
    boolean bossIsSlain = false;
    ArrayList<String> text = new ArrayList<>();
    BufferedReader br4;
    public sc4Actions(Start s) throws IOException {
        br4 = new BufferedReader(new FileReader("textfiles/text3.txt"));
        String temp;
        while((temp = br4.readLine())!=null){
            text.add(temp);
        }
        this.s = s;
    }
    public void talkBoss(){
        s.gui.textBox.setText(text.get(0));
        s.playSound(s.boss);
    }public void lookBoss(){
        s.gui.textBox.setText(text.get(1));
        s.playSound(s.boss);
    }public void fightBoss(){
        if(s.p.aqArmor && s.p.aqDevice && !bossIsSlain){
            s.gui.textBox.setText(text.get(2));
            s.sc1.mission++;
            bossIsSlain = true;
        }else if (!bossIsSlain){
            s.gui.textBox.setText(text.get(3));
            s.p.currHp = s.p.currHp -6;
            s.ss.gameOver(4);
        }else{
            s.gui.textBox.setText(text.get(4));
        }
        s.playSound(s.boss);
        s.p.checkPlayer();
    }public void exBoss(){
        s.gui.textBox.setText(text.get(5));
        s.p.aqMeme = true;
        s.playSound(s.boss);
        s.p.checkPlayer();
    }
}
