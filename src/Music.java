import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class takes care of music
 */
public class Music {
    Clip magazine;
    FloatControl volume;
    float volumeLevel = -25;

    /**
     * This method sets the music and formats it
     * @param fileName name of the file
     */
    public void currFile(String fileName) {
        try {
            File musicName = new File(fileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(musicName);
            magazine = AudioSystem.getClip();
            magazine.open(sound);
            volume = (FloatControl)magazine.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(volumeLevel);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("unsuported");
        } catch (LineUnavailableException e) {
            System.out.println("unavailable");
        } catch (IOException e) {
            System.out.println("else");
        }
    }

    /**
     * This method starts the music
     */
    public void setToPlay(){
        magazine.setFramePosition(0);
        magazine.start();
    }

    /**
     * This method loops the music
     */
    public void notOver(){
        magazine.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * This method stops the music
     */
    public void stopMusic(){
        magazine.stop();
    }
}
