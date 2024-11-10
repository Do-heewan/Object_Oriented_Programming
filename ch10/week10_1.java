// 01 paintComponent() 작성

package ch10;

import java.awt.*;
import javax.swing.*;

public class week10_1 extends JFrame{
    public week10_1() {
        super("삼색원 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new testPanel());
        setSize(300, 300);
        setVisible(true);
    }

    class testPanel extends JPanel{
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.YELLOW);
            g.fillArc(20, 20, 200, 200, -30, 120);
            g.setColor(Color.RED);
            g.fillArc(20, 20, 200, 200, 90, 120);
            g.setColor(Color.BLUE);
            g.fillArc(20, 20, 200, 200, 210, 120);
        }
    }

    public static void main(String[] args) {
        new week10_1();
    }
}


