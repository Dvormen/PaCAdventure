import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class sc0Actions {
    ArrayList<String> text = new ArrayList<>();
    BufferedReader br0;
    Start s;
    Random rJackpot1 = new Random();
    Random rJackpot2 = new Random();
    Random rJackpot3 = new Random();
    boolean jackpotWon = false;
    Date dateJ = new Date();
    public sc0Actions(Start s) throws IOException {
        br0 = new BufferedReader(new FileReader("textfiles/text0.txt"));
        String temp;
        while((temp = br0.readLine())!=null){
            text.add(temp);
    }
        this.s = s;
    }
    public void talkJackpot(){
            s.gui.textBox.setText(text.get(0));
        s.playSound(s.machine);
    }
    public void lookJackpot(){
        s.gui.textBox.setText(text.get(1));
        s.playSound(s.machine);
    }
    public void fightJackpot(){
        s.gui.textBox.setText(text.get(2));
        s.playSound(s.machine);
    }
    public void exJackpot(){
        int a = rJackpot1.nextInt(9) + 1;
        int b = rJackpot2.nextInt(9) + 1;
        int c = rJackpot3.nextInt(9) + 1;
        if (a == b && a == c) {
            s.gui.textBox.setText(text.get(3)+"\nyou rolled "+a+" "+b+" "+c);
            jackpotWon = true;
            s.stopTheMusic();
            s.playMusic(s.jackpotMusic);
            dateJ = new Date();
        } else {
            s.gui.textBox.setText(text.get(4)+"\nyou rolled "+a+" "+b+" "+c);
        }
        s.playSound(s.machine);
    }
    public void talkKeys(){
        s.gui.textBox.setText(text.get(5));
    }
    public void lookKeys(){
        s.gui.textBox.setText(text.get(6));
    }
    public void fightKeys(){
        s.gui.textBox.setText(text.get(7));
    }
    public void exKeys(){
        if(!s.p.aqKeys){
            s.gui.textBox.setText(text.get(8));
            s.p.aqKeys=true;
        }else{
            s.gui.textBox.setText(text.get(9));
        }
        s.p.checkPlayer();
    }
    public void talkDevice(){
        s.gui.textBox.setText(text.get(10));
    }
    public void lookDevice(){
        s.gui.textBox.setText(text.get(11));
    }
    public void fightDevice(){
        s.gui.textBox.setText(text.get(12));
    }
    public void exDevice(){
        if(!s.p.aqDevice){
            s.gui.textBox.setText(text.get(13));
            s.p.aqDevice = true;
        }else{
            s.gui.textBox.setText(text.get(14));
        }
        s.p.checkPlayer();
    }
}
