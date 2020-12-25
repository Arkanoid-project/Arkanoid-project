/*
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
}*/
