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
        crtInteractibles("intrCat.png","Talk","Look","Take","Pet",375,230,150,200,0);
        //Crate
        crtInteractibles("intrCrate.png","Look","Kick",null,null,700,330,150,129,0);
        //Bed
        crtInteractibles("intrBed.png","Look","eep",null,null,50,280,250,176,0);

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

        ImageIcon bgHome = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaC projekt\\PaC adventura\\pics\\"+bgName);

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
    public void crtInteractibles(String intrName,String a1,String a2,String a3, String a4,int x, int y, int w, int h, int bgIndex){

        JMenuItem items[] = new JMenuItem[4];
        JLabel intrPic = new JLabel();
        JPopupMenu actionMenu = new JPopupMenu();

        intrPic.setBounds(x,y,w,h);
        ImageIcon intrBed = new ImageIcon("D:\\Škola 2\\Informační technologie\\PaC projekt\\PaC adventura\\pics\\"+intrName);
        intrPic.setIcon(intrBed);

        items[0] = new JMenuItem(a1);
        actionMenu.add(items[0]);
        items[1] = new JMenuItem(a2);
        actionMenu.add(items[1]);
        items[2] = new JMenuItem(a3);
        actionMenu.add(items[2]);
        items[3] = new JMenuItem(a4);
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


    /**
     * This method creates the base where all the visuals go
     */
    public void crtMainBase(){
        mainBase =  new JFrame();

        mainBase.setSize(1000,750);
        mainBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainBase.getContentPane().setBackground(Color.BLACK);
        mainBase.setLayout(null);

        textBox = new JTextArea("You Should go speak to the general");
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
