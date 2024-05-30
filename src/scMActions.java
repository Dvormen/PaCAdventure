import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class takes care of what is on ScreenM - House
 */
public class scMActions {
    ArrayList<String> text = new ArrayList<>();
    BufferedReader brM;
    Start s;
    int iCat = 0;
    Random rCat = new Random();
    public scMActions(Start s) throws IOException {
        brM = new BufferedReader(new FileReader("textfiles/textM.txt"));
        String temp;
        while((temp = brM.readLine())!=null){
            text.add(temp);
        }
        this.s = s;
    }

    /**
     * this method is used when player picks the option to talk with the bed
     */
    public void talkBed(){
        s.gui.textBox.setText(text.get(0)+"\n"+text.get(1));
    }
    /**
     * this method is used when player picks the option to look at the bed
     */
    public void lookBed(){
        s.gui.textBox.setText(text.get(2)+"\n"+text.get(3));
    }
    /**
     * this method is used when player picks the option to fight with the bed
     */
    public void fightBed(){
        if (s.p.currHp ==1){
            s.gui.textBox.setText(text.get(4));
            s.ss.gameOver(0);
        }else {
            s.gui.textBox.setText(text.get(5)+"\n"+text.get(6));
        }
        s.p.currHp--;
        s.p.checkPlayer();
    }
    /**
     * this method is used when player picks the option to sleep in the bed
     */
    public void exBed(){
        if(s.p.maxHp > s.p.currHp){
            s.gui.textBox.setText(text.get(7)+"\n"+text.get(8));
            s.p.currHp = s.p.currHp +1;
        } else {
            s.gui.textBox.setText(text.get(9)+"\n"+text.get(10));
        }
        s.p.checkPlayer();
    }
    /**
     * this method is used when player picks the option to talk with the cat
     */
    public void talkCat(){
        s.gui.textBox.setText(text.get(11)+"\n"+text.get(12));
    }
    /**
     * this method is used when player picks the option to look at the cat
     */
    public void lookCat(){
        s.playSound(s.cat);
        s.gui.textBox.setText(text.get(13)+"\n"+text.get(14));
    }
    /**
     * this method is used when player picks the option to fight with the cat
     */
    public void fightCat(){
        if (iCat > 0){
            s.p.currHp = s.p.currHp -6;
            s.gui.textBox.setText(text.get(15)+"\n"+text.get(16));
            s.ss.gameOver(0);
        }
        if (iCat == 0 && s.p.currHp <= 4) {
            s.gui.textBox.setText(text.get(17)+"\n"+text.get(18));
            s.p.currHp = s.p.currHp -4;
            s.ss.gameOver(0);
        } else if (iCat ==0){
            s.gui.textBox.setText(text.get(17)+"\n"+text.get(18));
            s.p.currHp = s.p.currHp -4;
        }
        s.playSound(s.cat);
        iCat++;
        s.p.checkPlayer();
    }
    /**
     * this method is used when player picks the option to pet the cat
     */
    public void exCat(){
        int cat = rCat.nextInt(3);
        if (cat== 2 && s.p.currHp ==1) {
            s.gui.textBox.setText(text.get(19)+"\n"+text.get(20));
            s.p.currHp--;
            s.ss.gameOver(0);
        } else if (cat == 2) {
            s.gui.textBox.setText(text.get(19)+"\n"+text.get(20));
            s.p.currHp--;
        } else if(s.p.currHp+2 <= s.p.maxHp){
            s.gui.textBox.setText(text.get(21)+"\n"+text.get(22));
            for (int i = 0;i !=2;i++){
                s.p.currHp++;
            }
        }else if(s.p.currHp < s.p.maxHp){
            s.p.currHp++;
        }
        s.playSound(s.cat);
        s.p.checkPlayer();
    }
    /**
     * this method is used when player picks the option to talk with the crate
     */
    public void talkCrate(){
        s.gui.textBox.setText(text.get(23)+"\n"+text.get(24));
    }
    /**
     * this method is used when player picks the option to look at the crate
     */
    public void lookCrate(){
        s.gui.textBox.setText(text.get(25)+"\n"+text.get(26));
    }
    /**
     * this method is used when player picks the option to fight with the bed
     */
    public void fightCrate(){
        s.gui.textBox.setText(text.get(27)+"\n"+text.get(28));
    }
    /**
     * this method is used when player picks the option to kick the crate
     */
    public void exCrate(){
        if (!s.p.aqGun && s.p.currHp ==1) {
            s.gui.textBox.setText(text.get(29)+"\n"+text.get(30));
            s.p.currHp--;
            s.p.aqGun = true;
            s.ss.gameOver(0);
        } else if(!s.p.aqGun){
            s.gui.textBox.setText(text.get(29)+"\n"+text.get(30));
            s.p.currHp--;
            s.p.aqGun = true;
        }else{
            s.gui.textBox.setText(text.get(31)+"\n"+text.get(32));
        }
        s.p.checkPlayer();
    }


}
