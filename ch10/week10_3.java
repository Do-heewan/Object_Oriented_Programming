// 03 drawPolygon() 활용

package ch10;

import java.awt.*;
import javax.swing.*;

public class week10_3 extends JFrame {
    public week10_3() {
        super("다각형 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new testPanel());
        setSize(215, 238);
        setVisible(true);
        }

    class testPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.ORANGE);
            int pol_x[] = {100, 0, 100, 200};
            int pol_y[] = {0, 100, 200, 100};
            g.drawPolygon(pol_x, pol_y, 4);

            g.setColor(Color.YELLOW);
            g.drawRect(25, 25, 150, 150);

            g.setColor(Color.MAGENTA);
            g.drawOval(30, 30, 140, 140);

            g.setColor(Color.RED);
            int tri_x[] = {100, 50, 150};
            int tri_y[] = {30, 150, 150};
            g.drawPolygon(tri_x, tri_y, 3);
        }
    }

    public static void main(String[] args) {
        new week10_3();
    }
}
