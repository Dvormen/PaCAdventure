import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ActionSolver implements ActionListener{

    Start s;
    int iCat = 0;
    int iCrate = 0;
    public ActionSolver (Start s){
    this.s = s;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pAction = ae.getActionCommand();

        if(pAction.equals("TalkBed")){
            s.gui.textBox.setText("You try talking to the bed, surprisingly the bed doesnt respond.\n*this is utterly pointless*");
        } else if (pAction.equals("LookBed")) {
            s.gui.textBox.setText("The bed seems really cosy, you now really want to lay in the bed.\n*this is utterly pointless*");
        } else if (pAction.equals("FightBed")) {
            s.gui.textBox.setText("You take you fighting stance and leap with great power to attack the bed, you immediately fall asleep after touching the bed.\n*you fell of the bed, it hurt*");
            //loss of health
        } else if (pAction.equals("ExBed")) {
            s.gui.textBox.setText("The bed opens up to you and lets you in gently, you eeped (sleeped) very well.\n*the bed used reversed cursed technique on you so you restored some heath*");
            //gain of life
        } else if (pAction.equals("TalkCat")) {
            s.gui.textBox.setText("You tried talking to the cat, it stared back with eternal malice.\n*this is utterly terrifying*");
        } else if (pAction.equals("LookCat")) {
            s.gui.textBox.setText("You look at the cat, the cat mew back at you so you didnt understand.\n*this is utterly cuteful*");
        }else if (pAction.equals("FightCat")) {
            if (iCat == 0){
                iCat++;
                s.gui.textBox.setText("Hey, dont do that, that´s not cool >:( !!!\n*the cat used domain amplification so she wasn´t hurt, BUT YOU GOT*");
                //loss of 4 health
            }else {
                //death of player
            }

        }else if (pAction.equals("ExCat")) {
            Random rCat = new Random();
            if(rCat.nextInt(3) ==2){
                s.gui.textBox.setText("The cat wasns´t fond of your pets, she bit you.\n*the more you F around, the more you find out*");
                //loss of health
            }else {
                s.gui.textBox.setText("The cat seems pleased as you hear her gentle purrs.\n*you are playing with danger*");
                //gain of 2 health
            }
        }else if (pAction.equals("TalkCrate")) {
            s.gui.textBox.setText("The crate is cheery, but it cant express itself, its just a crate.\n*this is utterly pointless*");
        }else if (pAction.equals("LookCrate")) {
            s.gui.textBox.setText("Looking at the crate it reminds you of a memory long forgotten.\n*this is utterly memoryless*");
        }else if (pAction.equals("FightCrate")) {
            s.gui.textBox.setText("You fought the crate, it didnt fight back, you now feel bad about yourself.\n*this is utterly pointless*");
        }else if (pAction.equals("ExCrate")) {
            if(iCrate == 0){
                s.gui.textBox.setText("You gently kicked the living hell out of the crate, and the crate thanked you, you obtained a blaster from the crate.\n*turns out i was a masochist crate*");
                iCrate++;
            }else {
                s.gui.textBox.setText("The kicked crate smile at you.\n*but you can see it, it doesnt have a mouth*");
            }
        }
    }
}
