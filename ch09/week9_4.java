// 04 실전 스윙 응용

package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class week9_4 extends JFrame{
    public week9_4() {
        super("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300,300);
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        private JLabel text;
        private JTextField tf;
        private JTextField money[] = new JTextField[9];
        private JButton btn;
        private JCheckBox cb[] = new JCheckBox[9];

        private int unit[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        private String cash[] = {"오만원", "만원", "오천원", "천원", "오백원", "백원", "오십원", "십원", "일원"};

        public MyPanel() {
            setBackground(Color.PINK);
            setLayout(null);

            // 금액 레이블
            text = new JLabel("금액");
            text.setHorizontalAlignment(JLabel.RIGHT);
            text.setSize(50, 20);
            text.setLocation(20, 20);
            add(text);

            // 금액 입력칸
            tf = new JTextField(10);
            tf.setSize(100, 20);
            tf.setLocation(100, 20);
            add(tf);

            // 계산 버튼
            btn = new JButton("계산");
            btn.setSize(70, 20);
            btn.setLocation(210, 20);
            add(btn);

            // 금액별 칸 생성 및 지정
            for (int i = 0; i < unit.length; i++) {
                text = new JLabel(cash[i]);
                text.setHorizontalAlignment(JLabel.RIGHT);
                text.setSize(50, 20);
                text.setLocation(50, 50 + 20 * i);
                add(text);

                money[i] = new JTextField(10);
                money[i].setHorizontalAlignment(JTextField.CENTER);
                money[i].setSize(70, 20);
                money[i].setLocation(120, 50 + 20 * i);
                add(money[i]);

                cb[i] = new JCheckBox(" ", true);
                cb[i].setOpaque(false);
                cb[i].setHorizontalAlignment(JCheckBox.CENTER);
                cb[i].setSize(30, 20);
                cb[i].setLocation(200, 50 + 20 * i);
                add(cb[i]);
            }

            // 계산 버튼의 Action 리스너
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String str = tf.getText();
                    if (str.length() == 0)
                        return;
                    
                    int m = Integer.parseInt(str);
                    int res;
                    for (int i = 0; i < unit.length; i++) {
                        if (i == unit.length - 1) {
                            res = m / unit[i];
                            money[i].setText(Integer.toString(res));
                            break;
                        }
                        if (!cb[i].isSelected()) {
                            money[i].setText("0");
                            continue;
                        }
                        res = m / unit[i];
                        money[i].setText(Integer.toString(res));
                        if (res > 0)
                            m = m % unit[i];
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new week9_4();
    }
}
