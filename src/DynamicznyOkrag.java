import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DynamicznyOkrag implements ActionListener {
    JFrame ramka;

    public static void main(String[] args) {
        DynamicznyOkrag apGUI = new DynamicznyOkrag();
        apGUI.doDziela();
    }

    public void doDziela() {

        ramka = new JFrame();

        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton przycisk = new JButton("Zmiana koloru");
        przycisk.addActionListener(this);

        Okrag panelR = new Okrag();

        ramka.getContentPane().add(BorderLayout.SOUTH, przycisk);
        ramka.getContentPane().add(BorderLayout.CENTER, panelR);

        ramka.setSize(300,300);
        ramka.setVisible(true);
    }
    public void actionPerformed(ActionEvent zdarzenie) {
        ramka.repaint();
    }
}
//Wyswietla kolo zmieniajace kolor