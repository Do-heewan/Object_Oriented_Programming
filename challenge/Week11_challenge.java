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
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.white);
        c.add(resultLabel);

        setSize(250, 200);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        private CalcDialog dialog;
        public void actionPerformed(ActionEvent e) {
            
        }

        public void actionPerformed(ActionEvent e) {

        }
    }

    class CalcDialog extends JDialog {
        private int sum = 0;
        private boolean bValid = false;
        private JTextField a = new JTextField(10);
        private JTextField b = new JTextField(10);
        private JButton mulBtn = new JButton("  Multiply    ");

        public CalcDialog(JFrame frame) {

        }

        public boolean isValid() {

        }

        public int getResult() {

        }

        public static void main(String[] args) {
            new Week11_challenge();
        }
    }
}
