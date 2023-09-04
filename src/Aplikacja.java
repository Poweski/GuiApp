import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Aplikacja implements ActionListener, ChangeListener  {
    JFrame ramka;
    JPanel mainPanel, firstPanel, secondPanel, thirdPanel, fourthPanel, panel11, panel1, panel2, panel3, tmp1Panel, tmp2Panel;
    JLabel label1, label2, label3;
    JMenuBar mbar;
    JMenu fileMenu, editMenu, helpMenu;
    JMenuItem loadItem, saveItem, exitItem;
    JCheckBox checkBox;
    JComboBox comboBox;
    JProgressBar pbar;
    JScrollPane scroll;
    JTextField textField;
    JTextArea tekst;
    JSlider slider;
    JTabbedPane tabbedPane;
    JRadioButton opcja1, opcja2, opcja3;
    JButton button1, button2, button3;
    ButtonGroup group;
    ImageIcon hand;
    Aplikacja.MojPanelRysunkowy panelR;
    GradientPaint gradient = losuj();
    int licznik = 1;

    public static void main(String[] args) {

        Aplikacja app = new Aplikacja();
        app.doDziela();
    }

    public void doDziela() {

        // podział panelu glownego na 4 podpanele
        ramka = new JFrame();
        mainPanel = new JPanel();
        firstPanel = new JPanel();
        secondPanel = new JPanel();
        thirdPanel = new JPanel();
        fourthPanel = new JPanel();
        tmp1Panel = new JPanel();
        tmp2Panel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2,10,10));
        firstPanel.setLayout(new BorderLayout());
        secondPanel.setLayout(new BorderLayout());
        fourthPanel.setLayout(new BorderLayout());
        tmp1Panel.setLayout(new GridLayout(2,1,5,5));
        tmp2Panel.setLayout(new GridLayout(1,2,5,0));
        mainPanel.setBorder(BorderFactory.createEtchedBorder());
        firstPanel.setBorder(BorderFactory.createTitledBorder("Panel"));
        secondPanel.setBorder(BorderFactory.createTitledBorder("Gradient"));
        thirdPanel.setBorder(BorderFactory.createTitledBorder("Termometr"));
        tmp1Panel.add(tmp2Panel);
        firstPanel.add(tmp1Panel);
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);

        // menu
        mbar = new JMenuBar();
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
        mbar.add(fileMenu);
        mbar.add(editMenu);
        mbar.add(helpMenu);
        ramka.setJMenuBar(mbar);

        // chceckbox
        checkBox = new JCheckBox();
        checkBox.setText("Nie jestem robotem");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas", Font.PLAIN,15));

        // combobox
        String[] items = {"Item 1", "Item 2", "Item 3"};
        comboBox = new JComboBox(items);
        comboBox.addActionListener(this);
        tmp2Panel.add(comboBox);

        // radiobutton
        opcja1 = new JRadioButton("opcja 1");
        opcja2 = new JRadioButton("opcja 2");
        opcja3 = new JRadioButton("opcja 3");
        group = new ButtonGroup();
        group.add(opcja1);
        group.add(opcja2);
        group.add(opcja3);
        opcja1.setFocusable(false);
        opcja2.setFocusable(false);
        opcja3.setFocusable(false);
        opcja1.addActionListener(this);
        opcja2.addActionListener(this);
        opcja3.addActionListener(this);
        panel11 = new JPanel();
        panel11.add(opcja1);
        panel11.add(opcja2);
        panel11.add(opcja3);
        tmp2Panel.add(panel11);

        // progress
        pbar = new JProgressBar(0,100);
        pbar.setValue(0);
        pbar.setBounds(0,0,420,50);
        pbar.setStringPainted(true);
        pbar.setFont(new Font("MV Boli",Font.BOLD,25));
        pbar.setPreferredSize(new Dimension(100,40));
        tmp1Panel.add(pbar);

        // gradient
        button3 = new JButton("Zmiana koloru");
        button3.setFocusable(false);
        button3.addActionListener(new ReakcjaNaPrzycisk1());
        panelR = new Aplikacja.MojPanelRysunkowy();
        secondPanel.add(BorderLayout.SOUTH, button3);
        secondPanel.add(BorderLayout.CENTER, panelR);

        // termometr
        label2 = new JLabel();
        slider = new JSlider(-60,60,0);
        slider.setPreferredSize(new Dimension(300,185));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(15);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        slider.setOrientation(SwingConstants.VERTICAL);
        label2.setFont(new Font("MV Boli",Font.PLAIN,20));
        label2.setText("°C = " + slider.getValue());
        slider.addChangeListener(this);
        thirdPanel.add(BorderLayout.WEST,slider);
        thirdPanel.add(BorderLayout.CENTER,label2);

        // podzial panelu 4 na 2 zakladki
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50,50,250,250);
        fourthPanel.add(BorderLayout.CENTER,tabbedPane);
        panel1 = new JPanel();
        panel2 = new JPanel();
        tabbedPane.add("Strona 1",panel1);
        tabbedPane.add("Strona 2",panel2);

        // customizacja pola tekstu w zakladce 1
        panel3 = new JPanel();
        button1 = new JButton("Kliknij mnie!");
        button1.setFocusable(false);
        button1.addActionListener(new ReakcjaNaPrzycisk2());
        tekst = new JTextArea(10,20);
        tekst.setLineWrap(true);
        scroll = new JScrollPane(tekst);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel3.add(scroll);
        panel1.add(BorderLayout.CENTER, panel3);
        panel1.add(BorderLayout.SOUTH, button1);

        // customizacja pola tekstowego w zakladce 2
        hand = new ImageIcon("hi3.png");
        label3 = new JLabel();
        label3.setText("Podaj nick:");
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setVerticalTextPosition(JLabel.CENTER);
        label3.setFont(new Font("Consolas", Font.PLAIN,20));
        panel2.add(label3);
        button2 = new JButton("Zatwierdz");
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setPreferredSize(new Dimension(150,40));
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas", Font.PLAIN,20));
        textField.setForeground(Color.black);
        textField.setBackground(Color.white);
        textField.setCaretColor(Color.black);
        textField.setText("username");
        panel2.add(textField);
        panel2.add(button2);
        label1 = new JLabel();
        label1.setIcon(hand);
        label1.setVisible(false);
        panel2.add(label1);

        // customizacja glownej ramki
        ramka.setIconImage(new ImageIcon("icon.jpg").getImage());
        ramka.setTitle("Aplikacja Demo");
        ramka.setResizable(false);
        ramka.add(BorderLayout.CENTER, mainPanel);
        ramka.add(BorderLayout.NORTH, checkBox);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(615, 615);
        ramka.setVisible(true);

        fill();
    }

    // zmiana stanu pasku progresu w komorce 1.
    public void fill() {

        int i = 0;
        while(i <= 100) {
            pbar.setValue(i);
            try {Thread.sleep(250);}
            catch (InterruptedException ex) {ex.printStackTrace();}
            i += 1;
        }
        pbar.setString("Koniec!");
    }

    // wylosowanie gradientu
    public GradientPaint losuj() {

        int czerwony = (int)(Math.random()*256);
        int zielony = (int)(Math.random()*256);
        int niebieski = (int)(Math.random()*256);
        Color kolorPoczatku = new Color(czerwony,zielony,niebieski);
        czerwony = (int)(Math.random()*256);
        zielony = (int)(Math.random()*256);
        niebieski = (int)(Math.random()*256);
        Color kolorKonca = new Color(czerwony,zielony,niebieski);
        return gradient = new GradientPaint(70,70,kolorPoczatku,150,150, kolorKonca);
    }

    public void actionPerformed(ActionEvent e) {

        // menu
        if(e.getSource() == loadItem) {
            System.out.println("Loaded a file");
        }
        else if(e.getSource() == saveItem) {
            System.out.println("Saved a file");
        }
        else if(e.getSource() == exitItem) {
            System.exit(0);
        }
        // combobox w komorce 1. komorki 1.
        else if(e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
        // radiobuttons w komorce 2. komorki 1.
        else if(e.getSource() == opcja1) {
            System.out.println("Wybrano opcje 1.");
        }
        else if(e.getSource() == opcja2) {
            System.out.println("Wybrano opcje 2.");
        }
        else if(e.getSource() == opcja3) {
            System.out.println("Wybrano opcje 3.");
        }
        // przycisk w zakladce 2. komorki 4.
        else if(e.getSource() == button2) {
            System.out.println("\nWitaj " + textField.getText() + "!");
            label1.setVisible(true);
            button2.setEnabled(false);
            textField.setEditable(false);
        }
    }

    // odczyt stanu termometru
    public void stateChanged(ChangeEvent e) {
        label2.setText("°C = " + slider.getValue());
    }

    // klasa wewnetrzna malujaca kolo z gradientem
    class MojPanelRysunkowy extends JPanel {

        public void paintComponent(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
            g2d.fillRect(0,0,this.getWidth(), this.getHeight());
            g2d.setPaint(gradient);
            g2d.fillOval(100,50,100,100);
        }
    }

    // obsluga zdarzen za pomoca klas wewnetrznych
    class ReakcjaNaPrzycisk1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            gradient = losuj();
            secondPanel.repaint();
        }
    }

    class ReakcjaNaPrzycisk2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            tekst.append("Przycisk kliknięto " + licznik + " raz!\n");
            licznik++;
        }
    }
}