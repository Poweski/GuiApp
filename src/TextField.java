import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    TextField() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas", Font.PLAIN,35));
        textField.setForeground(Color.green);
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setText("username");


        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button) {
            System.out.println("Welcome " + textField.getText());
            button.setEnabled(false);
            textField.setEditable(false);
        }
    }
}
