package com.company;

import javax.swing.*;
import java.awt.*;


public class laser extends Rectangle  {
    Image laser=new ImageIcon("laiser.png").getImage();
    int Px;
    int Py;
    public static int lnum=0;
    public laser(Paddle p){
        this.Px=p.paddle_xp;
        this.Py=p.paddle_yp;
        lnum++;
    }

    public void  draw(Graphics g){
        g.drawRect(this.Px,this.Py,25,25);
        g.drawImage(this.laser,this.Px,this.Py,null);
        rise();
    }

    public void rise(){
        this.Py-=2;
    }


}
