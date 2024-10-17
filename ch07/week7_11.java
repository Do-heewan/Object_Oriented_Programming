// 11 GUI 기본 생성(GUI, Button)

package ch07;

import javax.swing.*;

public class week7_11 {
    public static void main(String[] args) {
        // JFrame 객체 생성
        JFrame frame = new JFrame("HelloWorld GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);

        // JButton 객체 생성
        JButton button = new JButton("Click Me!");
        button.addActionListener(e -> {
            // 버튼이 클릭되면 문장 출력
            JOptionPane.showMessageDialog(null, "Hello, World!");
        });

        // 버튼을 프레임에 추가
        frame.add(button);

        // 프레임을 화면에 표시
        frame.setVisible(true);
    }
}
