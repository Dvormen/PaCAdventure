public class sc2Actions {
    Start s;
    public sc2Actions(Start s){
        this.s = s;
    }
    public void bossTerminal(){
        s.gui.textBox.setText("The design for the boss was made by my sister.\n*She knows her stuff*");
    }
    public void generalTerminal(){
        s.gui.textBox.setText("The general was inspired by the roblox man face and my hardware teacher Kuchařík.\n*And a military man*");
    }
    public void houseTerminal(){
        s.gui.textBox.setText("The first screen was supposed to be the players house but it seemed funny if he would be living in a literal field of grass\n*...*");
    }
    public void jackpotTerminal(){
        if(s.sc0.jackpotWon){
            s.gui.textBox.setText("The song that plays when you hit the jackpot is called Pure love train or Admiring you, its exactly 4 minutes and 11 second\n*Its a Jujustu Kaisen reference*");
        }else{
            s.gui.textBox.setText("Redacted\n*Thats why you should go and roll!*");
        }
    }
}
