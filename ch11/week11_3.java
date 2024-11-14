// 03 JToolBar, JOptionPane

package ch11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week11_3 extends JFrame {
    public week11_3() {
        super("툴바 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        JToolBar tBar = new JToolBar();
        JButton btn = new JButton("종료");
        btn.addActionListener(new CloseActionListner());

        tBar.add(btn);
        c.add(tBar, BorderLayout.NORTH);

        setSize(400, 400);
        setVisible(true);
    }

    class CloseActionListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        new week11_3();
    }
}
