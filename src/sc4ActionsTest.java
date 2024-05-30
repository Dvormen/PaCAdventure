import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class sc4ActionsTest {
    Start s = new Start();
    sc4ActionsTest() throws IOException {

    }

    @Test
    void testTalkBoss() {
        s.sc4.talkBoss();
        assertEquals("Nothing to talk about worm, prepare yourself for the battle!",s.gui.textBox.getText());
    }

    @Test
    void testLookBoss() {
        s.sc4.lookBoss();
        assertEquals("Huh, What is that number on her machine?",s.gui.textBox.getText());
    }

    @Test
    void testFightBossWin() {
        s.p.aqArmor = true;
        s.p.aqDevice = true;
        s.sc4.fightBoss();
        assertEquals("No this cannot beeeeeee....\n" +
                "*she didnt die shes just a drama queen*",s.gui.textBox.getText());
    }
    @Test
    void testFightBoss() {
        s.sc4.fightBoss();
        assertEquals("Weakling you could never defeat me!",s.gui.textBox.getText());
        assertEquals(-5,s.p.currHp);
    }
    @Test
    void testFightBossBeaten() {
        s.sc4.bossIsSlain = true;
        s.sc4.fightBoss();
        assertEquals("*Pst... shes sleeping*",s.gui.textBox.getText());
    }

    @Test
    void testExBoss() {
        s.sc4.exBoss();
        assertEquals("Are you the strongest, because you have all this equipment or you do you have all this equipment because you are the strongest?\n" +
                "*The player simply answered: Nah, Id win*",s.gui.textBox.getText());
    }
}