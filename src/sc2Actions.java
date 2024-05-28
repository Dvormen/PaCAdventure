import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class takes care of what is on Screen2 - Spaceship of the humans
 */
public class sc2Actions {
    Start s;
    ArrayList<String> text = new ArrayList<>();
    BufferedReader br2;
    public sc2Actions(Start s) throws IOException {
        br2 = new BufferedReader(new FileReader("textfiles/text1.txt"));
        String temp;
        while((temp = br2.readLine())!=null){
            text.add(temp);
        }
        this.s = s;
    }

    /**
     * This method is used when players picks the option to talk about the boss
     */
    public void bossTerminal(){
        s.gui.textBox.setText(text.get(0));
        s.playSound(s.terminal);
    }
    /**
     * This method is used when players picks the option to talk about general
     */
    public void generalTerminal(){
        s.gui.textBox.setText(text.get(1));
        s.playSound(s.terminal);
    }
    /**
     * This method is used when players picks the option to talk about his house
     */
    public void houseTerminal(){
        s.gui.textBox.setText(text.get(2));
        s.playSound(s.terminal);
    }
    /**
     * This method is used when players picks the option to talk about the jackpot
     */
    public void jackpotTerminal(){
        if(s.sc0.jackpotWon){
            s.gui.textBox.setText(text.get(3));
        }else{
            s.gui.textBox.setText(text.get(4));
        }
        s.playSound(s.terminal);
    }
}
