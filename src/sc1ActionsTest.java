import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class sc1ActionsTest {
    private Start s = new Start();
    private sc1Actions sc1 = new sc1Actions(s);


    sc1ActionsTest() throws IOException {
    }

    @Test
    void testTalkGeneral() {
        sc1.talkGeneral();
        assertEquals("Welcome, welcome I have been waiting for you.\n" +
                "*Interesting*",s.gui.textBox.getText());
    }

    @Test
    void testLookGeneral() {
        sc1.lookGeneral();
        assertEquals("Looks strong, probably could beat him with a gun or something.\n" +
                "*Whats that on his arm?*",s.gui.textBox.getText());
    }

    @Test
    void testFightGeneralGun() {
        s.p.aqGun = true;
        sc1.fightGeneral();
        assertEquals("Wow such immense strength! I hereby promote you to a soldier, you should go on an expedition to kill Le Evil Alien, but you can do that because i lost the keys to the space ship, you need to find them",s.gui.textBox.getText());
    }
    @Test
    void testFightGeneral() {
        sc1.fightGeneral();
        assertEquals("Pathetic, do you think someone this weak can join the army? Hahaha.",s.gui.textBox.getText());
        assertEquals(0,s.p.currHp);
    }
    @Test
    void testFightGeneralPlus() {
        sc1.f = 1;
        sc1.fightGeneral();
        assertEquals("You are too strong for the likes of me.\n" +
                "*Thats what I thought*",s.gui.textBox.getText());
    }

    @Test
    void testExGeneralNone() {
        sc1.exGeneral();
        assertEquals("You dont work for me so I dont have any missions for you.\n" +
                "*Makes sense*",s.gui.textBox.getText());
    }
    @Test
    void testExGeneralSecond() {
        sc1.mission = 1;
        s.p.aqKeys = true;
        sc1.exGeneral();
        assertEquals("Great you found them, now go into the spaceship and go kill some aliens!\n" +
                "*Too bad, we dont kill them, we spare them!*",s.gui.textBox.getText());
    }
    @Test
    void testExGeneralFirst() {
        sc1.mission = 1;
        sc1.exGeneral();
        assertEquals("Find my lost keys to the spaceship\n" +
                "*Where could they be?*",s.gui.textBox.getText());
    }
    @Test
    void testExGeneralThird() {
        sc1.mission = 2;
        s.sc4.bossIsSlain = true;
        sc1.exGeneral();
        assertEquals("Congratulations I knew you could do it, you should get your medal for heroism in four to five business days\n" +
                "*Great, you won the game YAY! you can still go around maybe you would wanna visit the terminal or maybe the casino.*",s.gui.textBox.getText());
        assertTrue(s.sc4.bossIsSlain);
    }
}