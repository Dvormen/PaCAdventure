import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


/**
 * This class takes care of what is on Screen0 - casino
 */
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

    /**
     * This method is used when player picks the option to talk to the jackpot machine
     */
    public void talkJackpot(){
            s.gui.textBox.setText(text.get(0)+"\n"+text.get(1));
        s.playSound(s.machine);
    }
    /**
     * This method is used when player picks the option to look at the jackpot machine
     */
    public void lookJackpot(){
        s.gui.textBox.setText(text.get(2)+"\n"+text.get(3));
        s.playSound(s.machine);
    }
    /**
     * This method is used when player picks the option to fight with the jackpot machine
     */
    public void fightJackpot(){
        s.gui.textBox.setText(text.get(4)+"\n"+text.get(5));
        s.playSound(s.machine);
    }
    /**
     * This method is used when player picks the option to play the jackpot machine and if the player hits a jackpot, it does and Easter egg
     */
    public void exJackpot(){
        int a = rJackpot1.nextInt(9) + 1;
        int b = rJackpot2.nextInt(9) + 1;
        int c = rJackpot3.nextInt(9) + 1;
        if (a == b && a == c) {
            s.gui.textBox.setText(text.get(6)+" you rolled "+a+" "+b+" "+c+"\n"+text.get(7));
            jackpotWon = true;
            s.stopTheMusic();
            s.playMusic(s.jackpotMusic);
            dateJ = new Date();
        } else {
            s.gui.textBox.setText(text.get(8)+" you rolled "+a+" "+b+" "+c+"\n"+text.get(9));
        }
        s.playSound(s.machine);
    }

    /**
     * This method is used when player picks the option to talk with the keys
     */
    public void talkKeys(){
        s.gui.textBox.setText(text.get(10)+"\n"+text.get(11));
    }
    /**
     * This method is used when player picks the option to look at the keys
     */
    public void lookKeys(){
        s.gui.textBox.setText(text.get(12)+"\n"+text.get(13));
    }
    /**
     * This method is used when player picks the option fight with the keys
     */
    public void fightKeys(){
        s.gui.textBox.setText(text.get(14)+"\n"+text.get(15));
    }
    /**
     * This method is used when player picks the option to pick up the keys and gives him an item
     */
    public void exKeys(){
        if(!s.p.aqKeys){
            s.gui.textBox.setText(text.get(16)+"\n"+text.get(17));
            s.p.aqKeys=true;
        }else{
            s.gui.textBox.setText(text.get(18));
        }
        s.p.checkPlayer();
    }
    /**
     * This method is used when player picks the option to talk with the device
     */
    public void talkDevice(){
        s.gui.textBox.setText(text.get(19)+"\n"+text.get(20));
    }
    /**
     * This method is used when player picks the option to look at the device
     */
    public void lookDevice(){
        s.gui.textBox.setText(text.get(21)+"\n"+text.get(22));
    }
    /**
     * This method is used when player picks the option to fight with the device
     */
    public void fightDevice(){
        s.gui.textBox.setText(text.get(23)+"\n"+text.get(24));
    }
    /**
     * This method is used when player picks the option to pick up the device and gives him an item
     */
    public void exDevice(){
        if(!s.p.aqDevice){
            s.gui.textBox.setText(text.get(25)+"\n"+text.get(26));
            s.p.aqDevice = true;
        }else{
            s.gui.textBox.setText(text.get(18));
        }
        s.p.checkPlayer();
    }
}
