import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    JButton przycisk;

    public static void main(String[] args) {

        Main apGUI = new Main();
        apGUI.doDziela();
    }

    public void doDziela() {

        JFrame ramka = new JFrame();

        przycisk = new JButton("Kliknij mnie");
        przycisk.addActionListener(this);
        przycisk.setFocusable(false);
        przycisk.setFont(new Font("Comic Sans",Font.BOLD,25));
        przycisk.setForeground(Color.red);
        przycisk.setBackground(Color.cyan);
        przycisk.setBorder(BorderFactory.createEtchedBorder());

        ImageIcon icon = new ImageIcon("icon.jpg");

        ramka.setIconImage(icon.getImage());
        ramka.setTitle("Przycisk");
        ramka.setResizable(false);
        ramka.getContentPane().setBackground(Color.black);
        ramka.getContentPane().add(BorderLayout.SOUTH, przycisk);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(300, 300);
        ramka.setVisible(true);
    }

    public void actionPerformed(ActionEvent zdarzenie) {
        przycisk.setText("Zostałem klinięty");
        przycisk.setEnabled(false);
    }
}
//Wyswietla przycisk reagujacy na klikniecie