// 05 그래픽으로 도형 그리기

package ch10;

import java.awt.*;
import javax.swing.*;

public class week10_5 extends JFrame{
    public week10_5() {
        super("격자 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new testPanel());
        setSize(310, 335);
        setVisible(true);
    }

    class testPanel extends JPanel{
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);

            for (int i = 0; i < 10; i++) {
                g.drawLine(0, 30 * i, 300, 30 * i);
            }
            for (int j = 0; j < 10; j++) {
                g.drawLine(30 * j, 0, 30 * j, 300);
            }
        }
    }

    public static void main(String[] args) {
        new week10_5();
    }
}


