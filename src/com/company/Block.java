package com.company;

import javax.swing.*;
import java.awt.*;

public class Block {
    private int health;
    Image blockShape[];
    Image blockColor;
    int px,py;
    Block(){
        blockShape = new Image[6];
        blockShape[0] = new ImageIcon("").getImage();
        blockShape[1] = new ImageIcon("DarkPinkBlock.png").getImage();
        blockShape[2] = new ImageIcon("BlueBlock.png").getImage();
        blockShape[3] = new ImageIcon("OrangeBlock.png").getImage();
        blockShape[4] = new ImageIcon("GreenBlock.png").getImage();
        blockShape[5] = new ImageIcon("GreenBlueBlock.png").getImage();
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
