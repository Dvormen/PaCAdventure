import java.io.IOException;
import java.util.Date;

/**
 * This class starts the game and does other useful stuff for example: has the file names of all the sounds
 */
public class Start {
    ActionSolver as = new ActionSolver(this);
    public ScreenSwaper ss = new ScreenSwaper(this);
    public Player p = new Player(this);
    Gui gui = new Gui(this);
    Music msc = new Music();
    Sounds snd = new Sounds();
    public scMActions scm = new scMActions(this);
    public sc0Actions sc0= new sc0Actions(this);
    public sc1Actions sc1 = new sc1Actions(this);
    public sc2Actions sc2 = new sc2Actions(this);
    public sc3Actions sc3 = new sc3Actions(this);
    public sc4Actions sc4 = new sc4Actions(this);
    public String houseMusic = "audio\\sans.wav";
    public String airportMusic = "audio\\Sea Soldier Fanfare.wav";
    public String jackpotMusic = "audio\\Hakari Dance ThemeAdmiring YouPrivate Pure Love Train (Idle Death Gamble) Jujutsu Kaisen Fan OST.wav";
    public String spaceship1Music = "audio\\Color Your Night  -Full-.wav";
    public String spaceship2Music = "audio\\funky town low quality.wav";
    public String bossMusic = "audio\\Dark Souls 3 OST Vordt of the Boreal Valley.wav";
    public String terminal = "audio\\Beeping - Sound Effect.wav";
    public String cat = "audio\\Meow Sound Effect.wav";
    public String machine = "audio\\Coins falling sound effect.wav";
    public String enemy ="audio\\Brute Grunt Sound Effect.wav";
    public String boss = "audio\\I Stole @poopergirl2019's Woman Grunting Sound!!!.wav";
    public String generalHem = "audio\\Recording_7.wav";
    public String generalGrr = "audio\\Recording_8.wav";
    public String generalOoh = "audio\\Recording_9.wav";
    public String casinoMusic = "audio\\Crowd Talking [Free Sound Effects].wav";
    public String musicPlaying;
    public Start() throws IOException {
        musicPlaying = houseMusic;
        playMusic(musicPlaying);
        ss.ScreenM();
        p.setBasePlayer();
    }

    /**
     * This method starts the game
     * @throws IOException when things go bad
     */
    public static void startGame() throws IOException {
        new Start();
    }

    /**
     * This method plays the sound effect
     * @param sound name of the file
     */
    public void playSound(String sound){
        snd.currFile(sound);
        snd.setToPlay();
    }

    /**
     * This method plays and loops the current music, unless a jackpot is won
     * @param music music file name
     */
    public void playMusic(String music){
        Date currDate = new Date();
        if(sc0.jackpotWon && currDate.getTime() - sc0.dateJ.getTime() < 251000){
            msc.currFile(music);
            msc.setToPlay();
        }else{
            msc.currFile(music);
            msc.setToPlay();
            msc.notOver();
            sc0.jackpotWon = false;
        }
    }

    /**
     * This method stops the music
     */
    public void stopTheMusic(){
        msc.stopMusic();
    }

}