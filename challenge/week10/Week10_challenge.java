package challenge.week10;

import java.awt.*;
import javax.swing.*;

public class Week10_challenge extends JFrame{
    public Week10_challenge() {
        super("산리오 그리기 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new BorderLayout(5, 5)); // 
        c.add(new MyPanel(), BorderLayout.CENTER);
        c.add(new TitlePanel(), BorderLayout.SOUTH);

        setSize(900, 510);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("src/challenge/week10/산리오.jpg"); // 상대 경로 수정
        private Image image = icon.getImage();

        int row = 4; // 가로
        int col = 3; // 세로

        int imageX = icon.getIconWidth() / row; // 원본 이미지에서 나눌 이미지의 가로 길이
        int imageY = icon.getIconHeight() / col; // 원본 이미지에서 나눌 이미지의 세로 길이

        int padX = 10; // 패딩 설정
        int padY = 10;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 시작점
            int x = 0;
            int y = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j ++) {
                    g.drawImage(image, x, y, x + imageX, y + imageY, // (x, y) -> (x + imageX, y + imageY) 영역에 이미지 삽입
                    i * imageX, j * imageY, (i + 1) * imageX, (j + 1) * imageY, // 원본 이미지를 4 x 3으로 나누었을 때, 한 셀의 크기
                    this);
                    y += imageY + padY; // 다음 가져올 사진의 시작 지점을 옮김
                }
                x += imageX + padX; // 다음 가져올 사진의 시작 지점을 옮김
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
