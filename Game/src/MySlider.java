import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class MySlider implements ChangeListener {
    JLabel label;
    JSlider slider;
    JFrame frame;
    JPanel panel;
    MySlider()
    {
        label = new JLabel();
        slider = new JSlider(0,100,50);
        //frame = new JFrame();
        panel = new JPanel();

        slider.setPreferredSize(new Dimension(800,600));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);

        panel.add(slider);
        panel.add(label);
       frame.add(panel);
       frame.setSize(800 , 600);
       frame.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
