package challenge;

import java.awt.*;
import javax.swing.*;

public class Week10_challenge extends JFrame{
    public Week10_challenge() {
        super("산리오 그리기 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new BorderLayout(5, 5));
        c.add(new MyPanel(), BorderLayout.CENTER);
        c.add(new TitlePanel(), BorderLayout.SOUTH);

        setSize(900, 510);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("src\\challenge\\images\\산리오.jpg");
        private Image image = icon.getImage();

        int row = 4;
        int col = 3;

        int imageX = icon.getIconWidth() / row;
        int imageY = icon.getIconHeight() / col;

        int padX = 10;
        int padY = 10;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = 0;
            int y = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j ++) {
                    g.drawImage(image, x, y, x + imageX, y + imageY, i * imageX, j * imageY, (i + 1) * imageX, (j + 1) * imageY, this);
                    y += imageY + padY;
                }
                x += imageX + padX;
                y = 0;
            }
        }
    }

    private class TitlePanel extends JPanel {
        public TitlePanel() {
            setLayout(new FlowLayout());
            setBackground(Color.white);

            JLabel label = new JLabel("SANRIO CHARACTERS");
            label.setForeground(Color.pink);

            add(label);
        }
    }

    public static void main(String[] args) {
        new Week10_challenge();
    }
}
