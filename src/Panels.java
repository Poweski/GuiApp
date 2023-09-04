import javax.swing.*;
import java.awt.*;

public class Panels {

    public static void main(String[] args) {

        Panels apGUI = new Panels();
        apGUI.doDziela();
    }

    public void doDziela() {

        JLabel label = new JLabel();
        label.setText("Hi");

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250,500,250);

        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setLayout(null);
        ramka.setSize(750, 750);
        ramka.setVisible(true);
        greenPanel.add(label);
        ramka.add(redPanel);
        ramka.add(bluePanel);
        ramka.add(greenPanel);
    }
}
