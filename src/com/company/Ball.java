package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Ball implements KeyListener {
    int ball_xp ;
    int ball_yp ;
    int ball_xv = -1;
    int ball_yv = -1;
    int ball_speed = 0;
    public int live_index;
    boolean isBallLaunched = false;
    Image ballImage[];
    int selectedBall = 0;
    Ball(int selectedBall,Paddle paddle,int live_index){
this.live_index = live_index;
        ballImage = new Image[4];
        ballImage[0] = new ImageIcon("BlueBall.png").getImage();
        ballImage[1] = new ImageIcon("GreenBall.png").getImage();
        ballImage[2] = new ImageIcon("PinkBall.png").getImage();
        ballImage[3] = new ImageIcon("OrangeBall.png").getImage();
    this.selectedBall = selectedBall;
    setBallInitialPos(paddle);

    }

    public void setBallInitialPos(Paddle paddle){
        ball_xp = paddle.paddle_xp + paddle.paddleImage.getWidth(null)/2 - ballImage[selectedBall].getWidth(null)/2;
        ball_yp = paddle.paddle_yp - ballImage[selectedBall].getHeight(null);
        isBallLaunched = false;
    }

    public void draw(Graphics2D g){
        g.drawImage(ballImage[selectedBall],ball_xp,ball_yp,null);
    }

    public void setIndex(int live_index){this.live_index = live_index;}

    public boolean move(boolean isInverted){
if(ball_xp<0 ||ball_xp > 800 - ballImage[selectedBall].getWidth(null)){
    ball_xv *= -1 ;
    isInverted = false;
}
if(ball_yp <0 ){
    ball_yv *= -1;
    isInverted = false;
}
ball_xp += ball_xv * ball_speed;
ball_yp += ball_yv * ball_speed;
return isInverted;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
 if(keyEvent.getKeyCode() == 32 && ball_speed == 0 && live_index == 1){
     ball_speed = 3;
isBallLaunched = true;
 }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
