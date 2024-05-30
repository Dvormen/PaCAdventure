import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class scMActionsTest {
    Start s = new Start();

    scMActionsTest() throws IOException {
    }

    @Test
    void testTalkBed() {
        s.scm.talkBed();
        assertEquals("You try talking to the bed, surprisingly the bed doesnt respond.\n" +
                "*this is utterly pointless*",s.gui.textBox.getText());
    }

    @Test
    void testLookBed() {
        s.scm.lookBed();
        assertEquals("The bed seems really cosy, you now really want to lay in the bed.\n" +
                "*this is utterly pointless*",s.gui.textBox.getText());
    }

    @Test
    void testFightBedDeath() {
        s.scm.fightBed();
        assertEquals("You were crushed by the bed",s.gui.textBox.getText());
        assertEquals(0,s.p.currHp);
    }
    @Test
    void testFightBed() {
        s.p.currHp = s.p.currHp +1;
        s.scm.fightBed();
        assertEquals("You take you fighting stance and leap with great power to attack the bed, you immediately after touching the bed fell asleep.\n" +
                "*you fell of the bed, it hurt*",s.gui.textBox.getText());
        assertEquals(1,s.p.currHp);
    }

    @Test
    void testExBed() {
        s.scm.exBed();
        assertEquals("The bed opens up to you and lets you in gently, you eeped (sleeped) very well.\n" +
                "*the bed used reversed cursed technique on you so you restored some heath*",s.gui.textBox.getText());
    }
    @Test
    void testExBedFull() {
        s.p.currHp = s.p.currHp +5;
        s.scm.exBed();
        assertEquals("The bed isnt opening, you no longer need to rest.\n" +
                "*your hp is full*",s.gui.textBox.getText());
        assertEquals(6,s.p.currHp);
    }

    @Test
    void testTalkCat() {
        s.scm.talkCat();
        assertEquals("You tried talking to the cat, it stared back with eternal malice.\n" +
                "*this is utterly terrifying*",s.gui.textBox.getText());
    }

    @Test
    void testLookCat() {
        s.scm.lookCat();
        assertEquals("You look at the cat, the cat mew back at you so you didnt understand.\n" +
                "*this is utterly cuteful*",s.gui.textBox.getText());
    }

    @Test
    void testFightCat() {
        s.scm.fightCat();
        assertEquals("Hey, dont do that, that´s not cool >:( !!!\n" +
                "*the cat used domain amplification so she wasn´t hurt, BUT YOU GOT*",s.gui.textBox.getText());
        assertEquals(-3,s.p.currHp);

    }
    @Test
    void testFightCatDeath() {
        s.scm.iCat = 1;
        s.scm.fightCat();
        assertEquals("I told you not to do that\n" +
                "*Such a cruel monster you are!*",s.gui.textBox.getText());
        assertEquals(-5,s.p.currHp);
    }

    @Test
    void testTalkCrate() {
        s.scm.talkCrate();
        assertEquals("The crate is cheery, but it cant express itself, its just a crate.\n" +
                "*this is utterly pointless*",s.gui.textBox.getText());
    }

    @Test
    void testLookCrate() {
        s.scm.lookCrate();
        assertEquals("Looking at the crate it reminds you of a memory long forgotten.\n" +
                "*this is utterly memoryless*",s.gui.textBox.getText());
    }

    @Test
    void testFightCrate() {
        s.scm.fightCrate();
        assertEquals("You fought the crate, it didnt fight back, you now feel bad about yourself.\n" +
                "*this is utterly pointless*",s.gui.textBox.getText());
    }

    @Test
    void testExCrate() {
        s.scm.exCrate();
        assertEquals("You gently kicked the living hell out of the crate, and the crate thanked you, you obtained a blaster from the crate.\n" +
                "*turns out i was a masochist crate, it also kinda hurt*",s.gui.textBox.getText());
        assertEquals(0,s.p.currHp);
    }
    @Test
    void testExCrateKicked() {
        s.p.aqGun = true;
        s.scm.exCrate();
        assertEquals("The kicked crate smiles at you.\n" +
                "*but you can see it, it doesnt have a mouth*",s.gui.textBox.getText());
    }
}