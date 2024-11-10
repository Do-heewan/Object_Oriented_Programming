// 04 drawImage() 및 도형 칠하기 활용

package ch10;

import java.awt.*;
import javax.swing.*;

public class week10_4 extends JFrame {
    public week10_4() {
        super("라이언 얼굴 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new testPanel());
        setSize(300, 300);
        setVisible(true);
        }

    class testPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("src\\ch10\\images\\Lion.jpg");
        private Image image = icon.getImage();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.drawImage(image, 0, 0, 300, 300, this);

            g.setColor(Color.BLACK);
            g.fillRoundRect(90, 110, 40, 10, 10, 10);
            g.fillRoundRect(165, 110, 40, 10, 10, 10);
            g.fillOval(110, 130, 12, 12);
            g.fillOval(175, 130, 12, 12);
        }
    }

    public static void main(String[] args) {
        new week10_4();
    }
}
