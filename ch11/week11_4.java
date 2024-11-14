// 04 JToolBar, JOptionPane

package ch11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week11_4 extends JFrame {
    public week11_4() {
        super("숫자가 아닌 키가 입력되는 경우 경고장 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        JToolBar tBar = new JToolBar();
        JTextField tf = new JTextField(8);

        tf.addKeyListener(new MyKeyListener());

        tBar.add(new JLabel("학번 : "));
        tBar.add(tf);
        c.add(tBar, BorderLayout.SOUTH);

        setSize(400, 400);
        setVisible(true);
    }
    
    class MyKeyListener extends KeyAdapter {
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() < '0' || e.getKeyChar() > '9') { // 숫자키 판별
                String k = Character.toString(e.getKeyChar());
                k = k.concat("는 숫자 키가 아닙니다.\n숫자를 입력하시오.");
                JOptionPane.showMessageDialog(null, k, "경고", JOptionPane.ERROR_MESSAGE);
                e.consume();
            }
        }
    }

    public static void main(String[] args) {
        new week11_4();
    }
}
