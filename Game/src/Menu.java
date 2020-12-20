import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame implements MouseListener {
    public final int Frame_HEIGHT=600;
    public final int Frame_WIDTH=800;


    public final Dimension My_Dimension=new Dimension(Frame_WIDTH,Frame_HEIGHT);


    JButton Start_btn=new JButton();
    JButton Settings_btn=new JButton();
    JButton Exit_btn=new JButton();

    ImageIcon Start_img =new ImageIcon("C:\\Users\\Om562\\IdeaProjects\\Arkanoid-finale\\Game\\Data\\Start_button.png");
    ImageIcon Setting_img =new ImageIcon("C:\\Users\\Om562\\IdeaProjects\\Arkanoid-finale\\Game\\Data\\s_button.png");
    ImageIcon BackGround=new ImageIcon("C:\\Users\\Om562\\IdeaProjects\\Arkanoid-finale\\Game\\Data\\layer_1__semi_final.png");
    ImageIcon Exit_img=new ImageIcon("C:\\Users\\Om562\\IdeaProjects\\Arkanoid-finale\\Game\\Data\\Score_button2.png");
    JLabel Background_label=new JLabel("",BackGround,JLabel.CENTER);

        public Menu(){

        this.setTitle("Arkanoid");
        this.setSize(My_Dimension);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        Background_label.setBounds(-10,-20,Frame_WIDTH,Frame_HEIGHT);

        Start_btn.setBounds(366,451,205,110);

        Start_btn.setBorderPainted(false);
        Start_btn.setFocusPainted(false);
        Start_btn.addMouseListener(this);
        Start_btn.setIcon(Start_img);
        Start_btn.setBackground(Color.black);
        Start_btn.setFocusPainted(false);
        Start_btn.setOpaque(false);



        Settings_btn.setBounds(666,113,100,80);

        Settings_btn.setBorderPainted(false);
        Settings_btn.setFocusPainted(false);
        Settings_btn.addMouseListener(this);
        Settings_btn.setIcon(Setting_img);
        Settings_btn.setBackground(Color.black);
        Settings_btn.setFocusPainted(false);
        Settings_btn.setOpaque(false);

        Exit_btn.setBounds(666,220,100,82);

        Exit_btn.setBorderPainted(false);
        Exit_btn.setFocusPainted(false);
        Exit_btn.addMouseListener(this);
        Exit_btn.setIcon(Exit_img);
        Exit_btn.setBackground(Color.black);
        Exit_btn.setFocusPainted(false);
        Exit_btn.setOpaque(false);

        this.add(Start_btn);
        this.add(Settings_btn);
        this.add(Exit_btn);
        this.add(Background_label);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==Start_btn){
            System.out.println("Start level");
        }else if (e.getSource()==Settings_btn){
            System.out.println("Settings");
        }else{
            System.out.println("Exit");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==Start_btn){
            Start_btn.setBounds(Start_btn.getX(),Start_btn.getY(),Start_btn.getWidth()+10,Start_btn.getHeight()+10);
            System.out.println("BigStart");
        }else if(e.getSource()==Settings_btn){
            Settings_btn.setBounds(Settings_btn.getX(),Settings_btn.getY(),Settings_btn.getWidth()+10,Settings_btn.getHeight()+10);
            System.out.println("BigSettings");
        }else if (e.getSource()==Exit_btn){
            Exit_btn.setBounds(Exit_btn.getX(),Exit_btn.getY(),Exit_btn.getWidth()+10,Exit_btn.getHeight()+10);

            System.out.println("BigExit");
        }else{
            Start_btn.setBounds(366,451,205,110);
            Settings_btn.setBounds(666,113,100,80);
            Exit_btn.setBounds(666,220,100,82);

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {}
}
