import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class takes care of what is on Screen4 - Enemy base
 */
public class sc4Actions {
    Start s;
    boolean bossIsSlain = false;
    ArrayList<String> text = new ArrayList<>();
    BufferedReader br4;
    public sc4Actions(Start s) throws IOException {
        br4 = new BufferedReader(new FileReader("textfiles/text4.txt"));
        String temp;
        while((temp = br4.readLine())!=null){
            text.add(temp);
        }
        this.s = s;
    }
    /**
     * This method is used when player picks the option to talk with the boss
     */
    public void talkBoss(){
        s.gui.textBox.setText(text.get(0));
        s.playSound(s.boss);
    }
    /**
     * This method is used when player picks the option to look at the boss
     */
    public void lookBoss(){
        s.gui.textBox.setText(text.get(1));
        s.playSound(s.boss);
    }

    /**
     * This method is used when player picks the option to fight with the boss
     */
    public void fightBoss(){
        if(s.p.aqArmor && s.p.aqDevice && !bossIsSlain){
            s.gui.textBox.setText(text.get(2)+"\n"+text.get(3));
            s.sc1.mission++;
            bossIsSlain = true;
        }else if (!bossIsSlain){
            s.gui.textBox.setText(text.get(4));
            s.p.currHp = s.p.currHp -6;
            s.ss.gameOver(4);
        }else{
            s.gui.textBox.setText(text.get(5));
        }
        s.playSound(s.boss);
        s.p.checkPlayer();
    }
    /**
     * This method is used when player picks the option to ask the boss an important question
     */
    public void exBoss(){
        s.gui.textBox.setText(text.get(6)+"\n"+text.get(7));
        s.p.aqMeme = true;
        s.playSound(s.boss);
        s.p.checkPlayer();
    }
}
