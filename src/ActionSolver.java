import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ActionSolver implements ActionListener{

    Start s;
    Random rCat = new Random();
    Random rJackpot1 = new Random();
    Random rJackpot2 = new Random();
    Random rJackpot3 = new Random();
    int mission=0;
    int f =0;
    int iCat = 0;
    int iCrate = 0;
    int iJackpot =0;
    boolean jackpotWon = false;
    boolean bossIsSlain = false;
    public ActionSolver (Start s){
    this.s = s;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pAction = ae.getActionCommand();

        switch (pAction) {

            case "Screen0":
                s.ss.Screen0();
                if (iJackpot == 0) {
                    iJackpot++;
                    s.gui.textBox.setText("You find yourself in a casino, good ol place familiar to you.\n*Uhhhh... nice, finally some real fun!*");
                } else {
                    s.gui.textBox.setText("Seems like every road leads to the casino huh.\n*Did you know that 99.9% of gamblers quit before hitting big?*");
                }
                break;
            case "ScreenM":
                s.gui.textBox.setText("Back to the your place.\n*Somewhat calming*");
                s.ss.ScreenM();
                break;
            case "Screen1":
                s.gui.textBox.setText("Military base of humans.\n*More of an airport honestly...*");
                s.ss.Screen1();
                break;
            case "TalkBed":
                s.gui.textBox.setText("You try talking to the bed, surprisingly the bed doesnt respond.\n*this is utterly pointless*");
                break;
            case "LookBed":
                s.gui.textBox.setText("The bed seems really cosy, you now really want to lay in the bed.\n*this is utterly pointless*");
                break;
            case "FightBed":
                s.gui.textBox.setText("You take you fighting stance and leap with great power to attack the bed, you immediately fall asleep after touching the bed.\n*you fell of the bed, it hurt*");
                //loss of 1 hp
                break;
            case "ExBed":
                s.gui.textBox.setText("The bed opens up to you and lets you in gently, you eeped (sleeped) very well.\n*the bed used reversed cursed technique on you so you restored some heath*");
                //gain of 1 hp
                break;
            case "TalkCat":
                s.gui.textBox.setText("You tried talking to the cat, it stared back with eternal malice.\n*this is utterly terrifying*");
                break;
            case "LookCat":
                s.gui.textBox.setText("You look at the cat, the cat mew back at you so you didnt understand.\n*this is utterly cuteful*");
                break;
            case "FightCat":
                if (iCat == 0) {
                    iCat++;
                    s.gui.textBox.setText("Hey, dont do that, that´s not cool >:( !!!\n*the cat used domain amplification so she wasn´t hurt, BUT YOU GOT*");
                    //loss of 4 hp
                } else {
                    //loss of all hp
                }

                break;
            case "ExCat":
                if (rCat.nextInt(3) == 2) {
                    s.gui.textBox.setText("The cat wasns´t fond of your pets, she bit you.\n*the more you F around, the more you find out*");
                    //loss of 1 hp
                } else {
                    s.gui.textBox.setText("The cat seems pleased as you hear her gentle purrs.\n*you are playing with danger*");
                    //gain of 2 hp
                }
                break;
            case "TalkCrate":
                s.gui.textBox.setText("The crate is cheery, but it cant express itself, its just a crate.\n*this is utterly pointless*");
                break;
            case "LookCrate":
                s.gui.textBox.setText("Looking at the crate it reminds you of a memory long forgotten.\n*this is utterly memoryless*");
                break;
            case "FightCrate":
                s.gui.textBox.setText("You fought the crate, it didnt fight back, you now feel bad about yourself.\n*this is utterly pointless*");
                break;
            case "ExCrate":
                if (iCrate == 0) {
                    s.gui.textBox.setText("You gently kicked the living hell out of the crate, and the crate thanked you, you obtained a blaster from the crate.\n*turns out i was a masochist crate, it also kinda hurt*");
                    iCrate++;
                    //get gun
                    //loss of 1 hp
                } else {
                    s.gui.textBox.setText("The kicked crate smile at you.\n*but you can see it, it doesnt have a mouth*");
                }
                break;
            case "TalkJackpot":
                s.gui.textBox.setText("Talk? What do you want to talk about, the chances of winning?\n*roll roll roll roll roll roll*");
                break;
            case "LookJackpot":
                s.gui.textBox.setText("A huge machine is towering over you,to win a jackpot you need to hit 3 same numbers.\n*roll roll roll roll roll roll*");
                break;
            case "FightJackpot":
                s.gui.textBox.setText("You cannot oppose the chances in a physical battle, you need to face the in a game of luck.\n*roll roll roll roll roll roll*");
                break;
            case "ExJackpot":
                int a = rJackpot1.nextInt(9) + 1;
                int b = rJackpot2.nextInt(9) + 1;
                int c = rJackpot3.nextInt(9) + 1;
                if (a == b && a == c) {
                    s.gui.textBox.setText("YOU WON, now enjoy 4 minutes and 11 seconds of being effectively immortal.\n*not really, but you got the easter egg also you rolled " + a + " " + b + " " + c + "*");
                    jackpotWon = true;
                } else {
                    s.gui.textBox.setText("you rolled " + a + " " + b + " " + c + " better luck next time.\n*go on try again*");
                }
                break;
            case "TalkKey":
                s.gui.textBox.setText("Not much to talk about with a key, huh?\n*yeah...*");
                break;
            case "LookKey":
                s.gui.textBox.setText("Looks like a lost key, who does it belong to?\n*I wonder*");
                break;
            case "FightKey":
                s.gui.textBox.setText("You lost.\n*shame (git gut)*");
                break;
            case "ExKey":
                s.gui.textBox.setText("You pick up the key, it might come in handy.\n*You received key item key... item key... ke... YOU GET THE POINT!*");
                break;
            case "TalkDevice":
                s.gui.textBox.setText("ℸ ̣ ⍑╎ᓭ ℸ ̣ ⍑╎リ⊣ ᓵᔑリリℸ ̣  ℸ ̣ ᔑꖎꖌ.\n*...*");
                break;
            case "LookDevice":
                s.gui.textBox.setText("ᔑ ᓭℸ ̣ ∷ᔑリ⊣ᒷ device ∴╎ℸ ̣ ⍑ devastating effects.\n*...*");
                break;
            case "FightDevice":
                s.gui.textBox.setText("リ.\n*...*");
                break;
            case "ExDevice":
                s.gui.textBox.setText("You picked up the device and carefully put it into your inventory.\n*Be careful*");
                //get device
                break;
            case "TalkGeneral":
                s.gui.textBox.setText("Welcome, welcome I have been waiting for you.\n*Interesting*");
                break;
            case "LookGeneral":
                s.gui.textBox.setText("Looks strong, probably could beat him with a gun or something.\n*Whats that on his arm?*");
                break;
            case "FightGeneral":
                if(f == 0){
                    if(s.p.aqGun == 1){
                        s.gui.textBox.setText("Wow such immense strenght! I hereby promote you to a soldier, you should go on an expedition to kill Le Evil Alien, but you can do that because i lost the keys to the space ship, you need to find them");
                        mission++;
                        f++;
                    }else{
                        s.gui.textBox.setText("Pathetic, do you think someone this weak can join the army? Hahaha.\n*What a douche*");
                        //loss of 1 hp
                    }
                }else{
                    s.gui.textBox.setText("You are too strong for the likes of me.\n*Thats what I thought*");
                }

                break;
            case "ExGeneral":
                if (mission == 0){
                    s.gui.textBox.setText("You dont work for me so I dont have any missions for you.\n*Makes sence*");
                }else if (mission == 1 && s.p.aqKeys ==1 )  {
                   s.gui.textBox.setText("Great you found them, now go into the spaceship and go kill some aliens!\n*Too bad, we dont kill them, we spare them!*");
                }else if (mission == 1) {
                    s.gui.textBox.setText("Find my lost keys to the spaceship\n*Where could they be?*");
                } else if (bossIsSlain) {
                    s.gui.textBox.setText("Congratulations I knew you could do it, you should get your medal for heroism in four to five business days\n*Great, you won the game YAY! you can still go around maybe you would wanna visit the terminal or maybe the casino.*");
                    //get medal
                }
                break;
            case "BossTerminal":
                s.gui.textBox.setText("The design for the boss was made by my sister.\n*She knows her stuff*");
                break;
            case "GeneralTerminal":
                s.gui.textBox.setText("The general was inspired by the roblox man face and my hardware teacher Kuchařík.\n*And a military man*");
                break;
            case "HouseTerminal":
                s.gui.textBox.setText("The first screen was supposed to be the players house but it seemed funny if he would be living in a literal field of grass\n*...*");
                break;
            case "JackpotTerminal":
                if(jackpotWon){
                    s.gui.textBox.setText("The song that plays when you hit the jackpot is called Pure love train or Admiring you, its exactly 4 minutes and 11 second\n*Its a Jujustu Kaisen reference*");
                }else{
                    s.gui.textBox.setText("Redacted\n*Thats why you should go and roll!*");
                }
                break;
            case "TalkEnemy":
                s.gui.textBox.setText("He speak in a language unknown to you, but he seems cool\n*Actually quite nice fella, no need for violence right?*");
                break;
            case "LookEnemy":
                s.gui.textBox.setText("He looks like a jello on an iron walking machine\n*Looks appetizing*");
                break;
            case "FightEnemy":
                s.gui.textBox.setText("Ouch you got me, before you fight the queen you should check her out, you need a special device to beat her.\n*You dont understand a word he just said, but you understood the meaning*");
                //get armor
                break;
            case "ExEnemy":
                s.gui.textBox.setText("No petting!");
                break;
            case "TalkBoss":
                s.gui.textBox.setText("Notting to talk about worm, prepare yourself for the battle!");
                break;
            case "LookBoss":
                s.gui.textBox.setText("Huh, What is that number on her machine?");
                break;
            case "FightBoss":
                s.gui.textBox.setText("No this cannot beeeeeee....");
                break;
            case "ExBoss":
                s.gui.textBox.setText("huh?");
                break;
        }
    }
}
