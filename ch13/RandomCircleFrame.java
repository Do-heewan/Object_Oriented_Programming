// 07 타이머 스레드와 그래픽, repaint()응용

package ch13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RandomCircleFrame extends JFrame{
    public RandomCircleFrame() {
        super("원을 0.5초 간격으로 랜덤한 위치로 이동시키는 스레드");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new CirclePanel());
        setSize(250, 250);
        setVisible(true);
    }

    class CirclePanel extends JPanel implements Runnable {
        private int x = 100;
        private int y = 100; // 원이 그려지는 위치

        public CirclePanel() {
            this.addMouseListener(new MouseAdapter() {
                private Thread th = null;
                public void mousePressed(MouseEvent e) {
                    th = new Thread(CirclePanel.this);
                    th.start();
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            g.drawOval(x, y, 50, 50);
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { return; }

                // 원 위치 재조정 및 다시그리기
                x = (int)(Math.random() * this.getWidth());
                y = (int)(Math.random() * this.getHeight());
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        new RandomCircleFrame();
    }
}
