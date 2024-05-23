import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class makes all the visuals
 */
public class Gui {

    JFrame mainBase;
    JPanel healthBar;
    public JPanel bg[] = new JPanel[6];
    JPanel inventory;
    Start s;
    public JTextArea textBox;
    public JLabel bgPics[] = new JLabel[15];
    JLabel hearts[] = new JLabel[7];
    public JLabel gun,keys,armor,device,medal;


    public Gui(Start s){
        this.s = s;
        crtMainBase();
        crtPlayerGui();
        gameScreenCreator();
        mainBase.setVisible(true);
    }

    /**
     * This method creates interactible objects and the places them on the Panel
     */
    public void gameScreenCreator(){
        //ScreenM
        crtBgStuff("bgHouse.jpg",0);
        crtArrows("ArrowUp.png","Screen0",450,10,50,50,0);
        crtArrows("ArrowRight.png","Screen1",850,200,50,50,0);
        crtInteractibles("intrCat.png","Talk","Look","Fight","Pet","TalkCat","LookCat","FightCat","ExCat",375,230,150,200,0);
        crtInteractibles("intrCrate.png","Talk","Look","Fight","Kick","TalkCrate","LookCrate","FightCrate","ExCrate",700,330,150,129,0);
        crtInteractibles("intrBed.png","Talk","Look","Fight","eep","TalkBed","LookBed","FightBed","ExBed",50,280,250,176,0);
        bg[0].add(bgPics[0]);

        //Screen0
        crtBgStuff("bgCasino.jpg",5);
        crtArrows("ArrowDown.png","ScreenM",450,10,50,50,5);
        crtInteractibles("intrJackpot.png","Talk","Look","Fight","Play","TalkJackpot","LookJackpot","FightJackpot","ExJackpot",375,175,300,306,5);
        crtInteractibles("intrBlank.png","Talk","Look","Fight","Pick up","TalkKey","LookKey","FightKey","ExKey",850,390,50,50,5);
        crtInteractibles("intrBlank.png","Talk","Look","Fight","Pick up","TalkDevice","LookDevice","FightDevice","ExDevice",750,390,50,50,5);
        bg[5].add(bgPics[5]);

        //Sreen1
        crtBgStuff("allyBase.jpg",1);
        crtArrows("ArrowRight.png","Screen2",850,200,50,50,1);
        crtArrows("ArrowLeft.png","ScreenM",50,200,50,50,1);
        crtInteractibles("intrGeneral.png","Talk","Look","Fight","Mission","TalkGeneral","LookGeneral","FightGeneral","ExGeneral",350,100,234,332,1);
        bg[1].add(bgPics[1]);

        //Sreen2
        crtBgStuff("allySpaceShip.png",2);

        bg[2].add(bgPics[2]);

        //Sreen3
        crtBgStuff("enemySpaceShip.jpg",3);

        bg[3].add(bgPics[3]);

        //Sreen4
        crtBgStuff("enemyBase.jpg",4);

        bg[4].add(bgPics[4]);

    }


    /**
     * This method creates the background
     */
    public void crtBgStuff(String bgName, int bgIndex){

        bg[bgIndex] = new JPanel();
        bg[bgIndex].setBounds(30,30,900,450);
        bg[bgIndex].setLayout(null);
        bg[bgIndex].setBackground(Color.black);
        mainBase.add(bg[bgIndex]);

        ImageIcon bgHome = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\"+bgName);

        bgPics[bgIndex] = new JLabel();
        bgPics[bgIndex].setBounds(30,30,899,451);
        bgPics[bgIndex].setIcon(bgHome);


    }

