// 02 drawOval() 활용

package ch10;

import java.awt.*;
import javax.swing.*;

public class week10_2 extends JFrame {
    public week10_2() {
        super("오륜기 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new testPanel());
        setSize(400, 400);
        setVisible(true);
        }

    class testPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.BLUE);
            g.drawOval(30, 100, 100, 100);
            g.setColor(Color.YELLOW);
            g.drawOval(86, 170, 100, 100);
            g.setColor(Color.BLACK);
            g.drawOval(140, 100, 100, 100);
            g.setColor(Color.GREEN);
            g.drawOval(196, 170, 100, 100);
            g.setColor(Color.RED);
            g.drawOval(250, 100, 100, 100);
        }
    }

    public static void main(String[] args) {
        new week10_2();
    }
}
