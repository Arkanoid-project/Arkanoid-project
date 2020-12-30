package com.company;

import javax.swing.*;
import java.awt.event.MouseEvent;


public class Window extends JFrame {
    gamePanel gPanel;
    Window(){
        gPanel = new gamePanel() {
            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Arkanoid Adventure");
        this.setResizable(false);
        this.add(gPanel);
        this.addKeyListener(gPanel.ball);
        this.addKeyListener(gPanel.new ActionL());
        this.addMouseListener(gPanel.gameMenu);
        this.addMouseMotionListener(gPanel.gameMenu);
        this.pack();
    }
}
