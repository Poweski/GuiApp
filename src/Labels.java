import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Labels {

    public static void main(String[] args) {

        Labels apGUI = new Labels();
        apGUI.doDziela();
    }

    public void doDziela() {

        JFrame ramka = new JFrame();
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("ZeroTwo.jpg");
        Border border = BorderFactory.createLineBorder(Color.red, 3);

        label.setText("Bro, do you even code?");
        label.setIcon(icon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.red);
        label.setFont(new Font("MV Boli", Font.PLAIN,20));
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        //label.setBounds(0,0,306,306);

        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ramka.setSize(300, 300);
        //ramka.setLayout(null);
        ramka.setVisible(true);
        ramka.add(label);
        ramka.pack();
    }
}