import java.util.Random;

public class scMActions {
    Start s;
    int iCat = 0;
    Random rCat = new Random();
    public scMActions(Start s){
        this.s = s;
    }
    public void talkBed(){
        s.gui.textBox.setText("You try talking to the bed, surprisingly the bed doesnt respond.\n*this is utterly pointless*");
    }
    public void lookBed(){
        s.gui.textBox.setText("The bed seems really cosy, you now really want to lay in the bed.\n*this is utterly pointless*");
    }
    public void fightBed(){
        if (s.p.currHp ==1){
            s.gui.textBox.setText("You were crushed by the bed");
            s.ss.gameOver(0);
        }else {
            s.gui.textBox.setText("You take you fighting stance and leap with great power to attack the bed, you immediately after touching the bed fell asleep.\n*you fell of the bed, it hurt*");
        }
        s.p.currHp--;
        s.p.checkPlayer();
    }
    public void exBed(){
        if(s.p.maxHp > s.p.currHp){
            s.gui.textBox.setText("The bed opens up to you and lets you in gently, you eeped (sleeped) very well.\n*the bed used reversed cursed technique on you so you restored some heath*");
            s.p.currHp = s.p.currHp +1;
        } else {
            s.gui.textBox.setText("The bed isnt opening, you no longer need to rest.\n*your hp is full* ");
        }
        s.p.checkPlayer();
    }
    public void talkCat(){
        s.gui.textBox.setText("You tried talking to the cat, it stared back with eternal malice.\n*this is utterly terrifying*");
    }
    public void lookCat(){
        s.gui.textBox.setText("You look at the cat, the cat mew back at you so you didnt understand.\n*this is utterly cuteful*");
    }
    public void fightCat(){
        if (iCat == 0) {
            iCat++;
            s.gui.textBox.setText("Hey, dont do that, that´s not cool >:( !!!\n*the cat used domain amplification so she wasn´t hurt, BUT YOU GOT*");
            for (int i = 0;i !=4;i++){
                s.p.currHp--;
            }
        } else {
            for (int i = 0;i !=6;i++){
                s.p.currHp--;
            }
        }
        s.p.checkPlayer();
    }
    public void exCat(){
        if (rCat.nextInt(3) == 2) {
            s.gui.textBox.setText("The cat wasns´t fond of your pets, she bit you.\n*the more you F around, the more you find out*");
            s.p.currHp--;
        } else if(s.p.currHp+2 <= s.p.maxHp){
            s.gui.textBox.setText("The cat seems pleased as you hear her gentle purrs.\n*you are playing with danger*");
            for (int i = 0;i !=2;i++){
                s.p.currHp++;
            }
        }else if(s.p.currHp < s.p.maxHp){
            s.p.currHp++;
        }
        s.p.checkPlayer();
    }
    public void talkCrate(){
        s.gui.textBox.setText("The crate is cheery, but it cant express itself, its just a crate.\n*this is utterly pointless*");
    }
    public void lookCrate(){
        s.gui.textBox.setText("Looking at the crate it reminds you of a memory long forgotten.\n*this is utterly memoryless*");
    }
    public void fightCrate(){
        s.gui.textBox.setText("You fought the crate, it didnt fight back, you now feel bad about yourself.\n*this is utterly pointless*");
    }
    public void exCrate(){
        if (!s.p.aqGun) {
            s.gui.textBox.setText("You gently kicked the living hell out of the crate, and the crate thanked you, you obtained a blaster from the crate.\n*turns out i was a masochist crate, it also kinda hurt*");
            s.p.currHp--;
            s.p.aqGun = true;
        } else {
            s.gui.textBox.setText("The kicked crate smiles at you.\n*but you can see it, it doesnt have a mouth*");
        }
        s.p.checkPlayer();
    }


}
