import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuBar extends JFrame implements ActionListener {

    JFrame frame;
    JMenuBar bar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    MenuBar() {

        frame = new JFrame("MenuBar Demo");
        bar = new JMenuBar();

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_H);

        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(helpMenu);

        frame.setJMenuBar(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loadItem) {
            System.out.println("Loaded a file");
        } else if(e.getSource() == saveItem) {
            System.out.println("Saved a file");
        } else if(e.getSource() == exitItem) {
            System.exit(0);
        }
    }
}
