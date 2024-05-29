import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class takes care of what is on Screen3 - Enemy Spaceship
 */
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

    /**
     * This method is used when player picks the option to talk with the enemy
     */
    public void talkEnemy(){
        s.gui.textBox.setText(text.get(0)+"\n"+text.get(1));
        s.playSound(s.enemy);
    }
    /**
     * This method is used when player picks the option to look at the enemy
     */
    public void lookEnemy(){
        s.gui.textBox.setText(text.get(2)+"\n"+text.get(3));
        s.playSound(s.enemy);
    }
    /**
     * This method is used when player picks the option to fight with the enemy
     */
    public void fightEnemy(){
        if(s.p.aqGun){
            s.gui.textBox.setText(text.get(4)+"\n"+text.get(5));
            s.p.aqArmor = true;
        }else{
            s.gui.textBox.setText(text.get(6));
        }
        s.playSound(s.enemy);
        s.p.checkPlayer();
    }
    /**
     * This method is used when player picks the option to pet the enemy
     */
    public void exEnemy(){
        if(s.p.currHp ==1){
            s.gui.textBox.setText(text.get(7));
            s.p.currHp--;
            s.ss.gameOver(3);
        }else {
            s.gui.textBox.setText(text.get(7));
            s.p.currHp--;
        }
        s.playSound(s.enemy);
        s.p.checkPlayer();
    }
}
