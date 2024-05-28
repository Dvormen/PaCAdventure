import java.util.Date;

/**
 * This class swaps the screens
 */
public class ScreenSwaper {

    Start s;
    public ScreenSwaper(Start s){
        this.s = s;
    }

    /**
     * This method hides the current background and displays the game over screen
     * @param currBg the number of the current background
     */
    public void gameOver(int currBg){
        s.gui.bg[currBg].setVisible(false);
        s.gui.gOScreen.setVisible(true);
        s.gui.reset.setVisible(true);
        s.gui.gOScreen.setText("You failed your journey as a hero");
        s.gui.reset.setText("Click here to play again");

    }

    /**
     * This method resets the players health and items
     */
    public void backToTheLobby (){
        s.gui.gOScreen.setVisible(false);
        s.gui.reset.setVisible(false);
        s.p.setBasePlayer();
    }

    /**
     * This method swaps the visible screen to house screen
     */
    public void ScreenM(){
        s.gui.bg[0].setVisible(true);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
        musicSwapper(s.houseMusic);
    }
    /**
     * This method swaps the visible screen to screen0
     */
    public void Screen0(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(true);

        musicSwapper(s.casinoMusic);
    }
    /**
     * This method swaps the visible screen to screen1
     */
    public void Screen1(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(true);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
        musicSwapper(s.airportMusic);
    }
    /**
     * This method swaps the visible screen to screen2
     */
    public void Screen2(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(true);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
        musicSwapper(s.spaceship1Music);
    }
    /**
     * This method swaps the visible screen to screen3
     */
    public void Screen3(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(true);
        s.gui.bg[4].setVisible(false);
        s.gui.bg[5].setVisible(false);
        musicSwapper(s.spaceship2Music);
    }
    /**
     * This method swaps the visible screen to screen4
     */
    public void Screen4(){
        s.gui.bg[0].setVisible(false);
        s.gui.bg[1].setVisible(false);
        s.gui.bg[2].setVisible(false);
        s.gui.bg[3].setVisible(false);
        s.gui.bg[4].setVisible(true);
        s.gui.bg[5].setVisible(false);
        musicSwapper(s.bossMusic);
    }
    /**
     * This method stops the current music and starts new screen music unless the jackpot is won
     */
    public void musicSwapper(String music) {
        Date currDate = new Date();
            if(s.sc0.jackpotWon && currDate.getTime() - s.sc0.dateJ.getTime() > 251000){
                s.sc0.jackpotWon = false;
                s.stopTheMusic();
                s.musicPlaying = music;
                s.playMusic(s.musicPlaying);
            } else if (!s.sc0.jackpotWon) {
                s.stopTheMusic();
                s.musicPlaying = music;
                s.playMusic(s.musicPlaying);
            }
    }
}