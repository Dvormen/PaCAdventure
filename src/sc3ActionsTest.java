import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class sc3ActionsTest {
    Start s = new Start();

    sc3ActionsTest() throws IOException {
    }

    @Test
    void testTalkEnemy() {
        s.sc3.talkEnemy();
        assertEquals("He says that you need a special device to protect yourself\n" +
                "*You dont understand him but you feel thankful towards him, no need for violence right?*",s.gui.textBox.getText());
    }

    @Test
    void testLookEnemy() {
        s.sc3.lookEnemy();
        assertEquals("He looks like a jello on an iron walking machine\n" +
                "*Looks appetizing*",s.gui.textBox.getText());
    }

    @Test
    void testFightEnemy() {
        s.p.aqGun = true;
        s.sc3.fightEnemy();
        assertEquals("Ouch you got me, before you fight the queen you should check her out, you need a special device to beat her.\n" +
                "*You dont understand a word he just said, but you understood the meaning*",s.gui.textBox.getText());
    }
    @Test
    void testFightEnemyEE() {
        s.sc3.fightEnemy();
        assertEquals("You dirty cheater! You didnt even take the mission from the general!, Thb congrats this is the true secret :) cant even damage you",s.gui.textBox.getText());
    }

    @Test
    void testExEnemy() {
        s.sc3.exEnemy();
        assertEquals("No petting!",s.gui.textBox.getText());
    }
}