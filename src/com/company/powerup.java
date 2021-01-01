package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class powerup extends Rectangle {
    int Px;
    int Py;
    int power_index;
    Image[] pwr_image;
    public static int num = 0;

    public powerup(Block B) {
        this.Px = B.px;
        this.Py = B.py;
        this.power_index = B.pwr_index;
        pwr_image = new Image[3];
        pwr_image[0] = new ImageIcon("paddleplus.png").getImage();
        pwr_image[1] = new ImageIcon("powerUPShape.png").getImage();
        pwr_image[2] = new ImageIcon("speedUP.png").getImage();
        num++;
    }

    public void draw(Graphics g) {

        g.drawRect(this.Px, this.Py, this.pwr_image[power_index].getWidth(null), this.pwr_image[power_index].getHeight(null));
        g.drawImage(this.pwr_image[this.power_index], this.Px, this.Py, null);
        this.fall();
    }

    public void fall() {
        this.Py += 2;
    }





}
