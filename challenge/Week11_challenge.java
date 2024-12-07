package challenge;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Week11_challenge extends JFrame {
    private JLabel resultLabel = new JLabel("계산 결과 출력");
    public Week11_challenge() {
        super("다이얼로그 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Calculate");
        btn.addActionListener(new MyActionListener()); // 버튼을 누를 시 다이얼로그를 불러오기 위한 클래스 실행
        c.add(btn);

        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.white);
        c.add(resultLabel);

        setSize(250, 200);
        setVisible(true);
    }

    // 다이얼로그 불러오는 클래스
    class MyActionListener implements ActionListener {
        private CalcDialog dialog;
        public MyActionListener() {
            dialog = new CalcDialog(Week11_challenge.this);
        }

        public void actionPerformed(ActionEvent e) {
            dialog.setVisible(true);
        }
    }

    // 다이얼로그 생성
    class CalcDialog extends JDialog {
        private int mul = 0;
        private boolean bValid = false;
        private JLabel Label = new JLabel("두 수를 곱합니다.");
        private JTextField a = new JTextField(10);
        private JTextField b = new JTextField(10);
        private JButton mulBtn = new JButton("  Multiply    ");

        public CalcDialog(JFrame frame) {
            super(frame, "Calculator Dialog", true);
            setLayout(new FlowLayout());

            add(Label);
            add(a);
            add(b);
            add(mulBtn);

            setSize(200, 200);

            // 버튼에 리스너 달기
            mulBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resultLabel.setText(String.valueOf(getResult())); // 계산 결과를 setText
                    setVisible(false);
                }
            });
        }

        public boolean isValid() {
            return bValid;
        }

        public int getResult() {
            mul = Integer.valueOf(a.getText()) * Integer.valueOf(b.getText()); // 입력 받은 두 정수의 곱 반환
            return mul;
        }

        public static void main(String[] args) {
            new Week11_challenge();
        }
    }
}
