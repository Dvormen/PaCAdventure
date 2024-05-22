import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class makes all the visuals
 */
public class Gui {

    JFrame mainBase;
    Start s;
    public JTextArea textBox;
    public JLabel bgPics[] = new JLabel[7];
    public JPanel bg[] = new JPanel[7];


    public Gui(Start s){
        this.s = s;
        crtMainBase();
        gameCreator();
        mainBase.setVisible(true);
    }

    /**
     * This method creates interactible objects and the places them on the Panel
     */
    public void gameCreator(){

        //main bg
        crtBgStuff("bgHouse.jpg",0);
        //Cat
        crtInteractibles("intrCat.png","Talk","Look","Fight","Pet","TalkCat","LookCat","FightCat","ExCat",375,230,150,200,0);
        //Crate
        crtInteractibles("intrCrate.png","Talk","Look","Fight","Kick","TalkCrate","LookCrate","FightCrate","ExCrate",700,330,150,129,0);
        //Bed
        crtInteractibles("intrBed.png","Talk","Look","Fight","eep","TalkBed","LookBed","FightBed","ExBed",50,280,250,176,0);

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
        bg[bgIndex].add(bgPics[bgIndex]);

    }

    public void crtArrows(){

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
