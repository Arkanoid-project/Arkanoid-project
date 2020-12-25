/*import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame implements MouseListener {
    public final int Frame_HEIGHT=600;
    public final int Frame_WIDTH=800;
    public int Scene_id=0;

    public final Dimension My_Dimension=new Dimension(Frame_WIDTH,Frame_HEIGHT);
    JPanel main_panel=new JPanel();
    JPanel settings_panel=new JPanel();
    JPanel score_panel=new JPanel();

    JButton Start_btn=new JButton();
    JButton Settings_btn=new JButton();
    JButton Exit_btn=new JButton();
    JButton ScoreB_btn=new JButton();

    ImageIcon Start_img =new ImageIcon("Game\\Data\\Start_button.png");
    ImageIcon Setting_img =new ImageIcon("Game\\Data\\s_button.png");
    ImageIcon BackGround=new ImageIcon("Game\\Data\\layer_1__semi_final.png");
    ImageIcon Score_img=new ImageIcon("Game\\Data\\Score_button2.png");
    ImageIcon Exit_img=new ImageIcon("Game\\Data\\exit_Button.png");
    JLabel Background_label=new JLabel();

        public Menu(){
        main_panel.setBounds(0,0,Frame_WIDTH,Frame_HEIGHT);
        this.setTitle("Arkanoid");
        this.setSize(My_Dimension);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        this.add(main_panel);
        this.add(settings_panel);
        this.add(score_panel);
        settings_panel.setVisible(false);
        score_panel.setVisible(false);
        this.drawScene(Scene_id);
    }
    public void drawScene(int Scene_id){
        switch (Scene_id) {
            case 0 -> {
                Background_label.setIcon(BackGround);
                Background_label.setPreferredSize(My_Dimension);
                Start_btn.setBounds(366, 451, 205, 110);
                Start_btn.setBorderPainted(false);
                Start_btn.addMouseListener(this);
                Start_btn.setIcon(Start_img);
                Start_btn.setBackground(Color.black);
                Start_btn.setFocusPainted(false);
                Start_btn.setOpaque(false);
                Start_btn.setContentAreaFilled(false);
                Settings_btn.setBounds(666, 113, 100, 80);
                Settings_btn.setBorderPainted(false);
                Settings_btn.addMouseListener(this);
                Settings_btn.setIcon(Setting_img);
                Settings_btn.setBackground(Color.black);
                Settings_btn.setFocusPainted(false);
                Settings_btn.setOpaque(false);
                Settings_btn.setContentAreaFilled(false);
                ScoreB_btn.setBounds(666, 240, 100, 82);
                ScoreB_btn.setBorderPainted(false);
                ScoreB_btn.addMouseListener(this);
                ScoreB_btn.setIcon(Score_img);
                ScoreB_btn.setBackground(Color.black);
                ScoreB_btn.setFocusPainted(false);
                ScoreB_btn.setOpaque(false);
                ScoreB_btn.setContentAreaFilled(false);
                Exit_btn.setBounds(666, 370, 100, 82);
                Exit_btn.setBorderPainted(false);
                Exit_btn.addMouseListener(this);
                Exit_btn.setIcon(Exit_img);
                //set button to transparent
                Exit_btn.setBackground(Color.black);
                Exit_btn.setFocusPainted(false);
                Exit_btn.setOpaque(false);
                Exit_btn.setContentAreaFilled(false);
                Background_label.add(Start_btn);
                Background_label.add(Settings_btn);
                Background_label.add(ScoreB_btn);
                Background_label.add(Exit_btn);
                main_panel.add(Background_label);
            }
            case 1 -> {
                //choose level panel
            }
            case 2 ->{
                //settings panel
                settings_panel.setBounds(0,0,Frame_WIDTH,Frame_HEIGHT);
                settings_panel.setBackground(Color.GREEN);
                MySlider slider = new MySlider();

            }
            case 3->{
                //scoreboard panel
                score_panel.setBounds(0,0,Frame_WIDTH,Frame_HEIGHT);
                score_panel.setBackground(Color.BLUE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==Start_btn){
            System.out.println("Start level");
            main_panel.setVisible(false);
            Scene_id=1;
            System.out.println(Scene_id);

        }else if (e.getSource()==Settings_btn){
            main_panel.setVisible(false);
            settings_panel.setVisible(true);
            Scene_id=2;
            drawScene(Scene_id);
            System.out.println("Settings");
        }else if(e.getSource()==ScoreB_btn){
            main_panel.setVisible(false);
            score_panel.setVisible(true);
            Scene_id=3;
            drawScene(Scene_id);
            System.out.println("Score");
        }else if(e.getSource()==Exit_btn) {
            System.out.println("Exit");
            this.dispose();
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
        }else if(e.getSource()==ScoreB_btn) {
            ScoreB_btn.setBounds(ScoreB_btn.getX(),ScoreB_btn.getY(),ScoreB_btn.getWidth()+10,ScoreB_btn.getHeight()+10);
            System.out.println("BigScore");
        } else{
            Start_btn.setBounds(366,451,205,110);
            Settings_btn.setBounds(666,113,100,80);
            Exit_btn.setBounds(666,370,100,82);
            ScoreB_btn.setBounds(666,240,100,82);

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {}
}*/
