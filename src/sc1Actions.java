public class sc1Actions {
    Start s;
    int f =0;
    int mission=0;
    public sc1Actions(Start s){
        this.s = s;
    }
    public void talkGeneral(){
        s.gui.textBox.setText("Welcome, welcome I have been waiting for you.\n*Interesting*");
        s.playSound(s.generalHem);
    }
    public void lookGeneral(){
        s.gui.textBox.setText("Looks strong, probably could beat him with a gun or something.\n*Whats that on his arm?*");
        s.playSound(s.generalGrr);
    }
    public void fightGeneral(){
        if(f == 0){
            if(s.p.aqGun){
                s.gui.textBox.setText("Wow such immense strenght! I hereby promote you to a soldier, you should go on an expedition to kill Le Evil Alien, but you can do that because i lost the keys to the space ship, you need to find them");
                mission++;
                f++;
                s.playSound(s.generalHem);
            }else if (s.p.currHp ==1){
                s.gui.textBox.setText("Pathetic, do you think someone this weak can join the army? Hahaha.");
                s.p.currHp--;
                s.ss.gameOver(1);
                s.playSound(s.generalOoh);
            } else {
                s.gui.textBox.setText("Pathetic, do you think someone this weak can join the army? Hahaha.");
                s.p.currHp--;
                s.playSound(s.generalOoh);
            }
        }else{
            s.gui.textBox.setText("You are too strong for the likes of me.\n*Thats what I thought*");
            s.playSound(s.generalGrr);
        }
        s.p.checkPlayer();
    }
    public void exGeneral(){
        if (mission == 0){
            s.gui.textBox.setText("You dont work for me so I dont have any missions for you.\n*Makes sence*");
        }else if (mission == 1 && s.p.aqKeys)  {
            s.gui.textBox.setText("Great you found them, now go into the spaceship and go kill some aliens!\n*Too bad, we dont kill them, we spare them!*");
        }else if (mission == 1) {
            s.gui.textBox.setText("Find my lost keys to the spaceship\n*Where could they be?*");
        } else if (s.sc4.bossIsSlain) {
            s.gui.textBox.setText("Congratulations I knew you could do it, you should get your medal for heroism in four to five business days\n*Great, you won the game YAY! you can still go around maybe you would wanna visit the terminal or maybe the casino.*");
            s.p.aqMedal = true;
        }
        s.playSound(s.generalHem);
        s.p.checkPlayer();
    }
}
