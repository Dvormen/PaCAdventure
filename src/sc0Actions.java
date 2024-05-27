import java.util.Date;
import java.util.Random;

public class sc0Actions {
    Start s;
    Random rJackpot1 = new Random();
    Random rJackpot2 = new Random();
    Random rJackpot3 = new Random();
    boolean jackpotWon = false;
    Date dateJ = new Date();
    public sc0Actions(Start s){
        this.s = s;
    }
    public void talkJackpot(){
        s.gui.textBox.setText("Talk? What do you want to talk about, the chances of winning?\n*roll roll roll roll roll roll*");
        s.playSound(s.machine);
    }
    public void lookJackpot(){
        s.gui.textBox.setText("A huge machine is towering over you, to win a jackpot you need to hit 3 same numbers.\n*roll roll roll roll roll roll*");
        s.playSound(s.machine);
    }
    public void fightJackpot(){
        s.gui.textBox.setText("You cannot oppose the chances in a physical battle, you need to face the in a game of luck.\n*roll roll roll roll roll roll*");
        s.playSound(s.machine);
    }
    public void exJackpot(){
        int a = rJackpot1.nextInt(9) + 1;
        int b = rJackpot2.nextInt(9) + 1;
        int c = rJackpot3.nextInt(9) + 1;
        if (a == b && a == c) {
            s.gui.textBox.setText("YOU WON, now enjoy 4 minutes and 11 seconds of being effectively immortal.\n*not really, but you got the easter egg also you rolled " + a + " " + b + " " + c + "*");
            jackpotWon = true;
            s.stopTheMusic();
            s.playMusic(s.jackpotMusic);
            dateJ = new Date();
        } else {
            s.gui.textBox.setText("you rolled " + a + " " + b + " " + c + " better luck next time.\n*go on try again*");
            jackpotWon = true;
            s.stopTheMusic();
            s.playMusic(s.jackpotMusic);
            dateJ = new Date();
        }
        s.playSound(s.machine);
    }
    public void talkKeys(){
        s.gui.textBox.setText("Not much to talk about with a key, huh?\n*yeah...*");
    }
    public void lookKeys(){
        s.gui.textBox.setText("Looks like a lost key, who does it belong to?\n*I wonder*");
    }
    public void fightKeys(){
        s.gui.textBox.setText("You lost.\n*shame (git gut)*");
    }
    public void exKeys(){
        if(!s.p.aqKeys){
            s.gui.textBox.setText("You pick up the key, it might come in handy.\n*You received key item key... item key... ke... YOU GET THE POINT!*");
            s.p.aqKeys=true;
        }else{
            s.gui.textBox.setText("Nothing but an empty spot remains");
        }
        s.p.checkPlayer();
    }
    public void talkDevice(){
        s.gui.textBox.setText("ℸ ̣ ⍑╎ᓭ ℸ ̣ ⍑╎リ⊣ ᓵᔑリリℸ ̣  ℸ ̣ ᔑꖎꖌ.\n*...*");
    }
    public void lookDevice(){
        s.gui.textBox.setText("ᔑ ᓭℸ ̣ ∷ᔑリ⊣ᒷ device ∴╎ℸ ̣ ⍑ devastating effects.\n*...*");
    }
    public void fightDevice(){
        s.gui.textBox.setText("リ.\n*...*");
    }
    public void exDevice(){
        if(!s.p.aqDevice){
            s.gui.textBox.setText("You picked up the device and carefully put it into your inventory.\n*Be careful*");
            s.p.aqDevice = true;
        }else{
            s.gui.textBox.setText("Nothing but an empty spot remains");
        }
        s.p.checkPlayer();
    }
}
