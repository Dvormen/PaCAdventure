public class sc4Actions {
    Start s;
    boolean bossIsSlain = false;
    public sc4Actions(Start s){
        this.s = s;
    }
    public void talkBoss(){
        s.gui.textBox.setText("Notting to talk about worm, prepare yourself for the battle!");
    }public void lookBoss(){
        s.gui.textBox.setText("Huh, What is that number on her machine?");
    }public void fightBoss(){
        if(s.p.aqArmor && s.p.aqDevice && !bossIsSlain){
            s.gui.textBox.setText("No this cannot beeeeeee....\n*she didnt die shes just a drama queen*");
            s.sc1.mission++;
            bossIsSlain = true;
        }else if (!bossIsSlain){
            s.gui.textBox.setText("Weakling you could never defeat me!");
            for(int i = 0;i < 6;i++){
                s.p.currHp--;

            }
        }else{
            s.gui.textBox.setText("*Pst... shes sleeping*");
        }
        s.p.checkPlayer();
    }public void exBoss(){
        s.gui.textBox.setText("Are you the strongest, because you have all this equipment or you do you have all this equipment because you are the strongest?\n *The player simply answered: Nah, Id win*");
        s.p.aqMeme = true;
        s.p.checkPlayer();
    }
}
