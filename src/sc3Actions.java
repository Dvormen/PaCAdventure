public class sc3Actions {
    Start s;
    public sc3Actions(Start s){
        this.s = s;
    }
    public void talkEnemy(){
        s.gui.textBox.setText("He says that you need a special device to protect yourself\n*You dont understand him but you feel thankful towards him, no need for violence right?*");
        s.playSound(s.enemy);
    }public void lookEnemy(){
        s.gui.textBox.setText("He looks like a jello on an iron walking machine\n*Looks appetizing*");
        s.playSound(s.enemy);
    }public void fightEnemy(){
        if(s.p.aqGun){
            s.gui.textBox.setText("Ouch you got me, before you fight the queen you should check her out, you need a special device to beat her.\n*You dont understand a word he just said, but you understood the meaning*");
            s.p.aqArmor = true;
        }else{
            s.gui.textBox.setText("You dirty cheater! You didnt even take the mission from the general!, Thb congrats this is the true secret :) cant even damage you");
        }
        s.playSound(s.enemy);
        s.p.checkPlayer();
    }public void exEnemy(){
        if(s.p.currHp ==1){
            s.gui.textBox.setText("No petting!");
            s.p.currHp--;
            s.ss.gameOver(3);
        }else {
            s.gui.textBox.setText("No petting!");
            s.p.currHp--;
        }
        s.playSound(s.enemy);
        s.p.checkPlayer();
    }
}
