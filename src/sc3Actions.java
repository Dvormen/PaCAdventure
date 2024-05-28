import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class sc3Actions {
    Start s;
    ArrayList<String> text = new ArrayList<>();
    BufferedReader br3;
    public sc3Actions(Start s) throws IOException {
        br3 = new BufferedReader(new FileReader("textfiles/text3.txt"));
        String temp;
        while((temp = br3.readLine())!=null){
            text.add(temp);
        }
        this.s = s;
    }
    public void talkEnemy(){
        s.gui.textBox.setText(text.get(0));
        s.playSound(s.enemy);
    }public void lookEnemy(){
        s.gui.textBox.setText(text.get(1));
        s.playSound(s.enemy);
    }public void fightEnemy(){
        if(s.p.aqGun){
            s.gui.textBox.setText(text.get(2));
            s.p.aqArmor = true;
        }else{
            s.gui.textBox.setText(text.get(3));
        }
        s.playSound(s.enemy);
        s.p.checkPlayer();
    }public void exEnemy(){
        if(s.p.currHp ==1){
            s.gui.textBox.setText(text.get(4));
            s.p.currHp--;
            s.ss.gameOver(3);
        }else {
            s.gui.textBox.setText(text.get(4));
            s.p.currHp--;
        }
        s.playSound(s.enemy);
        s.p.checkPlayer();
    }
}
