import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    Clip magazine;
    FloatControl volume;
    float volumeLevel = -25;
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

    public void setToPlay(){
        magazine.setFramePosition(0);
        magazine.start();
    }
    public void notOver(){
        magazine.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopMusic(){
        magazine.stop();
    }
}
