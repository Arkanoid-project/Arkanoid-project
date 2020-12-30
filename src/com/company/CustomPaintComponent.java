package com.company;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class CustomPaintComponent {
    Image image =Toolkit.getDefaultToolkit().getImage("settings_BG.jpg");

    public void paint(Graphics g) {

        // Retrieve the graphics context; this object is used to paint shapes

        Graphics2D g2d = (Graphics2D)g;

        g2d.drawImage(image, 400,300, (ImageObserver) this);

    }
}
