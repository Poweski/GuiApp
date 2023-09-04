import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Sliders extends JFrame implements ChangeListener {

    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;

    Sliders() {

        frame = new JFrame("Slider Demo");
        panel = new JPanel();
        label =  new JLabel();
        slider = new JSlider(0,100,50);

        slider.setPreferredSize(new Dimension(400,200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        slider.setOrientation(SwingConstants.VERTICAL);

        label.setFont(new Font("MV Boli",Font.PLAIN,25));
        label.setText("°C = " + slider.getValue());

        slider.addChangeListener(this);

        panel.add(slider);
        panel.add(label);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setVisible(true);
    }

    public void stateChanged(ChangeEvent e) {

        label.setText("°C = " + slider.getValue());
    }
}
