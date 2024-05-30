import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class sc0ActionsTest {
    private Start s = new Start();
    private sc0Actions sc0 = new sc0Actions(s);

    sc0ActionsTest() throws IOException {
    }

    @Test
    public void testTalkJackpot() {
        sc0.talkJackpot();
        assertEquals("Talk? What do you want to talk about, the chances of winning? \n" +
                "*roll roll roll roll roll roll*", s.gui.textBox.getText());
    }

    @Test
    public void testLookJackpot() {
        sc0.lookJackpot();
        assertEquals("A huge machine is towering over you, to win a jackpot you need to hit 3 same numbers. \n" +
                "*roll roll roll roll roll roll*", s.gui.textBox.getText());
    }

    @Test
    public void testFightJackpot() {
        sc0.fightJackpot();
        assertEquals("You cannot oppose the chances in a physical battle, you need to face the in a game of luck. \n" +
                "*roll roll roll roll roll roll*", s.gui.textBox.getText());
    }
    @Test
    public void testTalkKeys() {
        sc0.talkKeys();
        assertEquals("Not much to talk about with a key, huh? \n" +
                "*yeah...*", s.gui.textBox.getText());
    }
    @Test
    public void testLookKeys() {
        sc0.lookKeys();
        assertEquals("Looks like a lost key, who does it belong to? \n" +
                "*I wonder*", s.gui.textBox.getText());
    }
    @Test
    public void testFightKeys() {
        sc0.fightKeys();
        assertEquals("You lost. \n" +
                "*shame (git gut)*", s.gui.textBox.getText());
    }
    @Test
    public void testExKeys() {
        sc0.exKeys();
        assertEquals("You pick up the key, it might come in handy. \n" +
                "*You received key item key... item key... ke... YOU GET THE POINT!*", s.gui.textBox.getText());
    }
    @Test
    public void testTalkDevice() {
        sc0.talkDevice();
        assertEquals("ℸ ̣ ⍑╎ᓭ ℸ ̣ ⍑╎リ⊣ ᓵᔑリリℸ ̣  ℸ ̣ ᔑꖎꖌ. \n" +
                "*...*", s.gui.textBox.getText());
    }
    @Test
    public void testLookDevice() {
        sc0.lookDevice();
        assertEquals("ᔑ ᓭℸ ̣ ∷ᔑリ⊣ᒷ device ∴╎ℸ ̣ ⍑ devastating effects. \n" +
                "*...*", s.gui.textBox.getText());
    }
    @Test
    public void testFightDevice() {
        sc0.fightDevice();
        assertEquals("リ. \n" +
                "*...*", s.gui.textBox.getText());
    }
    @Test
    public void testExDevice() {
        sc0.exDevice();
        assertEquals("You picked up the device and carefully put it into your inventory. \n" +
                "*Be careful*", s.gui.textBox.getText());
    }
}