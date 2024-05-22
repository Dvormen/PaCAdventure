import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ActionSolver implements ActionListener{

    Start s;
    Random rCat = new Random();
    Random rJackpot1 = new Random();
    Random rJackpot2 = new Random();
    Random rJackpot3 = new Random();
    int iCat = 0;
    int iCrate = 0;
    int iJackpot =0;
    public ActionSolver (Start s){
    this.s = s;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pAction = ae.getActionCommand();

        if(pAction.equals("TalkBed")){
            s.gui.textBox.setText("You try talking to the bed, surprisingly the bed doesnt respond.\n*this is utterly pointless*");
        } else if (pAction.equals("Screen0")) {
            s.ss.Screen0();
            if(iJackpot == 0){
                iJackpot++;
                s.gui.textBox.setText("You find yourself in a casino, good ol place familiar to you.\n*Uhhhh... nice, finally some real fun!*");
            }else {
                s.gui.textBox.setText("Seems like every road leads to the casino huh.\n*Did you know that 99.9% of gamblers quit before hitting big?*");
            }
        } else if (pAction.equals("ScreenM")) {
            s.gui.textBox.setText("Back to the boring stuff.\n*Theres an easter egg if you roll 3 same numbers ;)*");
            s.ss.ScreenM();
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
                //loss of 5 health
            }

        }else if (pAction.equals("ExCat")) {

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
                s.gui.textBox.setText("You gently kicked the living hell out of the crate, and the crate thanked you, you obtained a blaster from the crate.\n*turns out i was a masochist crate, it also kinda hurt*");
                iCrate++;
                //loss of health
            }else {
                s.gui.textBox.setText("The kicked crate smile at you.\n*but you can see it, it doesnt have a mouth*");
            }
        } else if (pAction.equals("TalkJackpot")) {
            s.gui.textBox.setText("Talk? What do you want to talk about, the chances of winning?\n*roll roll roll roll roll roll*");
        } else if (pAction.equals("LookJackpot")) {
            s.gui.textBox.setText("A huge machine is towering over you,to win a jackpot you need to hit 3 same numbers.\n*roll roll roll roll roll roll*");
        } else if (pAction.equals("FightJackpot")) {
            s.gui.textBox.setText("You cannot oppose the chances in a physical battle, you need to face the in a game of luck.\n*roll roll roll roll roll roll*");
        } else if (pAction.equals("ExJackpot")) {
            int a =rJackpot1.nextInt(9)+1;
            int b =rJackpot2.nextInt(9)+1;
            int c =rJackpot3.nextInt(9)+1;
            if( a == b && a == c){
                s.gui.textBox.setText("YOU WON, now enjoy 4 minutes and 11 seconds of being effectively immortal.\n*not really, but you got the easter egg also you rolled "+a+" "+b+" "+c+"*");
            }else {
                s.gui.textBox.setText("you rolled "+a+" "+b+" "+c+" better luck next time.\n*go on try again*");
            }
        } else if (pAction.equals("TalkKey")) {
            s.gui.textBox.setText("Not much to talk about with a key, huh?\n*yeah...*");
        } else if (pAction.equals("LookKey")) {
            s.gui.textBox.setText("Looks like a lost key, who does it belong to?\n*I wonder*");
        } else if (pAction.equals("FightKey")) {
            s.gui.textBox.setText("You lost.\n*shame (git gut)*");
        } else if (pAction.equals("ExKey")) {
            s.gui.textBox.setText("You pick up the key, it might come in handy.\n*You received key item key... item key... ke... YOU GET THE POINT!*");
        } else if (pAction.equals("TalkDevice")) {
            s.gui.textBox.setText("ℸ ̣ ⍑╎ᓭ ℸ ̣ ⍑╎リ⊣ ᓵᔑリリℸ ̣  ℸ ̣ ᔑꖎꖌ.\n*...*");
        } else if (pAction.equals("LookDevice")) {
            s.gui.textBox.setText("ᔑ ᓭℸ ̣ ∷ᔑリ⊣ᒷ device ∴╎ℸ ̣ ⍑ devastating effects.\n*...*");
        } else if (pAction.equals("FightDevice")) {
            s.gui.textBox.setText("リ.\n*...*");
        } else if (pAction.equals("ExDevice")) {
            s.gui.textBox.setText("You picked up the device and carefully put it into your inventory.\n*Be careful*");
        }
    }
}
