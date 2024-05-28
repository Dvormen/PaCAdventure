import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

/**
 * This class is for sound effects
 */
public class Sounds {
    Start s;
    Clip magazine;
    FloatControl volume;
    float volumeLevel = -15;

    /**
     * This method sets the sound effect
     * @param fileName name of the file
     */
    public void currFile(String fileName){
        try{
            File musicName = new File(fileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(musicName);
            magazine = AudioSystem.getClip();
            magazine.open(sound);
            volume = (FloatControl)magazine.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(volumeLevel);
        }catch(Exception e){
            System.out.println("Furube yurayura, yatsuka-no-ikaishinsho Makora");
        }
    }

    /**
     * This method plays the sound effect
     */
    public void setToPlay(){
        magazine.setFramePosition(0);
        magazine.start();
    }

}
