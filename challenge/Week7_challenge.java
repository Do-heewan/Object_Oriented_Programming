package challenge;

import java.awt.*;
import javax.swing.*;

class SouthPanel extends JPanel {
    public SouthPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("계산결과");
        label.setForeground(Color.white);

        JTextField tf = new JTextField(17);
        tf.setEditable(false);

        add(label);
        add(tf);
    }
}

class CenterPanel extends JPanel {
    public CenterPanel() {
        setLayout(new GridLayout(4, 4, 5, 5));

        String buttons[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "계산", "+", "-", "x", "/"};
        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            if (i > 11) {
                button.setBackground(Color.yellow);
            }

            add(button);
        }
    }
}

class NotrhPanel extends JPanel {
    public NotrhPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.gray);

        JLabel label = new JLabel("수식입력");
        label.setForeground(Color.BLACK);

        JTextField tf = new JTextField(17);

        add(label);
        add(tf);
    }
}

public class Week7_challenge extends JFrame{
    public Week7_challenge() {
        super("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new BorderLayout());
        c.add(new SouthPanel(), BorderLayout.SOUTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new NotrhPanel(), BorderLayout.NORTH);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Week7_challenge();
    }
}
