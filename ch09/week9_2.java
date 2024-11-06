// 02 JComboBox와 JTextField의 Action 리스너 활용

package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week9_2 extends JFrame{
    private JComboBox<String> combo = new JComboBox<String>();
    private JTextField text = new JTextField(10);
    public week9_2() {
        super("ComboBox Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(text);
        c.add(combo);

        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField)e.getSource();
                combo.addItem(t.getText());
            }
        });

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new week9_2();
    }
}
