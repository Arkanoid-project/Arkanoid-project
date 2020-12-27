package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Menu implements MouseListener, MouseMotionListener {
    public int live_index;
    int[][] btn_positions = {
            {366,451},
            {666, 113},
            {666, 240},
            {666, 370}
    };
    Image Start_img ;
    Image Setting_btn;
    Image BackGround;
    Image Score_btn;
    Image Exit_btn;
    Image BigSettings;
    Image BigScore;
    Image BigExit;
    Image BigStart;
    boolean []entered={false,false,false,false};
    public Menu(int live_index){
        this.live_index = live_index;
        Start_img=new ImageIcon("Start_button.png").getImage();
        Setting_btn =new ImageIcon("s_button.png").getImage();
        BackGround=new ImageIcon("layer_1__semi_final.png").getImage();
        Score_btn =new ImageIcon("Score_button2.png").getImage();
        Exit_btn =new ImageIcon("exit_Button.png").getImage();
        BigSettings = new ImageIcon("s_button2.png").getImage();
        BigScore =new ImageIcon("Score_button2Big.png").getImage();
        BigExit =new ImageIcon("exit_ButtonBig.png").getImage();
        BigStart =new ImageIcon("Start_buttonBig.png").getImage();
    }
    public void draw(Graphics2D g){
        if(live_index==0){

            g.drawImage(BackGround,0,0,null);
            g.drawImage(Start_img,btn_positions[0][0],btn_positions[0][1],null);
            g.drawImage(Setting_btn,btn_positions[1][0], btn_positions[1][1],null);
            g.drawImage(Score_btn,btn_positions[2][0], btn_positions[2][1],null);
            g.drawImage(Exit_btn,btn_positions[3][0], btn_positions[3][1],null);
                if(entered[0]){

                    g.drawImage(BigStart,btn_positions[0][0],btn_positions[0][1],null);
                }else if (entered[1]){

                    g.drawImage(BigSettings,btn_positions[1][0], btn_positions[1][1],null);
                }else if(entered[2]){

                    g.drawImage(BigScore,btn_positions[2][0], btn_positions[2][1],null);
                }else if(entered[3]){

                    g.drawImage(BigExit,btn_positions[3][0], btn_positions[3][1],null);
            }
        }
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
               live_index=2;
           }

        }
       if(e.getX()< Exit_btn.getWidth(null)+666 && e.getX()>666) {
           if(e.getY()< Exit_btn.getHeight(null)+390 && e.getY() > 370){
               System.out.println("Exit");
           }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {

        if(e.getX() < Start_img.getWidth(null)+366 && e.getX()>366 ) {
            if (e.getY() < Start_img.getHeight(null)+471 && e.getY()>451) {
                entered[0]=true;
            }
        }
        if(e.getX()< Score_btn.getWidth(null)+666 && e.getX()>666) {
            if (e.getY() < Score_btn.getHeight(null) + 270 && e.getY() > 240) {
                entered[2]=true;
            }
        }
        if (e.getX()< Setting_btn.getWidth(null)+666 && e.getX()>666){
            if(e.getY()< Setting_btn.getHeight(null)+143 && e.getY() > 113){
                entered[1]=true;
            }

        }
        if(e.getX()< Exit_btn.getWidth(null)+666 && e.getX()>666) {
            if(e.getY()< Exit_btn.getHeight(null)+390 && e.getY() > 370){
                entered[3]=true;
            }

        }else{
            entered[0]=false;
            entered[1]=false;
            entered[2]=false;
            entered[3]=false;
        }
    }
}