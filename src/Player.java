public class Player {
    Start s;
    public int currHp;
    public int maxHp;
    public int aqGun;
    public int aqKeys;
    public int aqArmor;
    public int aqDevice;
    public int aqMedal;
    public Player(Start s){
        this.s = s;

    }

    public void setBasePlayer(){
        currHp = 5;
        maxHp = 6;
        aqGun = 0;
        aqKeys = 0;
        aqArmor = 0;
        aqDevice = 0;
        aqMedal = 0;
        checkPlayer();
    }

    public void checkPlayer(){
        if(aqGun == 0){
            s.gui.gun.setVisible(false);
        }
        if(aqGun == 1){
            s.gui.gun.setVisible(true);
        }
        if(aqKeys == 0){
            s.gui.keys.setVisible(false);
        }
        if(aqKeys == 1){
            s.gui.keys.setVisible(true);
        }
        if(aqArmor == 0){
            s.gui.armor.setVisible(false);
        }
        if(aqArmor == 1){
            s.gui.armor.setVisible(true);
        }
        if(aqDevice == 0){
            s.gui.device.setVisible(false);
        }
        if(aqDevice == 1){
            s.gui.device.setVisible(true);
        }
        if(aqMedal == 0){
            s.gui.medal.setVisible(false);
        }
        if(aqMedal == 1){
            s.gui.medal.setVisible(true);
        }
        for(int i = 0;i < 6;i++){
            s.gui.hearts[i].setVisible(false);
        }
        for (int l = currHp; l > 0; l--){
            s.gui.hearts[l].setVisible(true);

        }

    }


}
