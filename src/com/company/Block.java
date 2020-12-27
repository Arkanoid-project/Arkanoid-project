package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Block {
    private int health;
    Image[] blockShape;
    Image blockColor;
    int px,py;
    boolean has_powerup;
    int pwr_index;
    public  static int blcknum =0;
    Random r;
    Block(){
        blockShape = new Image[6];
        blockShape[0] = new ImageIcon("").getImage();
        blockShape[1] = new ImageIcon("DarkPinkBlock.png").getImage();
        blockShape[2] = new ImageIcon("BlueBlock.png").getImage();
        blockShape[3] = new ImageIcon("OrangeBlock.png").getImage();
        blockShape[4] = new ImageIcon("GreenBlock.png").getImage();
        blockShape[5] = new ImageIcon("GreenBlueBlock.png").getImage();

        blcknum++;
        if(blcknum%3==0){
        r=new Random();
         has_powerup=r.nextBoolean();
            if(has_powerup){
              pwr_index=r.nextInt(3);
            }
        }
    }
    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;

    }
    public void setBlockShape(int shape_index) {
            blockColor = blockShape[shape_index];
    }
    public int getBlockWidth(){
        return blockColor.getWidth(null);
    }
    public int getBlockHeight(){
        return blockColor.getHeight(null);
    }
    public void setBlockPosition(int px,int py){
        this.px = px;
        this.py = py;
    }

    }


