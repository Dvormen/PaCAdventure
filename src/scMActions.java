import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
    public void talkBed(){
        s.gui.textBox.setText(text.get(0));
    }
    public void lookBed(){
        s.gui.textBox.setText(text.get(1));
    }
    public void fightBed(){
        if (s.p.currHp ==1){
            s.gui.textBox.setText(text.get(2));
            s.ss.gameOver(0);
        }else {
            s.gui.textBox.setText(text.get(3));
        }
        s.p.currHp--;
        s.p.checkPlayer();
    }
    public void exBed(){
        if(s.p.maxHp > s.p.currHp){
            s.gui.textBox.setText(text.get(4));
            s.p.currHp = s.p.currHp +1;
        } else {
            s.gui.textBox.setText(text.get(5));
        }
        s.p.checkPlayer();
    }
    public void talkCat(){
        s.gui.textBox.setText(text.get(6));
    }
    public void lookCat(){
        s.playSound(s.cat);
        s.gui.textBox.setText(text.get(7));
    }
    public void fightCat(){
        if (iCat > 0){
            s.p.currHp = s.p.currHp -6;
            s.gui.textBox.setText(text.get(8));
            s.ss.gameOver(0);
        }
        if (iCat == 0 && s.p.currHp <= 4) {
            s.gui.textBox.setText(text.get(9));
            s.p.currHp = s.p.currHp -4;
            s.ss.gameOver(0);
        } else if (iCat ==0){
            s.gui.textBox.setText(text.get(9));
            s.p.currHp = s.p.currHp -4;
        }
        s.playSound(s.cat);
        iCat++;
        s.p.checkPlayer();
    }
    public void exCat(){
        int cat = rCat.nextInt(3);
        if ( cat== 2 && s.p.currHp ==1) {
            s.gui.textBox.setText(text.get(10));
            s.p.currHp--;
            s.ss.gameOver(0);
        } else if (cat == 2) {
            s.gui.textBox.setText(text.get(10));
            s.p.currHp--;
        } else if(s.p.currHp+2 <= s.p.maxHp){
            s.gui.textBox.setText(text.get(11));
            for (int i = 0;i !=2;i++){
                s.p.currHp++;
            }
        }else if(s.p.currHp < s.p.maxHp){
            s.p.currHp++;
        }
        s.playSound(s.cat);
        s.p.checkPlayer();
    }
    public void talkCrate(){
        s.gui.textBox.setText(text.get(12));
    }
    public void lookCrate(){
        s.gui.textBox.setText(text.get(13));
    }
    public void fightCrate(){
        s.gui.textBox.setText(text.get(14));
    }
    public void exCrate(){
        if (!s.p.aqGun && s.p.currHp ==1) {
            s.gui.textBox.setText(text.get(15));
            s.p.currHp--;
            s.p.aqGun = true;
            s.ss.gameOver(0);
        } else if(!s.p.aqGun){
            s.gui.textBox.setText(text.get(15));
            s.p.currHp--;
            s.p.aqGun = true;
        }else{
            s.gui.textBox.setText(text.get(16));
        }
        s.p.checkPlayer();
    }


}
