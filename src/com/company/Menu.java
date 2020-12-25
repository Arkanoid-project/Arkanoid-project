package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Menu implements MouseListener {
    public final int Frame_HEIGHT=600;
    public final int Frame_WIDTH=800;
    public int live_index;
    public final Dimension My_Dimension=new Dimension(Frame_WIDTH,Frame_HEIGHT);
    Image Start_img =new ImageIcon("Start_button.png").getImage();
    int btn_positions[][] = {
            {366,451},
            {666, 113},
            {666, 240},
            {666, 370}
    };
    Image Setting_btn;
    Image BackGround;
    Image Score_btn;
    Image Exit_btn;
    public Menu(int live_index){
        this.live_index = live_index;
        Setting_btn =new ImageIcon("s_button.png").getImage();
        BackGround=new ImageIcon("layer_1__semi_final.png").getImage();
        Score_btn =new ImageIcon("Score_button2.png").getImage();
        Exit_btn =new ImageIcon("exit_Button.png").getImage();
    }
    public void draw(Graphics2D g){
g.drawImage(BackGround,0,0,null);
g.drawImage(Start_img,btn_positions[0][0],btn_positions[0][1],null);
g.drawImage(Setting_btn,btn_positions[1][0], btn_positions[1][1],null);
g.drawImage(Score_btn,btn_positions[2][0], btn_positions[2][1],null);
g.drawImage(Exit_btn,btn_positions[3][0], btn_positions[3][1],null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getX()<Start_img.getWidth(null)+366 && e.getX()>366 ) {
           if (e.getY()<Start_img.getHeight(null)+481 && e.getY()>451) {
               System.out.println("Start level");
               live_index = 1;
           }
       }
       if(e.getX()< Score_btn.getWidth(null)+666 && e.getX()>666) {
           if (e.getY() < Score_btn.getHeight(null) + 270 && e.getY() > 240) {
               System.out.println("Score");
           }
       }
       if (e.getX()< Setting_btn.getWidth(null)+666 && e.getX()>666){
           if(e.getY()< Setting_btn.getHeight(null)+143 && e.getY() > 113){
               System.out.println("Settings");
           }

        }
       if(e.getX()< Exit_btn.getWidth(null)+666 && e.getX()>666) {
           if(e.getY()< Exit_btn.getHeight(null)+390 && e.getY() > 370){
               System.out.println("Exit");
           }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
      //  Rectangle photoPos = new Rectangle(366,451,Start_img.getWidth(null),Start_img.getHeight(null));
        if(e.getXOnScreen()<Start_img.getWidth(null)+366 && e.getXOnScreen()>366 ) {
            if (e.getYOnScreen()<Start_img.getHeight(null)+481 && e.getYOnScreen()>451) {
                btn_positions[0][0] = 376;
                btn_positions[0][1] = 461;
                System.out.println("Exit");
            }
        }
        if(e.getX()< Score_btn.getWidth(null)+666 && e.getX()>666) {
            if (e.getY() < Score_btn.getHeight(null) + 270 && e.getY() > 240) {
                btn_positions[1][0] = 676;
                btn_positions[1][1] = 250;
                System.out.println("Exit");
            }
        }
        if (e.getX()< Setting_btn.getWidth(null)+666 && e.getX()>666){
            if(e.getY()< Setting_btn.getHeight(null)+143 && e.getY() > 113){
                btn_positions[2][0] = 676;
                btn_positions[2][1] = 123;
                System.out.println("Exit");
            }

        }
        if(e.getX()< Exit_btn.getWidth(null)+666 && e.getX()>666) {
            if(e.getY()< Exit_btn.getHeight(null)+390 && e.getY() > 370){
                btn_positions[3][0] = 676;
                btn_positions[3][1] = 380;
                System.out.println("Exit");
            }

        }/*else{
            Start_btn.setBounds(366,451,205,110);
            Settings_btn.setBounds(666,113,100,80);
            Exit_btn.setBounds(666,370,100,82);
            ScoreB_btn.setBounds(666,240,100,82);
        }*/
    }
    @Override
    public void mouseExited(MouseEvent e) {}
}