package challenge;

import java.awt.*;
import javax.swing.*;

class NotrhPanel extends JPanel { // 상단 패널
    public NotrhPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.gray);

        JLabel label = new JLabel("수식입력");
        label.setForeground(Color.BLACK);

        JTextField tf = new JTextField(17);

        add(label);
        add(tf);
    }
}

class CenterPanel extends JPanel { // 중단 패널
    public CenterPanel() {
        setLayout(new GridLayout(4, 4, 5, 5));

        String buttons[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "계산", "+", "-", "x", "/"}; // 버튼 배열
        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]); // 버튼 배열에 있는 원소를 하나씩 버튼 지정
            if (i > 11) {
                button.setBackground(Color.yellow); // 사칙연산자 버튼은 색상을 노랑색으로
            }

            add(button); // 버튼 추가
        }
    }
}

class SouthPanel extends JPanel { // 하단 패널
    public SouthPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("계산결과");
        label.setForeground(Color.white);

        JTextField tf = new JTextField(17);
        tf.setEditable(false);

        add(label);
        add(tf);
    }
}

public class Week7_challenge extends JFrame{
    public Week7_challenge() {
        super("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new BorderLayout());
        c.add(new NotrhPanel(), BorderLayout.NORTH); // 상단 패널 붙이기
        c.add(new CenterPanel(), BorderLayout.CENTER); // 중단 패널 붙이기
        c.add(new SouthPanel(), BorderLayout.SOUTH); // 하단 패널 붙이기

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Week7_challenge();
    }
}
