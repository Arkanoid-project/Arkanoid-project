package com.company;

import java.awt.*;

public class Level {
    static int current_lvl = 0;

    int x = 140;
    int y = 82;
    Block[][] currentLvlBlock;
    levels selectedlevel;

    Level(levels selectedlevel) {
        this.selectedlevel = selectedlevel;

        currentLvlBlock = new Block[8][8];

        for(int i=0;i<8;i++){
            for(int j = 0;j<8;j++){
                currentLvlBlock[i][j] = new Block();
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                    currentLvlBlock[i][j].setHealth(selectedlevel.lvl[i][j]);
                    currentLvlBlock[i][j].setBlockShape(selectedlevel.lvl[i][j]);
                    currentLvlBlock[i][j].setBlockPosition(x + (currentLvlBlock[i][j].getBlockWidth() * j), y + (currentLvlBlock[i][j].getBlockHeight() * i));

                x += 7;
            }
                x = 140;
                y += 10;
        }
        current_lvl++;
        }

    public void draw(Graphics2D g) {
        for (int i = 0; i < currentLvlBlock.length; i++) {
            for (int j = 0; j < currentLvlBlock.length; j++) {
                if(selectedlevel.lvl[i][j]!=0)
                g.drawImage(currentLvlBlock[i][j].blockColor, currentLvlBlock[i][j].px, currentLvlBlock[i][j].py, null);
            }
        }
    }

}
class levels{
    int[][] lvl;
    levels(){
        lvl = new int[8][8];
    }

}