    public void crtPlayerGui(){
        healthBar = new JPanel();
        ImageIcon heart = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\healthIcon.png");
        ImageIcon gunI = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\gunIcon.png");
        ImageIcon keysI = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\keyIcon.png");
        ImageIcon deviceI = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\deviceIcon.png");
        ImageIcon armorI = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\armorIcon.png");
        ImageIcon medalI = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\medalIcon.png");

        healthBar.setBounds(550,0,300,50);
        healthBar.setLayout(new GridLayout(1,6));
        healthBar.setBackground(Color.BLACK);
        for (int i =0; i < 6;i++){
            hearts[i] = new JLabel();
            hearts[i].setIcon(heart);
            healthBar.add(hearts[i]);
        }

        inventory = new JPanel();
        inventory.setBounds(300,480,450,75);
        inventory.setLayout(new GridLayout(1,5));
        inventory.setBackground(Color.black);
        gun = new JLabel();
        gun.setIcon(gunI);
        inventory.add(gun);
        keys = new JLabel();
        keys.setIcon(keysI);
        inventory.add(keys);
        armor = new JLabel();
        armor.setIcon(armorI);
        inventory.add(armor);
        device = new JLabel();
        device.setIcon(deviceI);
        inventory.add(device);
        medal = new JLabel();
        medal.setIcon(medalI);
        inventory.add(medal);

        mainBase.add(healthBar);
        mainBase.add(inventory);
    }


    /**
     * This method creates interactible objects as well as the popup menus for the interactibles
     * @param intrName file name
     * @param x x coord
     * @param y y coord
     * @param w width coord
     * @param h height coord
     */
    public void crtInteractibles(String intrName,String a1,String a2,String a3, String a4,String a1Cmd,String a2Cmd,String a3Cmd,String a4Cmd,int x, int y, int w, int h, int bgIndex){

        JMenuItem items[] = new JMenuItem[4];
        JLabel intrPic = new JLabel();
        JPopupMenu actionMenu = new JPopupMenu();

        intrPic.setBounds(x,y,w,h);
        ImageIcon interactible = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\"+intrName);
        intrPic.setIcon(interactible);

        items[0] = new JMenuItem(a1);
        items[0].addActionListener(s.as);
        items[0].setActionCommand(a1Cmd);
        actionMenu.add(items[0]);

        items[1] = new JMenuItem(a2);
        items[1].addActionListener(s.as);
        items[1].setActionCommand(a2Cmd);
        actionMenu.add(items[1]);

        items[2] = new JMenuItem(a3);
        items[2].addActionListener(s.as);
        items[2].setActionCommand(a3Cmd);
        actionMenu.add(items[2]);

        items[3] = new JMenuItem(a4);
        items[3].addActionListener(s.as);
        items[3].setActionCommand(a4Cmd);
        actionMenu.add(items[3]);

        intrPic.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e));
                actionMenu.show(intrPic,e.getX(),e.getY());
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {}
        });

        bg[bgIndex].add(intrPic);

    }

    public void crtArrows(String arrowName,String cmd,int x,int y,int w,int h,int bgIndex){
        JButton arrowB = new JButton();
        ImageIcon arrowI = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaCAdventure\\PaCAdventure\\pics\\"+arrowName);
        arrowB.setBounds(x,y,w,h);
        arrowB.setBackground(null);
        arrowB.setIcon(arrowI);
        arrowB.setContentAreaFilled(false);
        arrowB.setBorderPainted(false);
        arrowB.setFocusPainted(false);
        arrowB.addActionListener(s.as);
        arrowB.setActionCommand(cmd);
        bg[bgIndex].add(arrowB);
    }


    /**
     * This method creates the base where all the visuals go
     */
    public void crtMainBase(){
        mainBase =  new JFrame();

        mainBase.setSize(1000,750);
        mainBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainBase.getContentPane().setBackground(Color.BLACK);
        mainBase.setLayout(null);

        textBox = new JTextArea("I should go speak with the general");
        textBox.setBounds(50,550,900,100);
        textBox.setForeground(Color.WHITE);
        textBox.setBackground(Color.BLACK);
        textBox.setFont(new Font("mainFont", Font.PLAIN, 21));

        textBox.setWrapStyleWord(true);
        textBox.setEditable(false);
        textBox.setLineWrap(true);
        mainBase.add(textBox);
    }
}
