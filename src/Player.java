public class Player {
    Start s;
    public int currHp;
    public int maxHp;
    public boolean aqGun;
    public boolean aqKeys;
    public boolean aqArmor;
    public boolean aqDevice;
    public boolean aqMedal;
    public boolean aqMeme;
    public Player(Start s){
        this.s = s;

    }

    public void setBasePlayer(){
        currHp = 1;
        maxHp = 6;
        aqGun = false;
        aqKeys = false;
        aqArmor = false;
        aqDevice = false;
        aqMedal = false;
        aqMeme = false;
        checkPlayer();
    }

    public void checkPlayer(){
        if(!aqGun){
            s.gui.gun.setVisible(false);
        }
        if(aqGun){
            s.gui.gun.setVisible(true);
        }
        if(!aqKeys){
            s.gui.keys.setVisible(false);
        }
        if(aqKeys){
            s.gui.keys.setVisible(true);
        }
        if(!aqArmor){
            s.gui.armor.setVisible(false);
        }
        if(aqArmor){
            s.gui.armor.setVisible(true);
        }
        if(!aqDevice){
            s.gui.device.setVisible(false);
        }
        if(aqDevice){
            s.gui.device.setVisible(true);
        }
        if(!aqMedal){
            s.gui.medal.setVisible(false);
        }
        if(aqMedal){
            s.gui.medal.setVisible(true);
        }

        for(int i = 0;i < 7;i++){
            s.gui.hearts[i].setVisible(false);
        }
        for (int l = currHp; l > 0; l--){
            s.gui.hearts[l].setVisible(true);

        }
        if(!aqMeme){
            s.gui.nah.setVisible(false);
        }
        if(aqMeme){
            s.gui.nah.setVisible(true);
        }
    }


}
