import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class sc2ActionsTest {

    private Start s = new Start();
    sc2Actions sc2 = new sc2Actions(s);

    sc2ActionsTest() throws IOException {
    }

    @Test
    void testBossTerminal() {
        sc2.bossTerminal();
        assertEquals("The design for the boss was made by my sister.\n" +
                "*She knows her stuff*",s.gui.textBox.getText());
    }

    @Test
    void testGeneralTerminal() {
        sc2.generalTerminal();
        assertEquals("The general was inspired by the roblox man face and my hardware teacher Kuchařík.\n" +
                "*And a military man*",s.gui.textBox.getText());
    }

    @Test
    void testHouseTerminal() {
        sc2.houseTerminal();
        assertEquals("The first screen was supposed to be the players house but it seemed funny if he would be living in a literal field of grass\n" +
                "*...*",s.gui.textBox.getText());
    }

    @Test
    void testJackpotTerminalRedacted() {
        sc2.jackpotTerminal();
        assertEquals("Redacted\n" +
                "*Thats why you should go and roll!*",s.gui.textBox.getText());
    }
    @Test
    void testJackpotTerminal() {
        s.sc0.jackpotWon = true;
        sc2.jackpotTerminal();
        assertEquals("The song that plays when you hit the jackpot is called Pure love train or Admiring you, its exactly 4 minutes and 11 second\n" +
                "*Its a Jujustu Kaisen reference*",s.gui.textBox.getText());
    }
}