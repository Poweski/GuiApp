import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox extends JFrame implements ActionListener {

    JButton button;
    JCheckBox checkBox;
    ImageIcon xIcon;
    ImageIcon checkMarkIcon;

    CheckBox() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        xIcon = new ImageIcon("x.png");
        checkMarkIcon = new ImageIcon("checkmark.png");

        button = new JButton("Submit");
        button.setText("submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("I'm not a robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas", Font.PLAIN,35));
        checkBox.setIcon(xIcon);
        checkBox.setSelectedIcon(checkMarkIcon);

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button) {
            System.out.println(checkBox.isSelected());
        }
    }
}
