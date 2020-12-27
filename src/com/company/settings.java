package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class settings implements MouseListener {
    Image backButton ;


  settings(){
    backButton = new ImageIcon("back_Button.png").getImage();


}
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        ((Graphics2D) g).drawImage(backButton, 0,0,28,28 ,null);
    }
        @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
