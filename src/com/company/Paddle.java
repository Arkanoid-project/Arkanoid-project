package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Paddle{
    Image paddleImage;
    int paddle_xp;
    int paddle_yp;
    int paddle_xv = 0;
    boolean isBallLaunched = false;

    Paddle(int GameWidth,int GameHeight){
        paddleImage = new ImageIcon("Paddle.png").getImage();
        setPaddleInitialPosition(GameWidth,GameHeight);
    }
    public Image getPaddleImage(){
        return this.paddleImage;
    }
    public void setPaddleInitialPosition(int GameWidth,int GameHeight){
        paddle_xp = GameWidth/2 - (paddleImage.getWidth(null)/2);
        paddle_yp = GameHeight - 50;
    }

    public void getBallStatus(boolean isBallLaunched){
        this.isBallLaunched = isBallLaunched;
    }

    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode()==KeyEvent.VK_RIGHT && isBallLaunched){
            paddle_xv = 10;
        }
        else if(keyEvent.getKeyCode()==KeyEvent.VK_LEFT && isBallLaunched){
            paddle_xv = -10;
        }
    }
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode()==KeyEvent.VK_RIGHT){
            paddle_xv = 0;
        }
        else if(keyEvent.getKeyCode()==KeyEvent.VK_LEFT){
            paddle_xv = 0;
        }
    }


    public void draw(Graphics2D g){
        g.drawImage(paddleImage, paddle_xp, paddle_yp,null);
    }

    public void move(){
        paddle_xp += paddle_xv;
    }

}