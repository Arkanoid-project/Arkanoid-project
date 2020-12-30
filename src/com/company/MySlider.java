package com.company;/*

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import javax.swing.GroupLayout;

public class MySlider implements ChangeListener {

    JLabel label;
    JSlider slider;
    JFrame frame;
    JPanel panel;
    JLabel label2;
    JLabel label3;
    JSlider slider2;
    JLabel label4;


    MySlider()
    {
        label = new JLabel();
        slider = new JSlider(0,100,50);
        frame = new JFrame();
        panel = new JPanel();

        label2= new JLabel("Music");

        label2.setFont(new Font("MV Poli" , Font.PLAIN , 15));
       // label2.setBackground(new Color(0xB366DC));
        slider.setPreferredSize(new Dimension(200,150));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        panel.add(label2);
        panel.add(slider);
        panel.add(label);
       frame.add(panel);
       frame.setSize(800 , 600);
       frame.setVisible(true);




        slider2 = new JSlider(0,100,50);

        label3= new JLabel("Sound");
        label3.setFont(new Font("MV Poli" , Font.PLAIN , 15));
        // label2.setBackground(new Color(0xB366DC));
        slider2.setPreferredSize(new Dimension(200,350));
        slider2.setPaintTicks(true);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintTrack(true);
        slider2.setMajorTickSpacing(25);
        slider2.setPaintLabels(true);
        panel.add(label3);
        panel.add(slider2);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=  GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy=0;
        panel.add(slider,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(slider2,gbc);

        //GroupLayout layout = new GroupLayout(panel);
        // layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);
        // panel.setLayout(layout);
        // layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(slider).addComponent(slider2));
        //layout.createParallelGroup((GroupLayout.Alignment.LEADING).);
    }
    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
*/


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MySlider {

    public MySlider() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
        public JLabel label;
        public int delay;
        public int speed;
        public ImageIcon imageIcon;
        public Timer timer;

        public TestPane() {
            setLayout(new GridLayout(5, 5, 5, 25));
            slider.setPaintLabels(true);

            label = new JLabel();
            try {
                BufferedImage frameImage = ImageIO.read(getClass().getResource("/Run-0.png"));
                label.setIcon(new ImageIcon(frameImage));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            SliderListener sliderListener = new SliderListener();
            timer = new Timer(delay, sliderListener);
            slider.addChangeListener(sliderListener);
            System.out.println(speed);
            timer.addActionListener(sliderListener);

            timer.start();

            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

            add(label);
            add(slider);
        }

        private class SliderListener implements ChangeListener, ActionListener {

            public void stateChanged(ChangeEvent e) {

                int value = slider.getValue();
                timer.setDelay(value);

            }

            private int frame = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tick " + ((Timer) e.getSource()).getDelay());
                try {
                    BufferedImage frameImage = ImageIO.read(getClass().getResource("/Run-" + frame + ".png"));
                    label.setIcon(new ImageIcon(frameImage));
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
                frame++;
                if (frame > 11) {
                    frame = 0;
                }
            }
        }

    }

}
