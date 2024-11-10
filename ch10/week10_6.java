// 01 paintComponent() 작성

package ch10;

import java.awt.*;
import javax.swing.*;

public class week10_6 extends JFrame{
    public week10_6() {
        super("마름모 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new testPanel());
        setSize(315, 335);
        setVisible(true);
    }

    class testPanel extends JPanel{
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            for (int i = 0; i < 10; i++) {
                int x[] = {165 + (15 * i), 150, 135 - (15 * i), 150};
                int y[] = {150, 165 + (15 * i), 150, 135 - (15 * i)};
                g.drawPolygon(x, y, 4);
            }
        }
    }

    public static void main(String[] args) {
        new week10_6();
    }
}


